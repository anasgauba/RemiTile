/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class ComputerPlayer extends Player {
    TilePool tile;

    public ComputerPlayer(GameCoordinator gameCoordinator) {
        super(gameCoordinator);
    }


    public void makeMove() {
        this.addToHand(tile.getTile());
        this.discard();
    }

}
