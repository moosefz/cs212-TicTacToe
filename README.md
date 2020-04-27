# cs212-TicTacToe
TicTacToe with basic AI - CS212 - OOP using Java

## Functionality
This Tic Tac Toe game with "*dumb*" AI was created during the F2019 semester at the University of Windsor. This program consists of the following classes:
- AI Player: Serves as the *dumb* AI by simply selecting random positions on the board that are available and making a move. No strategy is involved.
- Block: The block object which stores the state of the block (free/taken). Also consists of the value (X/O as a 0 or 1)
- Board: The board consists of all 9 block objects along with the following methods:
  - displayPlayerBoard: Outputs the current board to the console.
  - updateState: This method is called everytime a move is made to update a block.
  - isValidMove: Determines if the move is valid (e.g. block is already taken)
  - updateBoard: Updates the board with the player selection if the move is valid.
  - checkState: Determines if there is a winner/draw by checking all rows and diagonals.
  - checkColumns: Checks all columns for a win.
  - checkDiagonals: Checks all diagonals for a win.
  - checkRow: Checks all rows for a win.
  - checkDraw: Checks to determine a draw.
 - Game: Starts a new game by asking users the game mode preferred (Human v Human, Human v AI). Player names are acquired from users and first move is selected at random along with X/O designation. A board is created and this class drives the order of the game itself ending once a winner is determined by the board.
 - Global: An interface consisting of constants used in the blocks.
 - HumanPlayer: A class for the HumanPlayer object with attributes related to the player.
 - Player: Abstract class that is inherited by the HumanPlayer/AI Player consisting of the attributes and methods required. 
 - TicTacToe.java: Consists of main and creates a new game once executed.
