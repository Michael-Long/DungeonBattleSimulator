// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.util.Scanner;

public class heroFactory {

	private attackFactory attacks;
	
	public heroFactory(attackFactory factoryRef) {
		attacks = factoryRef;
	}
	
	public Hero createHero(int choice) {
		int HP;
		int attackSpeed;
		double chanceToHit;
		int minDamage;
		int maxDamage;
		double chanceToBlock;
		String attackType;
		String specialAttackName;
		Attack specialAttack;
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter Hero Name: ");
		String name = kb.nextLine();
		if (choice == 1) {
			HP = 125;
			attackSpeed = 4;
			chanceToHit = .8;
			minDamage = 35;
			maxDamage = 60;
			chanceToBlock = .2;
			attackType = name + " swings a mighty sword at ";
			specialAttackName = "Crushing Blow";
			specialAttack = attacks.getAttack(1);
		} else if (choice == 2) {
			HP = 75;
			attackSpeed = 5;
			chanceToHit = .7;
			minDamage = 25;
			maxDamage = 50;
			chanceToBlock = .3;
			attackType = name + " casts a spell of fireball at ";
			specialAttackName = "Cure Wounds";
			specialAttack = attacks.getAttack(2);
		} else if (choice == 3) {
			HP = 75;
			attackSpeed = 6;
			chanceToHit = .8;
			minDamage = 20;
			maxDamage = 40;
			chanceToBlock = .5;
			attackType = name + " stabs with their dagger at ";
			specialAttackName = "Surprise Attack";
			specialAttack = attacks.getAttack(3);
		} else if (choice == 4) {
			HP = 90;
			attackSpeed = 8;
			chanceToHit = .75;
			minDamage = 15;
			maxDamage = 80;
			chanceToBlock = .1;
			attackType = name + " fires an arrow at ";
			specialAttackName = "Triple Shot";
			specialAttack = attacks.getAttack(4);
		} else if (choice == 5) {
			HP = 100;
			attackSpeed = 5;
			chanceToHit = .7;
			minDamage = 20;
			maxDamage = 40;
			chanceToBlock = .3;
			attackType = name + " steals some energy from ";
			specialAttackName = "Energy Swap";
			specialAttack = attacks.getAttack(5);
		} else {
			HP = 1;
			attackSpeed = 1;
			chanceToHit = .1;
			minDamage = 0;
			maxDamage = 1;
			chanceToBlock = .1;
			attackType = name + " uses <Insert Attack> ";
			specialAttackName = "MissingNo.";
			specialAttack = attacks.getAttack(0);
		}
		return new Hero(name, HP, attackSpeed, chanceToHit, minDamage, maxDamage, chanceToBlock,
				attackType, specialAttackName, specialAttack, attacks.getAttack(0));
	}
}
