// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.io.*;
import java.util.*;

public class saveLoadGame {

	private Scanner kb;
	
	public saveLoadGame() {
		kb = new Scanner(System.in);
	}
	
	public void createSaveState(battleManager battle, dungeonCharGroup heroGroup, dungeonCharGroup monsterGroup, ModelViewController MVC) {
		try {
			System.out.print("\nName of Save State? : ");
			String fileName = kb.nextLine();
			fileName = fileName + ".txt";
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
			output.writeObject(heroGroup);
			output.writeObject(monsterGroup);
			output.writeObject(battle);
			output.writeObject(MVC);
			output.close();
			System.out.println("Game saved to: " + fileName);		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean loadSaveState(String fileName) {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
			dungeonCharGroup heroGroup = (dungeonCharGroup) input.readObject();
			dungeonCharGroup monsterGroup = (dungeonCharGroup) input.readObject();
			battleManager battle = (battleManager) input.readObject();
			ModelViewController MVC = (ModelViewController) input.readObject();
			MVC.kickStart();
			battle.kickStart(MVC);
			battle.startBattle(heroGroup, monsterGroup);
			return true;
		} catch (InvalidClassException e) {
			System.out.println("Old Save File, start a new game please.");
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
