// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.util.Random;

public class tripleShot extends Attack {

	public tripleShot() {
		super.setAttackKey(4);
	}
	
	@Override
	public void attack(dungeonCharacter attacker, dungeonCharacter opponent) {
		System.out.println(attacker.getName() + " used Triple Shot!");
		Random randGen = new Random();
		double specialSuccess;
		int damageDealt;
		for (int eachShot = 1; eachShot < 4; eachShot++) {
			specialSuccess = randGen.nextDouble();
			if (specialSuccess <= .5) {
				damageDealt = randGen.nextInt(attacker.getMaxDamage()/2) + attacker.getMinDamage();
				System.out.println("Shot #" + eachShot + " hit!");
				opponent.subtractHitPoints(damageDealt);
				if (opponent.getHitPoints() == 0) {
					eachShot = 3;
				}
			} else {
				System.out.println("Shot #" + eachShot + " missed!\n");
			}
		}

	}

}
