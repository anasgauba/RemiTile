import java.util.Collections;
import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class GameCoordinator {

    TilePool tilePool = new TilePool();
    TileCards discardPile1 = new TileCards();
    TileCards discardPile2 = new TileCards();

    Player humanPlayer = new Player(this);

    ComputerPlayer computerPlayer = new ComputerPlayer(this);

    boolean turn;

    public GameCoordinator() {
        this.turn = false;
    }

    public void gameSetUp() {
        tilePool.fillTile();
        System.out.println("tilepool before");
        System.out.println(tilePool);
        for (int i = 0; i < 14; i++) {
            humanPlayer.addToHand(tilePool.getTile());
        }
        System.out.println("human hand ");
        System.out.println(humanPlayer.hand);

        for (int j = 0; j < 14; j++) {
            computerPlayer.addToHand(tilePool.getTile());
        }
        System.out.println("computer hand ");
        System.out.println(computerPlayer.hand);
        System.out.println("tilepool after ");
        System.out.println(tilePool);

//        if (turn) {
//            computerPlayer.discard();
//        }
//        else {
//            humanPlayer.discard();
//        }

    }


    public LinkedList<Tile> getHumanPlayersHand() {
        return humanPlayer.hand.tiles;
    }

    public LinkedList<Tile> getComputerPlayersHand() {
        return computerPlayer.hand.tiles;
    }

    public void isTilePoolEmpty() {
        if (tilePool.isEmpty()) {
            while (!(discardPile1.isEmpty())) {
                tilePool.putBack(discardPile1.getTile());
            }
            while (!(discardPile2.isEmpty())) {
                tilePool.putBack(discardPile2.getTile());
            }
            Collections.shuffle(tilePool.tiles);
        }
    }

    public void discard(Tile tile, Player player) {
        if (player == humanPlayer) {
            discardPile1.addTile(tile);
            tile.setFaceUp(true);
            turn = true;
            System.out.println("human's discard " + discardPile1);
        }
        else if (player == computerPlayer) {
            discardPile2.addTile(tile);
            tile.setFaceUp(true);
            turn = false;
        }
    }

    public void playerOptions(String str) {
        if (str == "tilePool") {
            if (turn) {
                computerPlayer.addToHand(tilePool.getTile());
            }
            else {
                humanPlayer.addToHand(tilePool.getTile());
            }
        }
        else if (str == "discard") {
            if (turn) {
                computerPlayer.addToHand(discardPile1.getTile());
            }
            else {
                humanPlayer.addToHand(discardPile2.getTile());
            }
        }
    }



//    public Tile displayTopTiles() {
//
//    }
}
