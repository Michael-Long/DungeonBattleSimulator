// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

public class healWounds extends Attack {

	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;
	
	public healWounds() {
		super.setAttackKey(2);
	}	
	
	@Override
	public void attack(dungeonCharacter attacker, dungeonCharacter opponent) {
	    int gainedHP;
		gainedHP = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		attacker.setHitPoints(attacker.addHitPoints(gainedHP));
		System.out.println(attacker.getName() + " added [" + gainedHP + "] points.\n"
							+ "Total hit points remaining are: "
							+ attacker.getHitPoints());
		 System.out.println();

	}

}
