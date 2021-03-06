/*******************************************************************************
 * BotFather (C) - Dofus 1.29 protocol library
 * This class is part of an AresRPG Project.
 *
 * @author Sceat {@literal <sceat@aresrpg.fr>}
 * @author Duarte David {@literal <deltaduartedavid@gmail.com>}
 * 
 *         Created 2016
 *******************************************************************************/
package fr.aresrpg.dofus.structures.stat;

public class StatValue {
	private int base;
	private int equipment;
	private int dons;
	private int boost;
	private int total;

	public StatValue(int base, int equipment, int dons, int boost) {
		this(base, equipment, dons, boost, base + equipment + dons + boost);
	}

	public StatValue(int base, int equipment, int dons, int boost, int total) {
		this.base = base;
		this.equipment = equipment;
		this.boost = boost;
		this.dons = dons;
		this.total = total;
	}

	/**
	 * @param base
	 *            the base to set
	 */
	public void setBase(int base) {
		this.base = base;
	}

	/**
	 * @param equipment
	 *            the equipment to set
	 */
	public void setEquipment(int equipment) {
		this.equipment = equipment;
	}

	/**
	 * @param dons
	 *            the dons to set
	 */
	public void setDons(int dons) {
		this.dons = dons;
	}

	/**
	 * @param boost
	 *            the boost to set
	 */
	public void setBoost(int boost) {
		this.boost = boost;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	public int getBase() {
		return base;
	}

	public int getEquipment() {
		return equipment;
	}

	/**
	 * @return the dons
	 */
	public int getDons() {
		return dons;
	}

	/**
	 * @return the boost
	 */
	public int getBoost() {
		return boost;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "StatValue [base=" + base + ", equipment=" + equipment + ", dons=" + dons + ", boost=" + boost + ", total=" + total + "]";
	}

}
