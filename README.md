# Battleship
# 4/30/2026

This program is a Java based recreation of the game Battleship which I created for my Performance Task for AP Computer Science Principles.

The project has 3 classes:

### Main.java
- Runs the main loop
- Gets user input
- Sends coordinates to game logic

### Ships.java
- Stores ship names, sizes, and coordinates  
- Randomly places each ship on the board  
- Removes positions when they’re hit  
- Tracks when a ship is sunk

### TheGame.java
- Checks if the user’s guess is a hit, miss, or already chosen  
- Updates the board with X (hit) or O (miss)  
- Prints randomized messages  
- Keeps track of when all ships are sunk  
