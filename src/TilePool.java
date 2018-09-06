/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class TilePool {

    private Tile [] deckOfTiles;
    private int numTiles;

    public TilePool() {
        this.deckOfTiles = new Tile[56];
        this.numTiles = 0;
    }

    public Tile getTop() {
        if (numTiles > 0) {
            return deckOfTiles[numTiles - 1];
        }
        return null;
    }

    public void addTile(Tile tile) {
        this.deckOfTiles[numTiles] = tile;
        numTiles++;
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
        for (int i = 0; i < deckOfTiles.length; i++) {
            str.append(deckOfTiles[i].tileNums);
            str.append('\n');
        }
        return str.toString();
    }



    public void shuffle() {

    }

    public class Tile {
        private TileNums tileNums;
        private TileColors colors;
        private boolean tileFace = true;

        public Tile(TileNums num, TileColors color) {
            this.tileNums = num;
            this.colors = color;
        }

        public TileNums getNum() {
            return tileNums;
        }
        public TileColors getColor() {
            return colors;
        }

        public boolean isFaceUp() {
            return tileFace;
        }

        public void setFaceUp(boolean faceUp) {
            this.tileFace = faceUp;
        }
    }

    public static void main(String[]args) {
        TilePool tilePool = new TilePool();
//        System.out.println(tilePool);
        tilePool.fillTile();
//        tilePool.getTop();

        System.out.println(tilePool);
//        System.out.println(tilePool);

    }
}
