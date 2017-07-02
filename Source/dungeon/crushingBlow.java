// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

public class crushingBlow extends Attack {

	public crushingBlow() {
		super.setAttackKey(1);
	}
	
	@Override
	public void attack(dungeonCharacter attacker, dungeonCharacter opponent) {
		if (Math.random() <= .4)
		{
			int damage = (int)(Math.random() * 76) + 100;
			System.out.println(attacker.getName() + " lands a CRUSHING BLOW for " + damage
								+ " damage!");
			opponent.subtractHitPoints(damage);  // Changed BlowPoints to Damage
		}
		else
		{
			System.out.println(attacker.getName() + " failed to land a crushing blow");
			System.out.println();
		}

	}

}
