// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

	private transient static Scanner kb;
	
	public View() {
		kb = new Scanner(System.in);
	}
	
	public void welcome() {
		System.out.println("Welcome to Dungeon Battle Simulator!");
	}
	
	public int startMenu() {
		while(true) {
    		try {
    			System.out.println("\t1. New Game");
    			System.out.println("\t2. Load Game from File");
    			System.out.println("\t3. Quit Game");
    			System.out.print("Choice: ");
    			int choice = kb.nextInt();
    			if (choice < 0 && choice > 3) {
    				System.out.println("Not an option...");
    			} else {
    				return choice;
    			}
    		} catch (InputMismatchException e) {
    			System.out.println("Invalid Choice...");
    			kb.nextLine();
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    		}
    	}
	}
	
	public int heroSelect() {
		while (true) {
			try {
				System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief\n" +
						   "4. Ranger\n" +
						   "5. Energy Manipulator");
				int choice = kb.nextInt();
				if (choice > 0 && choice < 6) {
					kb.nextLine();
					return choice;
				} else {
					throw new InputMismatchException("Invalid choice");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Choice");
				kb.nextLine();
			}
		}
	}
	
	public int heroOption(String name, String specialAttack, int HP) {
		while (true) { 
	    	try {
	    			System.out.println(name + " Turn!\t Current HP: " + HP);
	    			System.out.println("\t1. Attack Opponent");
	    			System.out.println("\t2. " + specialAttack);
	    			System.out.println("\t3. Save Game");
	    			System.out.println("\t4. End Battle");
	    			System.out.print("Choose an option: ");
	    			int choice = kb.nextInt();
	    			if (choice < 5 && choice > 0) {
	    				return choice;
	    			}
	    			throw new InputMismatchException("Invalid Choice");
	    	} catch (Exception e) {
	    		System.out.println("Invalid Choice...");
	    		kb.nextLine();
	    	}
	    }
	}
	
	public String midQuit() {
		kb.nextLine();
		System.out.print("\n-->q to quit, anything else to continue: ");
		return kb.nextLine();
	}
}
