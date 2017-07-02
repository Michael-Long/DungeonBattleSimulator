// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.io.Serializable;

public abstract class dungeonCharacter implements Serializable{

	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int minDamage;
	private int maxDamage;
	private String attackType;
	private Attack basicAttack;
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}

	public int getHitPoints() {
		return hitPoints;
	}
	
	public void setHitPoints(int newHitPoints) {
		hitPoints = newHitPoints;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}
	
	public void setAttackSpeed(int newAttackSpeed) {
		attackSpeed = newAttackSpeed;
	}

	public double getChanceToHit() {
		return chanceToHit;
	}
	
	public void setChanceToHit(double newChanceToHit) {
		chanceToHit = newChanceToHit;
	}

	public int getMinDamage() {
		return minDamage;
	}
	
	public void setMinDamage(int newMinDamage) {
		minDamage = newMinDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}
	
	public void setMaxDamage(int newMaxDamage) {
		maxDamage = newMaxDamage;
	}
	
	public void setBasicAttack(Attack basic) {
		this.basicAttack = basic;
	}
	
	public Attack getBasicAttack() {
		return this.basicAttack;
	}
	
	public String getAttackType() {
		return this.attackType;
	}
	
	public void setAttackType(String attackType) {
		this.attackType = attackType;
	}
	
    public boolean isAlive() {
  	  return (getHitPoints() > 0);
    }
	
	protected void subtractHitPoints(int damageTaken) {
		int tempHP = getHitPoints();
		if (damageTaken <0) {
			System.out.println("Hitpoint amount must be positive.");		
		} else if (damageTaken >0)	{
			tempHP = tempHP - damageTaken;
			if (tempHP < 0)
				tempHP = 0;
			hitPoints = tempHP;
			System.out.println(getName() + " has" +
					" taken <" + damageTaken + "> points damage.");
			System.out.println(getName() + " now has " +
					getHitPoints() + " hit points remaining.");
			System.out.println();
		}
		if (tempHP== 0)
			System.out.println(getName() + " has been killed :-(");	
		hitPoints = tempHP;
	}
	
	protected int addHitPoints(int hitPoints) {
		if (hitPoints <=0) {
			System.out.println("Hitpoint amount must be positive.");
			return 0;
		} else if (getHitPoints() + hitPoints > 200) {
			System.out.println("Max HP Reached.");
			return 200;
		} else	{
			return getHitPoints() + hitPoints;
		}
	}
	
  	public void attack(dungeonCharacter opponent) {
  		basicAttack.attack(this, opponent);
  	}    	
}
