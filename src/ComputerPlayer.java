import java.util.Random;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class ComputerPlayer extends Player {

    public ComputerPlayer(GameCoordinator gameCoordinator) {
        super(gameCoordinator);
    }


    public void makeMove() {

    }

    public void discardTheTile() {
        Random random = new Random();
        int rand = random.nextInt(getMyHand().size());
        gameCoordinator.discard(getMyHand().get(rand), this);
    }

}
