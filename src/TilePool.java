import java.util.Collections;
import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class TilePool extends TileCards {


    public void putBack(Tile tile) {
        this.tiles.addLast(tile);
    }

    @Override
    /**
     *
     */
    public void addTile(Tile tile) {
        this.tiles.addLast(tile);
        this.tiles.addLast(tile);
    }

    public void fillTile() {
        for (TileColors colors : TileColors.values()) {
            for (TileNums nums : TileNums.values()) {
                this.addTile(new Tile(nums, colors));
            }
        }
        Collections.shuffle(tiles);
    }
}
