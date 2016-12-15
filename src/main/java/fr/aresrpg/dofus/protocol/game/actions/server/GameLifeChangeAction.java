package fr.aresrpg.dofus.protocol.game.actions.server;

import fr.aresrpg.dofus.protocol.DofusStream;
import fr.aresrpg.dofus.protocol.game.actions.GameAction;
import fr.aresrpg.dofus.util.Convert;

/**
 * 
 * @since
 */
public class GameLifeChangeAction implements GameAction {

	private int entity;
	private int life;

	public GameLifeChangeAction() {
	}

	/**
	 * @param sprite
	 * @param life
	 */
	public GameLifeChangeAction(int entity, int life) {
		this.entity = entity;
		this.life = life;
	}

	/**
	 * @return the entity
	 */
	public int getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(int entity) {
		this.entity = entity;
	}

	/**
	 * @return the life
	 */
	public int getLife() {
		return life;
	}

	/**
	 * @param life
	 *            the life to set
	 */
	public void setLife(int life) {
		this.life = life;
	}

	@Override
	public void read(DofusStream stream) {
		String[] data = stream.read().split(",");
		this.entity = Convert.toInt(data[0]);
		this.life = Convert.toInt(data[1]);
	}

	@Override
	public void write(DofusStream stream) {
		stream.allocate(1).write(entity + "," + life);
	}

	@Override
	public String toString() {
		return "LifeChangeAction [entity=" + entity + ", life=" + life + "]";
	}

}
