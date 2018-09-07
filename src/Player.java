import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class HumanPlayer implements Player{

//    private Hand myHand;
//    TilePool tilePool;
    TileCards hand;
    TileCards discardPile;

    public HumanPlayer(TileCards discardPile) {
        this.discardPile = discardPile;
        this.hand = new TileCards();

    }

    public void play() {

    }

}
