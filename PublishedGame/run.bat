@ECHO OFF
SET BINDIR=%~dp0
CD /D "%BINDIR%"
"%ProgramFiles%\Java\jre1.8.0_131\bin\java.exe" -jar DungeonBattleSimulator.jar
PAUSE