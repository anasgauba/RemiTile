import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Game logic class for the console based version.
 * Creates instances of players, discard piles, tilePool and
 * based on the turn, let the player choose where to get the tile from and
 * what tile to discard. Also, checks the tiles for runs and sets.
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class GameCoordinator {

    private TilePool tilePool = new TilePool();
    private TileCards discardPile1 = new TileCards();
    private TileCards discardPile2 = new TileCards();

    private Player humanPlayer = new Player(this);

    private ComputerPlayer computerPlayer = new ComputerPlayer(this);

    private boolean turn;
    boolean debug = false;

    /**
     * Sets the turn = false, meaning its human
     * player's turn when the game starts.
     */
    public GameCoordinator() {
        this.turn = false;
    }

    /**
     *
     * @return who's turn it is.
     */
    public boolean getTurn() {
        return this.turn;
    }

    /**
     * Initial game setup, creates a deck of tiles.
     * Give 14 tiles to each player. First, gives the turn
     * to human.
     */
    public void gameSetUp() {
        tilePool.fillTile();
        if (debug ) {
            System.out.println("tilepool before");
            System.out.println(tilePool);
        }
        for (int i = 0; i < 14; i++) {
            humanPlayer.addToHand(tilePool.getTile());
        }
        if (debug) {
            System.out.println("human hand ");
            System.out.println(humanPlayer.hand);
            System.out.println("run is " + isRun(humanPlayer.hand));
            System.out.println("set is " + isSet(humanPlayer.hand));
        }

        for (int j = 0; j < 14; j++) {
            computerPlayer.addToHand(tilePool.getTile());
        }
        if (debug) {
            System.out.println("computer hand ");
            System.out.println(computerPlayer.hand);
            System.out.println("tilepool after ");
            System.out.println(tilePool);
        }

        turn = false;
    }

    /**
     *
     * @returns the tilePool list.
     */
    public LinkedList<Tile> getTilePool() {
        return tilePool.tiles;
    }

    /**
     *
     * @returns human player's hand list.
     */
    public LinkedList<Tile> getHumanPlayersHand() {
        return humanPlayer.getMyHand();
    }

    /**
     *
     * @returns computer player's hand list.
     */
    public LinkedList<Tile> getDiscardPile1() {
        return discardPile1.tiles;
    }

    /**
     *
     * @returns computer player's discardPile.
     */
    public LinkedList<Tile> getDiscardPile2() {
        return discardPile2.tiles;
    }

    /**
     *
     * @returns human player's discardPile.
     */
    public LinkedList<Tile> getComputerPlayersHand() {
        return computerPlayer.getMyHand();
    }

    /**
     * Check if the tilePool is empty. If it is, loop through
     * both human's and computer's discard piles and put everything back
     * into tilePool. Shuffles in the end.
     */
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


    /**
     * Based on the player, if it's human, it discards the
     * given tile into discardPile1. if it's computer, it discards
     * the given tile into discardPile2. After the player discarded,
     * the turn switches.
     * @param tile to be discard by a player.
     * @param player who's discarding.
     */
    public void discard(Tile tile, Player player) {
        if (player == humanPlayer) {
            discardPile1.addTile(tile);
            tile.setFaceUp(true);
            turn = true;

            if (debug) {
                System.out.println("humans hand after discard " + humanPlayer.hand);
                System.out.println("human's discard " + discardPile1);
            }
        }
        else if (player == computerPlayer) {
            discardPile2.addTile(tile);
            tile.setFaceUp(true);
            turn = false;

            if (debug) {
                System.out.println("computer's discard " + discardPile2);
            }
        }
    }

    /**
     *
     * @returns the index of the tile that was discarded.
     */
    public int computerDiscarded() {
        return computerPlayer.discardTheTile();
    }

    /**
     * Based on the turn, the player either has the option
     * of choosing from tilePool or from discard of the other player.
     *
     * @param str options for the player.
     */
    public void playerOptions(String str) {
        if (str == "tilePool") {
            if (turn) {
                computerPlayer.addToHand(tilePool.getTile());
            }
            else {
                humanPlayer.addToHand(tilePool.getTile());
                humanPlayer.discard(5);
            }
        }
        else if (str == "discard") {
            if (turn) {
                computerPlayer.addToHand(discardPile1.getTile());
            }
            else {
                humanPlayer.addToHand(discardPile2.getTile());
                humanPlayer.discard(5);
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
        if (debug) {
            System.out.println("sorted based on color ");
            System.out.println(hand);
        }
    }

    /**
     * Sorts the hand of the player based on the same number.
     *
     * @param hand of any player which needs to be sorted.
     */
    public void sortForSameValue(TileCards hand) {
        hand.tiles.sort(Comparator.comparing(Tile::getNum));
        if (debug) {
            System.out.println("sorted based on values ");
            System.out.println(hand);
        }
    }

    /**
     * First, sort the tiles by numbers and then sort it based
     * on the same color. Checks if the tile is exactly less than
     * the next tile and the color is same, if it is then add the count.
     * if count gets to 2, means that we have now compared at least three tiles
     * and therefore we have a run.
     * @param hand to check for run.
     * @return true/false if is run or not.
     */
    public boolean isRun(TileCards hand) {
        int count = 0;
        boolean run = false;
        sortForSameValue(hand);
        sortForSameColor(hand);

        for (int i = 0; i < hand.size() - 1; i++) {

            if (debug) System.out.println("print i = " + i);

            if (hand.tiles.get(i).getNum().toInt() + 1 == hand.tiles.get(i + 1)
                    .getNum().toInt() && hand.tiles.get(i).getColor().toColor
                    () == hand.tiles.get(i + 1).getColor().toColor()) {
                count++;

                if (debug) {
                    System.out.println("printing count " + count + " " +
                            "at i " + "=" + " " + i);
                }
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

    /**
     * First, sort the tiles by same numbers.
     * Then, loop through the handSize - 1 times and
     * check if the num at i is same as i + 1 and also if the
     * color of the tile is different, if the condition meets then
     * we have a set.
     * @param hand to check for run.
     * @return true/false if is set or not.
     */
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
        }
        return set;
    }

    public void checkForWin(TileCards hand) {
//        for (int i = 0; i < )

    }
}
