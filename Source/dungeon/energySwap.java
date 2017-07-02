// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.util.Random;

public class energySwap extends Attack {

	public energySwap() {
		super.setAttackKey(5);
	}
	
	@Override
	public void attack(dungeonCharacter attacker, dungeonCharacter opponent) {
		Random randGen = new Random();
		double specialSuccess = randGen.nextDouble();
		if (specialSuccess <= attacker.getChanceToHit()/2) {
			System.out.println(attacker.getName() + " swapped HP with " + opponent.getName());
			int tempHP = attacker.getHitPoints();
			attacker.setHitPoints(opponent.getHitPoints());
			opponent.setHitPoints(tempHP);
		} else {
			System.out.println("Energy Swap Failed!");
		}

	}

}
