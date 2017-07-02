// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.io.Serializable;

public abstract class Attack implements Serializable{

	private int attackKey;
	
	public int getAttackKey() {
		return this.attackKey;
	}
	
	protected void setAttackKey(int key) {
		this.attackKey = key;
	}
	
	public abstract void attack(dungeonCharacter attacker, dungeonCharacter opponent);
	
}
