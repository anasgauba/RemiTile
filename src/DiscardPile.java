import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class DiscardPile {
    private LinkedList<Tile> discard = new LinkedList<>();
    private Tile tile;

    public DiscardPile() {

    }

    public DiscardPile(Tile tile) {
        this.tile = tile;
    }

    public void add(Tile tile) {
        this.discard.addLast(tile);
        tile.setFaceUp(true);
    }

    public void push() {

    }

    public static void main(String[]args) {
        DiscardPile discardPile = new DiscardPile();


    }

}
