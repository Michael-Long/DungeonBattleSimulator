// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

public class monsterFactory {

	private Attack basicAttack;
	
	public monsterFactory(Attack basic) {
		this.basicAttack = basic;
	}
	
	public Monster createMonster(int choice) {
		String name;
		int HP;
		int attackSpeed;
		double chanceToHit;
		int minDamage;
		int maxDamage;
		double chanceToHeal;
		int minHeal;
		int maxHeal;
		String attackType;
		if (choice == 1) {
			name = "Sargath the Skeleton";
			HP = 100;
			attackSpeed = 3;
			chanceToHit = .8;
			minDamage = 30;
			maxDamage = 50;
			chanceToHeal = .3;
			minHeal = 30;
			maxHeal = 50;
			attackType = name + " slices his rusty blade at ";
		} else if (choice == 2) {
			name = "Gnarltooth the Gremlin";
			HP = 70;
			attackSpeed = 6;
			chanceToHit = .8;
			minDamage = 15;
			maxDamage = 30;
			chanceToHeal = .4;
			minHeal = 20;
			maxHeal = 40;
			attackType = name + " jabs his kris at ";
		} else if (choice == 3) {
			name = "Oscar the Ogre";
			HP = 200;
			attackSpeed = 2;
			chanceToHit = .6;
			minDamage = 30;
			maxDamage = 50;
			chanceToHeal = .1;
			minHeal = 30;
			maxHeal = 50;
			attackType = name + " slowly swings a club towards ";
		} else if (choice == 4) {
			name = "Sourpatch the Red Dragon";
			HP = 150;
			attackSpeed = 1;
			chanceToHit = .6;
			minDamage = 40;
			maxDamage = 70;
			chanceToHeal = .2;
			minHeal = 40;
			maxHeal = 60;
			attackType = name + " breathes fire on ";
		} else if (choice == 5) {
			name = "Bently the Livid Hacker";
			HP = 50;
			attackSpeed = 10;
			chanceToHit = .9;
			minDamage = 20;
			maxDamage = 50;
			chanceToHeal = .8;
			minHeal = 10;
			maxHeal = 30;
			attackType = name + " pretends to be a Nigerian Prince to ";
		} else {
			name = "MissingNo.";
			HP = 1;
			attackSpeed = 1;
			chanceToHit = .1;
			minDamage = 0;
			maxDamage = 1;
			chanceToHeal = .1;
			minHeal = 0;
			maxHeal = 1;
			attackType = name + " uses <Insert Attack> on ";
		}
		return new Monster(name, HP, attackSpeed, chanceToHit, minDamage, maxDamage, chanceToHeal, minHeal, maxHeal, attackType, this.basicAttack);
	}
}
