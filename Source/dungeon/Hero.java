// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.io.Serializable;
import java.util.Scanner;

public class Hero extends dungeonCharacter implements Serializable{
	
	private double chanceToBlock;
	private String specialAttackName;
	private Attack specialAttack;
	
	public Hero(String name, int HP, int attackSpeed, double accuracy, int minDamage, int maxDamage,
						  double chanceToBlock, String attackType, String specialAttackName, Attack specialAttack, Attack basicAttack) {
		super.setName(name);
		super.setHitPoints(HP);
		super.setAttackSpeed(attackSpeed);
		super.setChanceToHit(accuracy);
		super.setMinDamage(minDamage);
		super.setMaxDamage(maxDamage);
		super.setAttackType(attackType);
		super.setBasicAttack(basicAttack);
		this.chanceToBlock = chanceToBlock;
		this.specialAttackName = specialAttackName;
		this.specialAttack = specialAttack;
	}
	
	public void setChanceToBlock(double newChanceToBlock) {
		chanceToBlock = newChanceToBlock;
	}

   protected boolean defend(double blockChance) {
		return Math.random() <= blockChance;
   }
  
   public void specialAttack(dungeonCharacter opponent) {
	   specialAttack.attack(this, opponent);
   }
   
   public String getSpecialAttackName() {
		   return specialAttackName;
   }
   
   @Override
	protected void subtractHitPoints(int damageTaken) {
		int tempHP = super.getHitPoints();
		if (damageTaken <0) {
			System.out.println("Hitpoint amount must be positive.");		
		} else if (defend(chanceToBlock)) {
				System.out.println(super.getName() + " BLOCKED the attack!");
		} else if (damageTaken >0)	{
			tempHP = tempHP - damageTaken;
			if (tempHP < 0)
				tempHP = 0;
			System.out.println(super.getName() + " has " +
					" taken <" + damageTaken + "> points damage.");
			System.out.println(super.getName() + " now has " +
					tempHP + " hit points remaining.");
			System.out.println();
		}
		if (tempHP== 0)
			System.out.println(super.getName() + " has been killed :-(");	
		super.setHitPoints(tempHP);
	}
}