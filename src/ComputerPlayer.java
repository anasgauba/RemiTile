/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class ComputerPlayer extends Player {
    TilePool tilePool;

    public ComputerPlayer(GameCoordinator gameCoordinator) {
        super(gameCoordinator);
    }


    public void makeMove() {
        this.addToHand(tilePool.getTile());
        this.discard();
    }

}
