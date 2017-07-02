// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.util.*;

/*
  This class is the driver file for the Dungeon Battle Simulator project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class Dungeon
{
	
	private static ModelViewController MVC = new ModelViewController();
	
    public static void main(String[] args)
	{
    	Scanner kb = new Scanner(System.in);
    	int choice;
    	boolean successLoad;
    	boolean runtime = true;
    	MVC.welcome();
	    do {	
			choice = MVC.startMenu();
			switch (choice) {
				case 1:
					newGame();
					runtime = playAgain();
					break;
				case 2:
					successLoad = loadGame();
					if (successLoad == true) {
						runtime = playAgain();
						break;
					}
					break;
				case 3:
					return;
			}
	    } while (runtime);

    }
    
    public static boolean loadGame() {
    	saveLoadGame saveState = new saveLoadGame();
    	Scanner kb = new Scanner(System.in);
		System.out.print("Enter File Name (Don't include extention): ");
		String fileName = kb.nextLine() + ".txt";
		return saveState.loadSaveState(fileName);
    }
    
    public static void newGame() {
    	
    	battleManager battle = new battleManager();
    	attackFactory attacks= new attackFactory(battle);
    	Scanner kb = new Scanner(System.in);
    	dungeonCharGroup heroGroup;
    	dungeonCharGroup monsterGroup;
    	int size;
    	while(true) {
    		try {    			
    			System.out.print("Enter Hero Party Size: ");
    			size = kb.nextInt();
    			if (size <= 0) {
    				throw new InputMismatchException("Invalid Party Size");
    			}
    			heroGroup = new dungeonCharGroup(size);
    			System.out.print("Enter Monster Party Size: ");
    			size = kb.nextInt();
    			if (size <= 0) {
    				throw new InputMismatchException("Invalid Party Size");
    			}
    			monsterGroup = new dungeonCharGroup(size);
    			break;
    		} catch (Exception e) {
    			System.out.println(e.getMessage() + "\n");
    			kb.nextLine();
    		}
    	}
    	
		    heroGroup = chooseHeroes(heroGroup, attacks);
		    monsterGroup = generateMonsters(monsterGroup, attacks);
		    battle(battle, heroGroup, monsterGroup);

    }

	public static dungeonCharGroup chooseHeroes(dungeonCharGroup heroGroup, attackFactory attacks)
	{
		boolean runtime = false;
		for (int group = 0; group < heroGroup.getSize(); group++) {
			int choice;
			runtime = true;
			heroFactory makeCharacter = new heroFactory(attacks);
			choice = MVC.heroSelect();
			heroGroup.addDungeonChar(makeCharacter.createHero(choice));
		}
		return heroGroup;
	}

	public static dungeonCharGroup generateMonsters(dungeonCharGroup monsterGroup, attackFactory attacks) {
		for (int group = 0; group < monsterGroup.getSize(); group++) {
			int choice;
			monsterFactory makeCharacter = new monsterFactory(attacks.getAttack(0));
			Random randomGen = new Random();
	
			choice = randomGen.nextInt(5) + 1;
			monsterGroup.addDungeonChar(makeCharacter.createMonster(choice));
		}
		return monsterGroup;
	}
	
	public static boolean playAgain()
	{
		String tempString;
		char again;
		Scanner kb = new Scanner(System.in);

		System.out.println("Play again (y/n)?");
		tempString = kb.nextLine();
		if (tempString.length() == 0) {
			again = 'y';
		} else {
			again = tempString.charAt(0);
		}
		return (again == 'Y' || again == 'y');
	}
	
	public static void battle(battleManager battle, dungeonCharGroup heroGroup, dungeonCharGroup monsterGroup) {
		battle.startBattle(heroGroup, monsterGroup);
	}
}
		
		
		
		
		