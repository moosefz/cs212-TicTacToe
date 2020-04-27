/**
 * @author Mustafa Fawaz, ID: 103184737
 * @version 1
 */

import java.util.Scanner;

/**
 * Game is a class that contains a game board and two players - playerX and playerO. It manages the iteration with the
 * players. First by getting the player names, does a coin toss to decide the turn and allows each player to take a turn
 * and make a move. It finally announces the winner/draw when the game ends.
 */

public class Game {

    Board gameBoard;
    Player playerX;
    Player playerO;
    int turn = 0; //1 = playerX, 2 = playerO
    int done;
    int coinToss;

    //Default Constructor
    public Game() {
        gameBoard = new Board(); //Creates a new board with positions and gets it ready.
    }

    /**
     * start is a method that drives the structure of the game. Includes game mode selection (players), coin toss
     * to start the game, sequential game flow for moves, validity of cell checking and checking the state of the
     * game after each move (winner).
     */
    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------Tic Tac Toe------------------");
        System.out.println("-----------------------------------------------");
        displayFirstMenu();
        System.out.print(">> ");
        int firstSelection = sc.nextInt();

        //Driver of the main menu
        switch(firstSelection) {
            //Human vs Human
            case 1:
                //Requesting names for players
                System.out.print("Name of Human 1 (X): ");
                playerX = new HumanPlayer(getInput(), 1);
                System.out.print("Name of Human 2 (O): ");
                playerO = new HumanPlayer(getInput(), 2);

                //Coin Toss to determine who goes first, 50/50 chance
                coinToss = (Math.random() <= 0.5) ? 1 : 2;
                if(coinToss == 1) {
                    turn = 1;
                    System.out.printf("%s (X) goes first.\n", playerX.getPlayerName());
                    System.out.println("---------------------------");
                } else if (coinToss == 2){
                    turn = 2;
                    System.out.printf("%s (O) goes first.\n", playerO.getPlayerName());
                    System.out.println("---------------------------");
                }

                //This is where the magic happens
                while(done != 1) {

                    //PlayerX Goes
                    if(turn == 1) {
                        gameBoard.displayPlayerBoard();
                        System.out.printf("%s's (X) turn. Choose a cell: ", playerX.getPlayerName());

                        //Cell selection by playerX. Checks for valid move, and inserts the symbol in the selection.
                        while(gameBoard.updateBoard(gameBoard, (playerX.play()), 1) != 1) {
                            System.out.print("Occupado. Try again >> ");
                        }

                        //If checkGame returns 1 (based on player turn), we have a winner. Break from loop.
                        if(checkGame(turn) == 1)
                            break;

                        //Switch to playerO
                        turn = 2;
                    }

                    //PlayerO Goes
                    if(turn == 2) {
                        gameBoard.displayPlayerBoard();
                        System.out.printf("%s's (O) Turn. Choose a cell: ", playerO.getPlayerName());

                        //Cell selection by playerO. Checks for valid move, and inserts the symbol in the selection.
                        while(gameBoard.updateBoard(gameBoard, (playerO.play()), 2) != 1) {
                            System.out.print("Occupado. Try again >> ");
                        }

                        //If checkGame returns 1 (based on player turn), we have a winner. Break from loop.
                        if(checkGame(turn) == 1)
                            break;

                        //Switch to playerX
                        turn = 1;
                    }
                }
                break;

            //Human vs AI
            case 2:
                //Requesting names for players
                System.out.print("Name of you, human (X): ");
                playerX = new HumanPlayer(getInput(), 1);
                System.out.print("Name of AI (O): ");
                playerO = new AIPlayer(getInput(), 2);

                //Coin Toss to determine who goes first, 50/50 chance
                coinToss = (Math.random() <= 0.5) ? 1 : 2;
                if(coinToss == 1) {
                    turn = 1;
                    System.out.printf("%s (X) goes first.\n", playerX.getPlayerName());
                    System.out.println("---------------------------");
                } else if (coinToss == 2){
                    turn = 2;
                    System.out.printf("%s (O) goes first.\n", playerO.getPlayerName());
                    System.out.println("---------------------------");
                }

                while(done != 1) {

                    //PlayerX Goes (Human)
                    if(turn == 1) {
                        gameBoard.displayPlayerBoard();
                        System.out.printf("%s's (X) turn. Choose a cell: ", playerX.getPlayerName());

                        //Cell selection by player. Checks for valid move, and inserts the symbol in the selection.
                        while(gameBoard.updateBoard(gameBoard, (playerX.play()), 1) != 1) {
                            System.out.print("Occupado. Try again >> ");
                        }

                        //If it returns 1, we have a winner.
                        if(checkGame(turn) == 1) {
                            System.out.println(".... you beat a robot.");
                            break;
                        }

                        //Switch to playerO
                        turn = 2;
                    }

                    //PlayerO Goes (AI)
                    if(turn == 2) {
                        System.out.printf("%s (O) made a move.\n", playerO.getPlayerName());

                        //Cell selection by AI. Checks for valid move, and inserts the symbol in the selection.
                        while(gameBoard.updateBoard(gameBoard, (playerO.play()), 2) != 1) {
                        }

                        if(checkGame(turn) == 1) {
                            System.out.println(".... you lost to a robot.");
                            break;
                        }

                        //Switch to playerX
                        turn = 1;
                    }
                }

                break;
        }
    }

    /**
     * checkGame returns the state of the game after each move by checking the rows, columns, diagonals, and draw
     * scenarios. Based on current turn order, if a winner is determined, it is printed to the console.
     * @param turn
     * @return
     */
    public int checkGame(int turn) {

        if(gameBoard.checkState(gameBoard) == 1) {
            gameBoard.displayPlayerBoard();
            if(turn == 1)
                System.out.printf("%s (X) wins on a column.\n", playerX.getPlayerName());
            else
                System.out.printf("%s (O) wins on a column.\n", playerO.getPlayerName());
            return 1;

        } else if(gameBoard.checkState(gameBoard) == 2) {
            gameBoard.displayPlayerBoard();
            if(turn == 1)
                System.out.printf("%s (X) wins on a diagonal.\n", playerX.getPlayerName());
            else
                System.out.printf("%s (O) wins on a diagonal.\n", playerO.getPlayerName());
            return 1;

        } else if(gameBoard.checkState(gameBoard) == 3) {
            gameBoard.displayPlayerBoard();
            if(turn == 1)
                System.out.printf("%s (X) wins on a row.\n", playerX.getPlayerName());
            else
                System.out.printf("%s (O) wins on a row.\n", playerO.getPlayerName());
            return 1;

        } else if(gameBoard.checkState(gameBoard) == 4) {
            gameBoard.displayPlayerBoard();
            System.out.printf("Game is a draw!");
            return 1;
        }
        return 0;
    }

    //Method for second menu on screen ... not really needed, but used anyways.
    public void displayFirstMenu() {
        System.out.println("How we playin' today? 1. Human vs Human || 2. Human vs AI (Novice)");
    }

    //Used for String Inputs
    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
