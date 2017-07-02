// Michael Long
// CSCD 349
// Spring 2017

package dungeon;

import java.io.Serializable;

public class dungeonCharGroup implements Serializable{

	private dungeonCharacter[] group;
	private boolean partyAlive;
	
	public dungeonCharGroup(int size) {
		this.group = new dungeonCharacter[size];
		this.partyAlive = true;
	}
	
	public void addDungeonChar(dungeonCharacter newChar) {
		int cursor = 0;
		while (group[cursor] != null && cursor < group.length) {
			cursor++;
		}
		if (cursor < group.length) {
			group[cursor] = newChar;
		} else {
			System.out.println("Party is full!");
		}
	}
	
	public int getSize() {
		return group.length;
	}
	
	public dungeonCharacter getCharacter(int index) {
		if (index >= 0 && index < group.length) {
			return group[index];
		} else {
			return group[0];
		}
	}
	
	public boolean partyAlive() {
		if (partyAlive == false) {
			return partyAlive;
		}
		boolean livingCheck = false;
		for (int cursor = 0; cursor < group.length; cursor++) {
			if (group[cursor].isAlive() == true) {
				livingCheck = true;
			}
		}
		partyAlive = livingCheck;
		return partyAlive;
	}
	
	public boolean characterAlive(int index) {
		if (index >= 0 && index < group.length) {
			return group[index].isAlive();
		} else {
			return false;
		}
	}
	
	public String partyNames() {
		String nameList = "";
		for (int cursor = 0; cursor < group.length; cursor++) {
			nameList = nameList + group[cursor].getName() + ", ";
		}
		return nameList;
	}
		
}
