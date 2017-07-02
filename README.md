# DungeonBattleSimulator

Originally was the Final Project for CSCD349, but had been modified to include
more features beyond the scope of the assignment.

The project is a Battle Simulator between Hero Characters and Monster Characters. Each battle is X amount of heroes against X amount of monsters. There are 5 different types of heroes for the user to choose from, each of which have unique stats and special move. There are also 5 different possible monsters that are randomly choosen from, each of which with unique stats. The game finishes once either all the Heroes have run out of Hit Points, or all the Monsters have run out of Hit Points. There is a save/load feature allowing battles to be saved to a file, and can be loaded at a later point.

The code itself utilizes different Design Patterns to accomplish the working game:
- Strategy Pattern
- Factory Pattern
- Model View Controller
- Memento Pattern
- Flyweight Pattern

Future Planned Features:
- Gauntlet Mode: Create a team of 10 heros to enter 50 back to back battles, in which are increasing difficult.
- Custom Heros: The ability to create a custom hero, and to be able to save/load these heros.
- GUI: Move the game from being text-command based, to having a window and buttons.
