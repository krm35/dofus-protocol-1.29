package fr.aresrpg.dofus.protocol.game.actions.client;

import fr.aresrpg.dofus.protocol.DofusStream;
import fr.aresrpg.dofus.protocol.game.actions.GameAction;

/**
 * 
 * @since
 */
public class GameDuelAction implements GameAction {

	private int targetId;

	/**
	 * @param targetId
	 */
	public GameDuelAction(int targetId) {
		this.targetId = targetId;
	}

	public GameDuelAction() {
	}

	@Override
	public void read(DofusStream stream) {
		this.targetId = stream.readInt();
	}

	@Override
	public void write(DofusStream stream) {
		stream.allocate(1).writeInt(targetId);
	}

	/**
	 * @return the targetId
	 */
	public int getTargetId() {
		return targetId;
	}

	/**
	 * @param targetId
	 *            the targetId to set
	 */
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	@Override
	public String toString() {
		return "GameDuelAction [targetId=" + targetId + "]";
	}

}