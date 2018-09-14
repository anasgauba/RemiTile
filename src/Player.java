import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class Player {

    TileCards hand;
    GameCoordinator gameCoordinator;

    public Player(GameCoordinator gameCoordinator) {
        this.gameCoordinator = gameCoordinator;
        this.hand = new TileCards();

    }

    public void addToHand(Tile tile) {
        hand.addTile(tile);
    }

    public void discard() {
        gameCoordinator.discard(hand.tiles.remove(5), this);
    }

    public LinkedList<Tile> getMyHand() {
        return hand.tiles;
    }

    public int getHandsSize() {
        return hand.size();
    }

    public void getHand() {
        gameCoordinator.checkForWin(hand);
    }
}
