// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

public class surpriseAttack extends Attack {

	private battleManager battleRef;
	
	public surpriseAttack(battleManager battle) {
		super.setAttackKey(3);
		this.battleRef = battle;
	}
	
	@Override
	public void attack(dungeonCharacter attacker, dungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								attacker.getName() + " gets an additional turn.");
			battleRef.setCycle(battleRef.getCycle() - 1);
			attacker.attack(opponent);
		}
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else {
			System.out.println(attacker.getName() + " managed to land a hit, but was spotted by " + opponent.getName());
		    attacker.attack(opponent);
		}
	}

}
