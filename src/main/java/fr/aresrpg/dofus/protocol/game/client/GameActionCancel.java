package fr.aresrpg.dofus.protocol.game.client;

import fr.aresrpg.dofus.protocol.*;

/**
 * 
 * @since
 */
public class GameActionCancel implements ClientPacket {

	private int actionId;
	private String params;

	/**
	 * @param actionId
	 * @param params
	 */
	public GameActionCancel(int actionId, String params) {
		super();
		this.actionId = actionId;
		this.params = params;
	}

	/**
	 * @return the actionId
	 */
	public int getActionId() {
		return actionId;
	}

	/**
	 * @param actionId
	 *            the actionId to set
	 */
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	/**
	 * @return the params
	 */
	public String getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public void read(DofusStream stream) {
		this.actionId = stream.readInt();
		this.params = stream.read();
	}

	@Override
	public void write(DofusStream stream) {
		stream.allocate(2).writeInt(actionId).write(params);
	}

	@Override
	public void handleClient(ClientPacketHandler handler) {
		handler.handle(this);
	}

	@Override
	public String toString() {
		return "GameActionCancel [actionId=" + actionId + ", params=" + params + "]";
	}

}
