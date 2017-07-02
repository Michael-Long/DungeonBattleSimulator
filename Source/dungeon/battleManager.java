// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.io.Serializable;

public class battleManager implements Serializable {

	private int cycler;
	private transient saveLoadGame fileManager;
	private transient ModelViewController MVC;
	private int target;
	
	public battleManager() {
		cycler = 0;
		target = 0;
		this.fileManager = new saveLoadGame();
		this.MVC = new ModelViewController();
	}
	
	public void kickStart(ModelViewController MVC) {
		this.fileManager = new saveLoadGame();
		this.MVC = MVC;
	}
	
	public void setCycle(int cycle) {
		this.cycler = cycle;
	}
	
	public int getCycle() {
		return this.cycler;
	}
	
	public void startBattle(dungeonCharGroup heroGroup, dungeonCharGroup monsterGroup) {
		String tempString;
		char pause = 'p';
		Hero heroCursor;
		Monster monsterCursor;
		boolean runtime;
		System.out.println(heroGroup.partyNames() + " -VS- " +
							monsterGroup.partyNames());
		System.out.println("---------------------------------------------");
		
		while (heroGroup.partyAlive() && monsterGroup.partyAlive() && pause != 'q')
		{	
			while (cycler < heroGroup.getSize()) {
				if (heroGroup.characterAlive(cycler) && monsterGroup.partyAlive()) {
					heroCursor = (Hero) heroGroup.getCharacter(cycler);
					
					runtime = true;
					if (cycler >= monsterGroup.getSize()) {
						target = monsterGroup.getSize() - 1;
					} else {
						target = cycler;
					}
					do { // Target Selection
						if (!monsterGroup.characterAlive(target)) {
							target++;
							if (target == monsterGroup.getSize()) {
								target = 0;
							}
						} else {
							runtime = false;
						}
					} while(runtime == true && monsterGroup.partyAlive());
					
					int choice;
				    choice = MVC.heroOption(heroCursor.getName(), heroCursor.getSpecialAttackName(), heroCursor.getHitPoints());
					    switch (choice)
					    {
						    case 1: 
						    	heroCursor.attack(monsterGroup.getCharacter(target));
						        break;
						    case 2: 
						    	heroCursor.specialAttack(monsterGroup.getCharacter(target)); 
						        break;
						    case 3:
						    	fileManager.createSaveState(this, heroGroup, monsterGroup, MVC);
						    	cycler--;
						    	break;
						    case 4:
						    	return;
					    }
				}
			cycler++;
			}
			cycler = 0;
			for (cycler = 0; cycler < monsterGroup.getSize(); cycler++) {
				if (monsterGroup.characterAlive(cycler) && heroGroup.partyAlive()) {
					monsterCursor = (Monster) monsterGroup.getCharacter(cycler);
					
					runtime = true;
					if (cycler >= heroGroup.getSize()) {
						target = heroGroup.getSize() - 1;
					} else {
						target = cycler;
					}
					do { // Target Selection
						if (!heroGroup.characterAlive(target)) {
							target++;
							if (target >= heroGroup.getSize()) {
								target = 0;
							}
						} else {
							runtime = false;
						}
					} while(runtime == true && heroGroup.partyAlive());
				
					monsterCursor.attack(heroGroup.getCharacter(target));
					if (heroGroup.partyAlive()) {
						monsterCursor.heal();
					}
				}
			}
			tempString = MVC.midQuit(); 
			if (tempString.length() == 0) {
				pause = 'g';
			} else {
				pause = tempString.charAt(0);
			}
			cycler = 0;
		}

		if (!monsterGroup.partyAlive())
		    System.out.println(heroGroup.partyNames() + " was victorious!");
		else if (!heroGroup.partyAlive())
			System.out.println(heroGroup.partyNames() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");

    }
}
