/**
 * Creates one tile with a color and a number.
 * Uses enum values for colors and nums.
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class Tile {
    private TileNums tileNums;
    private TileColors colors;
    private boolean tileFace = false;

    /**
     * Constructs an object with a color and
     * a number.
     * @param num of the tile
     * @param color of the tile
     */
    public Tile(TileNums num, TileColors color) {
        this.tileNums = num;
        this.colors = color;
    }

    /**
     *
     * @return the number of this tile.
     */
    public TileNums getNum() {
        return tileNums;
    }

    /**
     *
     * @return the color of this tile.
     */
    public TileColors getColor() {
        return colors;
    }

    /**
     *
     * @return the face of the tile.
     */
    public boolean isFaceUp() {
        return this.tileFace;
    }

    /**
     * Sets the face to either up or down.
     * @param faceUp state of the card.
     */
    public void setFaceUp(boolean faceUp) {
        this.tileFace = faceUp;
    }
}
