/**
 * @author Mustafa Fawaz, ID: 103184737
 * @version 1
 */

/**
 * Block is a class that represents a playable cell. Maintains a state attribute that is either EMPTY, occupied by X,
 * or occupied by O. By default, it is empty and requires setState, getState and toString where EMPTY is just a blank
 * space.
 */


public class Block implements Global {

    private int blockState;

    //Default constructor, empty by default
    public Block() {
        this.blockState = 0;
    }

    //Set the state of a specific block based on user selection. Called in other methods.
    public int setState(int s) {
            if(isValidBlockState(s)) {
                this.blockState = s;
                return 1;
            } return 0;
    }

    //Return the state of a block, called by 2D array index position. Used in board checking/validity.
    public int getState() {
        return this.blockState;
    }

    //Checks validity of state once inserted.
    private boolean isValidBlockState(int s) {
        if (s == 1 || s == 2) {
            return true;
        }
        return false;
    }

    //When printing the blocks, the toString method will provide the corresponding symbols once filled by players
    public String toString() {
        if(this.blockState == 0) {
            return " ";
        } if (this.blockState == 1) {
            return "X";
        } return "O";
    }


}
