import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class Player {

    TileCards hand;
    TileCards discardPile;

    public Player(TileCards discardPile) {
        this.discardPile = discardPile;
        this.hand = new TileCards();

    }

    public void play() {

    }

}
