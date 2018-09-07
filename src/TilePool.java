import java.util.Collections;
import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class TilePool {
    private LinkedList<Tile> deckOfTiles;

    public TilePool() {
        this.deckOfTiles = new LinkedList<>();
    }

    public Tile getTop() {
        return deckOfTiles.getFirst();
    }

    public void addTile(Tile tile) {
        this.deckOfTiles.addLast(tile);
        this.deckOfTiles.addLast(tile);
    }

    public void fillTile() {
        for (TileColors colors : TileColors.values()) {
            for (TileNums nums : TileNums.values()) {
                this.addTile(new Tile(nums, colors));
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Tile tile : deckOfTiles) {
            str.append(tile.getNum());
            str.append(", ");
            str.append(tile.getColor());
            str.append('\n');
        }
        return str.toString();
    }



    public void shuffle() {
        Collections.shuffle(deckOfTiles);
    }

    public static void main(String[]args) {
        TilePool tilePool = new TilePool();

        tilePool.fillTile();
        tilePool.shuffle();

        System.out.println(tilePool);

    }
}
