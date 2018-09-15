RemiTile Game:
  - Display class is the entry point for GUI.
     - When you run the gui, each player has already 14 cards given to
       play with.
     - Initally, its human's turn. Just click on the tilePool and
       it will add the tile to the human's hand. Notice, that as soon as
       you click on the tilePool, computer picks up a tile from the tilePool
       and adds it to his hand and discards one tile.
     - The computer is stupid and randomly discards a tile from his hand.
     - Rules button show you the rules of the game.
  - Game Coordinator is the entry point for console based game.
      - Have methods to detect sets and runs in the console based version.
      - have boolean debug to print out to the console and can easily check
        if there is set or run through console by just setting the debug value
        to true.


Some Bugs:
 -After playing the game for few mins, when the human clicks the discard pile of
  computer, it adds it fine to the human hand but for some reason, the
  computer player doesn't discard the tiles sometime when his next turn.

 -The human player automatically chooses the tile to discard, (it wouldve been
  fixed by just adding a mouse event on the humanHbox in display.java but
  didn't get a chance, the mouse event is there on line 239 in display)

 -In game coordinator, it doesn't account for the joker and a condition for 1
  to be added as a 14. 

Things Not Implemented:
  -Advance Rules with melding.