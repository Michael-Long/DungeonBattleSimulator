// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

public class basicAttack extends Attack {
	
	public basicAttack() {
		super.setAttackKey(0);
	}
	
	@Override
	public void attack(dungeonCharacter attacker, dungeonCharacter opponent) {
		System.out.println(attacker.getAttackType() + opponent.getName() + ":");
  		boolean canAttack;
  		int damage;
  		canAttack = Math.random() <= attacker.getChanceToHit();
  		if (canAttack)
  		{
  			damage = (int)(Math.random() * (attacker.getMaxDamage() - attacker.getMinDamage() + 1))
  						+ attacker.getMinDamage();
  			opponent.subtractHitPoints(damage);
  			System.out.println();
  		}
  		else
  		{
  			System.out.println(attacker.getName() + "'s attack on " + opponent.getName() +
  								" failed!");
  			System.out.println();
  		}
	}
}
