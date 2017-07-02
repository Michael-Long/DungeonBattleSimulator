// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.io.Serializable;

public class ModelViewController implements Serializable {

	private transient View displayView;
	
	public ModelViewController() {
		this.displayView = new View();
	}
	
	public void kickStart() {
		displayView = new View();
	}
	
	public void welcome() {
		displayView.welcome();
	}
	
	public int startMenu() {
		return displayView.startMenu();
	}
	
	public int heroSelect() {
		return displayView.heroSelect();
	}
	
	public int heroOption(String name, String specialAttack, int HP) {
		return displayView.heroOption(name, specialAttack, HP);
	}
	
	public String midQuit() {
		return displayView.midQuit();
	}
}
