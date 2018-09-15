import java.util.LinkedList;

/**
 * Generic player class. Has access to its hand.
 * Tells the gameCoordinator which card to discard and what to add
 * to the hand.
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class Player {

    TileCards hand;
    GameCoordinator gameCoordinator;

    /**
     * Construct a player with reference to gameCoordinator
     * The player has access to his hand.
     * @param gameCoordinator reference.
     */
    public Player(GameCoordinator gameCoordinator) {
        this.gameCoordinator = gameCoordinator;
        this.hand = new TileCards();

    }

    /**
     * adds the given tile to its hand.
     * @param tile to add to the hand.
     */
    public void addToHand(Tile tile) {
        hand.addTile(tile);
    }

    /**
     * Tells the gameCoordinator of which card to discard.
     * @param value
     */
    public void discard(int value) {
        gameCoordinator.discard(hand.tiles.remove(value), this);
    }

    /**
     * Gets the hand.
     * @returns list of tiles in the hand.
     */
    public LinkedList<Tile> getMyHand() {
        return hand.tiles;
    }

    /**
     *
     * @returns size of the hand.
     */
    public int getHandsSize() {
        return hand.size();
    }

    /**
     * Tells game Coordinator to check for win.
     */
    public void getHand() {
        gameCoordinator.checkForWin(hand);
    }
}
