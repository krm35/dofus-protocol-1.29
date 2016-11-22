package fr.aresrpg.dofus.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Arrays;
import java.util.Iterator;

public class DofusConnection<T extends SelectableChannel & ByteChannel> {
	public static final char DELIMITER = '\0';
	public static final char SEPARATOR = '|';

	private final T channel;
	private final Selector selector;
	private final PacketHandler handler;
	private final ByteBuffer buffer = ByteBuffer.allocate(512);
	private StringBuilder currentPacket = new StringBuilder();

	public DofusConnection(T channel, PacketHandler handler) throws IOException {
		this.selector = Selector.open();
		this.channel = channel;
		this.handler = handler;
		this.handler.register(this);
		this.channel.configureBlocking(false);
		this.channel.register(selector, SelectionKey.OP_READ);
	}

	public void read() throws IOException {
		this.selector.select();
		Iterator<SelectionKey> iter = this.selector.selectedKeys().iterator();
		while (iter.hasNext()) {
			SelectionKey key = iter.next();
			iter.remove();
			if (key.isReadable()) {
				ByteChannel channel = (ByteChannel) key.channel();
				boolean decode = false;
				while(true) {
					read: while(buffer.position() > 0 || channel.read(buffer) > 0 ) {
						int read = buffer.position();
						buffer.flip();
						byte[] bytes = new byte[read];
						buffer.get(bytes);
						buffer.clear();
						for(int i = 0; i < bytes.length ; i++){
							if(bytes[i] == DELIMITER){
								i++;
								decode = true;
								buffer.put(bytes , i , bytes.length - i);
								currentPacket.append(new String(bytes, 0 , i));
								break read;
							}
						}

						currentPacket.append(new String(bytes));
					}

					if (decode) {
						currentPacket.deleteCharAt(currentPacket.length() - 1); // Remove \0
						String packet = currentPacket.toString();
						//System.out.println("[RECEIVE] <- " + packet);
						currentPacket = new StringBuilder();
						String[] parts = packet.split("\\" + SEPARATOR);
						ProtocolRegistry registry;
						switch (parts[0].length()) {
							case 2:
								registry = ProtocolRegistry.getRegistry(parts[0].substring(0 , 2) , false);
								break;
							default:
								registry = ProtocolRegistry.getRegistry(parts[0].substring(0 , 3) , false);
								break;
						}
						if (registry != null) {
							parts[0] = parts[0].substring(registry.getId().length());// Remove id
							try {
								Packet p = registry.getPacket().newInstance();
								p.read(new StringDofusStream(parts));
								p.handle(handler);
							} catch (ReflectiveOperationException e) {
								e.printStackTrace();
							}
						}
					}
					if (buffer.position() == 0)
						break;

				}
			}
		}
	}

	public void send(Packet packet) throws IOException {
		StringDofusStream stream = new StringDofusStream();
		packet.write(stream);
		StringBuilder sb = new StringBuilder();
		boolean indexAtEnd = ProtocolRegistry.getRegistry(packet.getClass()).isIndexAtEnd();
		String[][] outs = stream.getOut();
		if(!indexAtEnd){
			sb.append(packet.getId());
		}
		for(int i = 0; i < outs.length ; i++){
			String[] out = outs[i];

			if(!indexAtEnd && i == 0 && out.length > 1)
				sb.append(SEPARATOR);
			if(out != null){
				for(int y = 0 ; y < out.length ; y++) {
					sb.append(out[y]);
					if(y != out.length -1)
						sb.append(SEPARATOR);
				}
			}
			if(i == outs.length -1 && indexAtEnd)
				sb.append(packet.getId());
			sb.append('\n').append(DELIMITER);
		}
		//System.out.println("[SEND] -> " + sb.toString());
		channel.write(ByteBuffer.wrap(sb.toString().getBytes()));
	}

	public T getChannel() {
		return channel;
	}
}