import java.util.Collections;
import java.util.Comparator;
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

        System.out.println("run is " + isRun(humanPlayer.hand));
//        System.out.println("set is " + isSet(humanPlayer.hand));

//        sortForSameColor(humanPlayer.hand);
//        sortForSameValue(humanPlayer.hand);

        for (int j = 0; j < 14; j++) {
            computerPlayer.addToHand(tilePool.getTile());
        }
        sortForSameValue(computerPlayer.hand);
        System.out.println("computer hand ");
        System.out.println(computerPlayer.hand);
        System.out.println("tilepool after ");
        System.out.println(tilePool);

        turn = false;

//        if (turn) {
//            computerPlayer.discard();
//        }
//        else {
//            humanPlayer.discard();
//        }

    }

    public LinkedList<Tile> getTilePool() {
        return tilePool.tiles;
    }

    public LinkedList<Tile> getHumanPlayersHand() {
        return humanPlayer.getMyHand();
    }

    public LinkedList<Tile> getDiscardPile1() {
        return discardPile1.tiles;
    }

    public LinkedList<Tile> getDiscardPile2() {
        return discardPile2.tiles;
    }

    public LinkedList<Tile> getComputerPlayersHand() {
        return computerPlayer.getMyHand();
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

    /**
     * Sorts the hand of the player based on the same
     * color. Using an enhanced version of
     * (Collections.sort(hand.tiles, (Tile t1, Tile t2) -> t1.getColor()
     * .compareTo(t2.getColor())))
     * Collections.sort can also be written as list.sort because
     * list is a collection.
     * @param hand of any player which needs to be sorted.
     */
    public void sortForSameColor(TileCards hand) {
        hand.tiles.sort(Comparator.comparing(Tile::getColor));
        System.out.println("sorted based on color ");
        System.out.println(hand);

    }

    /**
     * Sorts the hand of the player based on the same number.
     *
     * @param hand of any player which needs to be sorted.
     */
    public void sortForSameValue(TileCards hand) {
        hand.tiles.sort(Comparator.comparing(Tile::getNum));
        System.out.println("sorted based on values ");
        System.out.println(hand);
    }

    public boolean isRun(TileCards hand) {
        int count = 0;
        boolean run = false;
        sortForSameColor(hand);
        for (int i = 0; i < hand.size() - 1; i++) {
            System.out.println("print i = " + i);
            if (hand.tiles.get(i).getNum().toInt() < hand.tiles.get(i + 1)
                    .getNum().toInt() && hand.tiles.get(i).getColor().toColor
                    () == hand.tiles.get(i + 1).getColor().toColor()) {
                count++;
                System.out.println("printing count " + count + " at i = " + i);
            }
            else if (!(hand.tiles.get(i).getNum().toInt() < hand.tiles.get(i
                    + 1)
                    .getNum().toInt()) && !(hand.tiles.get(i).getColor().toColor
                    () == hand.tiles.get(i + 1).getColor().toColor())) {
                count = 0;
            }
            else if (!(hand.tiles.get(i).getNum().toInt() < hand.tiles.get(i
                    + 1)
                    .getNum().toInt()) && hand.tiles.get(i).getColor().toColor
                    () == hand.tiles.get(i + 1).getColor().toColor()) {
                count = 0;
            }
            if (count >= 2) {
                run = true;
            }
        }
        return run;
    }

    public boolean isSet(TileCards hand) {
        int count = 0;
        boolean set = false;
        sortForSameValue(hand);
        for (int i = 0 ; i < hand.size() - 1; i++) {
            if (hand.tiles.get(i).getNum() == hand.tiles.get(i + 1).getNum()
                    && hand.tiles.get(i).getColor() != hand.tiles.get(i + 1)
                    .getColor()) {
                count++;
                if (count == 3 || count == 4) {
                    set = true;
                }
            }
//            count = 0;
        }
        return set;
    }

    public void checkForWin(TileCards hand) {
//        for (int i = 0; i < )

    }
}
