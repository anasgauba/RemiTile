import java.util.Collections;
/**
 * Class for creating a deck of tiles. Extends parent
 * class TileCards to use the same methods that already
 * exists in TleCards generic class. For e.g, isEmpty(), size()
 * are the functions that tilePool needs to have.
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class TilePool extends TileCards {

    /**
     * Adds the tile back in the pool.
     * @param tile to be added again in the tilePool
     */
    public void putBack(Tile tile) {
        this.tiles.addLast(tile);
    }

    @Override
    /**
     * Adds the same tile twice to double
     * the deck size.
     */
    public void addTile(Tile tile) {
        tile.setFaceUp(true);
        this.tiles.addLast(tile);
        this.tiles.addLast(tile);
    }

    /**
     * Fill up the tiles in tilepool with
     * different nums and colors. Creates
     * a deck of tiles and shuffles them.
     */
    public void fillTile() {
        for (TileColors colors : TileColors.values()) {
            for (TileNums nums : TileNums.values()) {
                this.addTile(new Tile(nums, colors));
            }
        }
        Collections.shuffle(tiles);
    }
}
