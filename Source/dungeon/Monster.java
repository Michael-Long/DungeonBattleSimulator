// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.io.Serializable;

public class Monster extends dungeonCharacter implements Serializable{
	
	private double chanceToHeal;
	private int minHeal;
	private int maxHeal;
	
	public Monster(String name, int HP, int attackSpeed, double accuracy, int minDamage, int maxDamage,
			  double chanceToHeal, int minHeal, int maxHeal, String attackType, Attack basicAttack) {
		super.setName(name);
		super.setHitPoints(HP);
		super.setAttackSpeed(attackSpeed);
		super.setChanceToHit(accuracy);
		super.setMinDamage(minDamage);
		super.setMaxDamage(maxDamage);
		super.setAttackType(attackType);
		super.setBasicAttack(basicAttack);
		this.chanceToHeal = chanceToHeal;
		this.minHeal = minHeal;
		this.maxHeal = maxHeal;
	}
	
	public void setChanceToHeal(double newChanceToHeal) {
		chanceToHeal = newChanceToHeal;
	}
	
	public void setMinHeal(int newMinHeal) {
		minHeal = newMinHeal;
	}
	
	public void setMaxHeal(int newMaxHeal) {
		maxHeal = newMaxHeal;
	}
	
	protected void heal() {
		boolean canHeal;
		int healPoints;
		int tempHP;

		canHeal = (Math.random() <= chanceToHeal) && (super.getHitPoints() > 0);

		if (canHeal)
		{
			healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
			tempHP = addHitPoints(healPoints);
			System.out.println(getName() + " healed itself for " + healPoints + " points.\n"
								+ "Total hit points remaining are: " + tempHP);
			System.out.println();
			super.setHitPoints(tempHP);
		}
	}
}