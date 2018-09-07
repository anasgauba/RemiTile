import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class TileCards {
    LinkedList<Tile> tiles;

    public TileCards() {
        this.tiles = new LinkedList<>();
    }

    public void addTile(Tile tile) {
        this.tiles.addLast(tile);
    }
    public Tile getTile() {
        return this.tiles.remove();
    }
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
