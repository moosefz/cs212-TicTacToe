/**
 * @author Mustafa Fawaz, ID: 103184737
 * @version 1
 */

/**
 * Board is a class that has or contains 9 blocks in a 2D array (3x3) that shapes the game space of tic-tac-toe. It also
 * maintains an internal state which can be either EMPTY, X, Y or DRAW. The board has key methods that assist the Game
 * state such as checking for wins or draws when they occur. The board instantiates and maintains all the blocks.
 */


public class Board implements Global {

    public Block[][] blocks;

    //Default Constructor - 3x3 Board, consisting of 9 objects of type block
    public Board() {
        blocks = new Block[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.blocks[i][j] = new Block();
            }
        }
    }

    //Formats the board to include all positions the players can select
    public void displayPlayerBoard() {
        int k = 1;

        for(int i = 0; i < 3; i++) {
            System.out.print("   |   |   \n");
            for(int j = 0; j < 3; j++) {
                if(j == 0 || j == 1) {
                    if(this.blocks[i][j].getState() == 0) {
                        System.out.printf(" %d |", k);
                        k++;
                    } else {
                        System.out.printf(" %s |", this.blocks[i][j]);
                        k++;
                    }
                } else {
                    if(this.blocks[i][j].getState() == 0) {
                        System.out.printf(" %d\n", k);
                        k++;
                    } else {
                        System.out.printf(" %s\n", this.blocks[i][j]);
                        k++;
                    }
                }
            }
            if(i == 2) {
                System.out.print("   |   |   ");
            } else
                System.out.print("___|___|___\n");
        }
        System.out.println();
    }

    //Likely updates block state once a move is made to the corresponding symbol (X1 / Y2)
    public int updateState(int index1, int index2, int symbol) {
        this.blocks[index1][index2].setState(symbol);
        return 1;
    }

    //Checks to see the validity of a move based on the state of a specific block.
    public int isValidMove(int index1, int index2) {
        if(this.blocks[index1][index2].getState() == 0) {
            return 1; //Empty, valid
        } return 0; //Full, not valid
    }

    /**
     * updateBoard is a method that updates the board based on the player move (X/O). If the position is already
     * occupied, it will return 0, which forces the user to input a valid move.
     * @param gameBoard
     * @param position
     * @param symbol
     * @return 1 on success, 0 on failure.
     */
    public int updateBoard(Board gameBoard, int position, int symbol) {

        switch(position) {
            case 1:
                if(gameBoard.isValidMove(0,0) == 1) {
                    gameBoard.updateState(0, 0, symbol);
                    return 1;
                } else return 0;

            case 2:
                if(gameBoard.isValidMove(0,1) == 1) {
                    gameBoard.updateState(0, 1, symbol);
                    return 1;
                } else return 0;

            case 3:
                if(gameBoard.isValidMove(0,2) == 1) {
                    gameBoard.updateState(0, 2, symbol);
                    return 1;
            } else return 0;

            case 4:
                if(gameBoard.isValidMove(1,0) == 1) {
                    gameBoard.updateState(1, 0, symbol);
                    return 1;
                } else return 0;

            case 5:
                if(gameBoard.isValidMove(1,1) == 1) {
                    gameBoard.updateState(1, 1, symbol);
                    return 1;
                } else return 0;

            case 6:
                if(gameBoard.isValidMove(1,2) == 1) {
                    gameBoard.updateState(1, 2, symbol);
                    return 1;
                } else return 0;

            case 7:
                if(gameBoard.isValidMove(2,0) == 1) {
                    gameBoard.updateState(2, 0, symbol);
                    return 1;
                } else return 0;

            case 8:
                if(gameBoard.isValidMove(2,1) == 1) {
                    gameBoard.updateState(2, 1, symbol);
                    return 1;
                } else return 0;

            case 9:
                if(gameBoard.isValidMove(2,2) == 1) {
                    gameBoard.updateState(2, 2, symbol);
                    return 1;
                } else return 0;
        }
        return 0;
    }


    /**
     * checkState gathers all board state checking methods (Rows, Columns, Diagonals, Draw) and utilizes their return
     * values to determine the state of the game.
     * @param gameBoard
     * @return 1 (Column Win), 2 (Diagonal Win), 3 (Row Win), 4 (Draw), 0 (No win, game still live).
     */
    public int checkState(Board gameBoard) {
        if (checkColumns(gameBoard) == 1) {
            return 1;
        } else if (checkDiagonals(gameBoard) == 1) {
            return 2;
        } else if (checkRow(gameBoard) == 1) {
            return 3;
        } else if (checkDraw() == 1) {
            return 4;
        }
        //Game is still alive
        return 0;
    }

    /**
     * checkColumns checks all possible columns for consecutive matching symbols.
     * @param gameBoard
     * @return 1 (win), 0 otherwise.
     */
    private int checkColumns(Board gameBoard) {
        for(int i = 0; i < 3; i++) {
            if(gameBoard.blocks[0][i].getState() != 0 &&
                    gameBoard.blocks[0][i].getState() == gameBoard.blocks[1][i].getState() &&
                    gameBoard.blocks[0][i].getState() == gameBoard.blocks[2][i].getState()) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * checkDiagonals checks all possible diagonals for consecutive matching symbols.
     * @param gameBoard
     * @return 1 (win), 0 otherwise.
     */
    private int checkDiagonals(Board gameBoard) {
            if(gameBoard.blocks[0][0].getState() != 0 &&
                    gameBoard.blocks[0][0].getState() == gameBoard.blocks[1][1].getState() &&
                    gameBoard.blocks[0][0].getState() == gameBoard.blocks[2][2].getState()) {
                return 1;
            } else if (gameBoard.blocks[0][2].getState() != 0 &&
                    gameBoard.blocks[0][2].getState() == gameBoard.blocks[1][1].getState() &&
                    gameBoard.blocks[0][2].getState() == gameBoard.blocks[2][0].getState()) {
                return 1;
            }
        return 0;
    }

    /**
     * checkDraw checks the board state for a draw.
     * @return 0 for draw, 1 otherwise.
     */
    private int checkDraw() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                if(blocks[i][j].getState() == 0) {
                    return 0;
                }
            }
        }
        return 1;
    }

    /**
     * checkRow checks all possible rows for consecutive matching symbols.
     * @param gameBoard
     * @return 1 (win), 0 otherwise.
     */
    private int checkRow(Board gameBoard) {
        for(int i = 0; i < 3; i++) {
            if(gameBoard.blocks[i][0].getState() != 0 &&
                    gameBoard.blocks[i][0].getState() == gameBoard.blocks[i][1].getState() &&
                    gameBoard.blocks[i][0].getState() == gameBoard.blocks[i][2].getState()) {
                return 1;
            }
        }
        return 0;
    }

}
