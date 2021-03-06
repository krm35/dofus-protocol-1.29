/*******************************************************************************
 * BotFather (C) - Dofus 1.29 protocol library
 * This class is part of an AresRPG Project.
 *
 * @author Sceat {@literal <sceat@aresrpg.fr>}
 * @author Duarte David {@literal <deltaduartedavid@gmail.com>}
 * 
 *         Created 2016
 *******************************************************************************/
package fr.aresrpg.dofus.protocol.account.server;

import fr.aresrpg.dofus.protocol.*;
import fr.aresrpg.dofus.structures.character.Character;
import fr.aresrpg.dofus.structures.item.Item;

import java.util.StringJoiner;

public class AccountSelectCharacterOkPacket implements ServerPacket {
	private Character character;

	@Override
	public void read(DofusStream stream) {
		stream.read();//Skip separator
		long id = stream.readLong();
		String pseudo = stream.read();
		int level = stream.readInt();
		int guild = stream.readInt();
		int sex = stream.readInt();
		int gfxID = stream.readInt();
		int color1 = Integer.parseInt(stream.read(), 16);
		int color2 = Integer.parseInt(stream.read(), 16);
		int color3 = Integer.parseInt(stream.read(), 16);
		Item[] items = null;
		if (stream.available() > 0) {
			String[] rawItems = stream.read().split(";");
			items = new Item[rawItems.length];
			for (int i = 0; i < rawItems.length; i++)
				items[i] = Item.parseItem(rawItems[i]);
		}
		character = new Character(id, pseudo, level, guild, sex, gfxID, color1, color2, color3, items);
	}

	@Override
	public void write(DofusStream stream) {
		StringJoiner rawItems = new StringJoiner(";");
		if (character.getItems() != null)
			for (Item i : character.getItems())
			rawItems.add(Item.serializeItem(i));
		stream.allocate(11).write("") //Set separator
				.writeLong(character.getId())
				.write(character.getPseudo())
				.writeInt(character.getLevel())
				.writeInt(character.getGuild())
				.writeInt(character.getSex())
				.writeInt(character.getGfxId())
				.write(Integer.toString(character.getColor1(), 16))
				.write(Integer.toString(character.getColor2(), 16))
				.write(Integer.toString(character.getColor3(), 16))
				.write(rawItems.toString()); // Items
	}

	@Override
	public void handleServer(ServerPacketHandler handler) {
		handler.handle(this);
	}

	public Character getCharacter() {
		return character;
	}

	public AccountSelectCharacterOkPacket setCharacter(Character character) {
		this.character = character;
		return this;
	}

	@Override
	public String toString() {
		return "AccountSelectCharacterOkPacket(character=" + character +
				")[" + getId() + ']';
	}
}
