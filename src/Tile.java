public class Tile {
    private TileNums tileNums;
    private TileColors colors;
    private boolean tileFace = false;


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
        return this.tileFace;
    }

    public void setFaceUp(boolean faceUp) {
        this.tileFace = faceUp;
    }
}
