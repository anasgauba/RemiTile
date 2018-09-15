import java.util.Random;

/**
 * AI Computer Player for the Remi Game.
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class ComputerPlayer extends Player {

    /**
     * Calling the parent.
     * @param gameCoordinator a reference to game coordinator.
     */
    public ComputerPlayer(GameCoordinator gameCoordinator) {
        super(gameCoordinator);
    }


    public void makeMove() {
        gameCoordinator.playerOptions("tilePool");
    }

    /**
     * Pick a tile from his hand, and randomly discards the tile.
     */
    public int discardTheTile() {
        Random random = new Random();
        int rand = random.nextInt(getMyHand().size());
        gameCoordinator.discard(getMyHand().get(rand), this);
        return rand;
    }

}
