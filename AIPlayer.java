/**
 * @author Mustafa Fawaz, ID: 103184737
 * @version 1
 */

/**
 * AIPlayer is a Player (extends Player) with a name and a symbol (X/O) set by the Game. This is a basic AI that
 * generates random numbers between 1-9 and makes this move if it is valid.
 */

import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(String name, int symbol) {
        setPlayerName(name);
        setPlayerSymbol(symbol);
    }

    @Override
    public int play() {
        Random rn = new Random();
        return rn.nextInt(9 - 1 + 1) + 1;
    }
}
