/**
 * @author Mustafa Fawaz, ID: 103184737
 * @version 1
 */

/**
 * HumanPlayer is a Player (extends Player) that has a name and a symbol. HumanPlayer requests the cell from the
 * user to make a move.
 */

import java.util.Scanner;

public class HumanPlayer extends Player {

    //Overloaded Constructor
    public HumanPlayer(String name, int symbol) {
        setPlayerName(name);
        setPlayerSymbol(symbol);
    }

    /**
     * play() requests input from the user. Called by class Game
     * @return
     */
    @Override
    public int play() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
