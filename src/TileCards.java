import java.util.LinkedList;

/**
 * Generic class for tilepool, discard piles. Has
 * linked list of tiles. Some methods which is used by tilePool
 * as well as discard piles.
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class TileCards {
    LinkedList<Tile> tiles;

    /**
     * Contructor for tileCards.
     */
    public TileCards() {
        this.tiles = new LinkedList<>();
    }

    /**
     * Adds the tile to the linked list.
     * @param tile to add to linked list.
     */
    public void addTile(Tile tile) {
        this.tiles.addLast(tile);
    }

    /**
     * Removes the tile from the linked list.
     * @return tile to be removed.
     */
    public Tile getTile() {
        return this.tiles.removeLast();
    }

    /**
     * Gets the last tile in the linked list.
     * @return top tile.
     */
    public Tile getTop() {
        return tiles.getLast();
    }

    /**
     * Checks if the linked list is empty.
     * @return empty linked list.
     */
    public boolean isEmpty() {
        return tiles.isEmpty();
    }

    /**
     * Gets the size of the linked list.
     * @return size of the linked list.
     */
    public int size() {
        return this.tiles.size();
    }

    /**
     *
     * @return string rep of the tile.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Tile tile : tiles) {
            str.append(tile.getNum());
            str.append(", ");
            str.append(tile.getColor());
            str.append('\n');
        }
        return str.toString();
    }
}
