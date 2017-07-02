// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.util.ArrayList;

public class attackFactory {

	private ArrayList<Attack> attacks;
	
	public attackFactory(battleManager battle) {
		attacks = new ArrayList<Attack>();
		attacks.add(new basicAttack());
		attacks.add(new crushingBlow());
		attacks.add(new healWounds());
		attacks.add(new surpriseAttack(battle));
		attacks.add(new tripleShot());
		attacks.add(new energySwap());
	}
	
	public Attack getAttack(int key) {
		for(Attack attackSearch : attacks) {
			if (attackSearch.getAttackKey() == key) {
				return attackSearch;
			}
		}
		return attacks.get(0);
	}
}
