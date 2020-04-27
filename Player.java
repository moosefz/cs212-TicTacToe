/**
 * @author Mustafa Fawaz, ID: 103184737
 * @version 1
 */

/**
 * Player is an abstract class that maintains a design that every player has a symbol (X or O), a name and an abstract
 * play method. It also maintains a reference to the game board for players to examine and make their move.
 */

public abstract class Player {

    private String name;
    private int symbol; //Only X or O (1/2)

    public Player() {
        this.name = "John Appleseed";
    }

    public int setPlayerName(String name) {
        if(!name.isEmpty()) {
            this.name = name;
            return 1;
        } return 0;
    }

    //Sets if the player is X or O using global interface (1 = X, 2 = 0)
    public int setPlayerSymbol(int symbol) {
        this.symbol = symbol;
        return 1;
    }

    public String getPlayerName() {
        return this.name;
    }

    //Abstract method to play
    public abstract int play();

}
