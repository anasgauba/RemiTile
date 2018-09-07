import java.util.Collections;
import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class TilePool extends TileCards {

    @Override
    /**
     *
     */
    public void addTile(Tile tile) {
        this.tiles.addLast(tile);
        this.tiles.addLast(tile);
    }

    public Tile getTop() {
        return tiles.getFirst();
    }

    public void fillTile() {
        for (TileColors colors : TileColors.values()) {
            for (TileNums nums : TileNums.values()) {
                this.addTile(new Tile(nums, colors));
            }
        }
        Collections.shuffle(tiles);
    }

    public static void main(String[]args) {
        TilePool tilePool = new TilePool();

        tilePool.fillTile();
//        tilePool.shuffle();

        System.out.println(tilePool);

    }
}
