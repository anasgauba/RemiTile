import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Creates one tile with a color and a number.
 * Uses enum values for colors and nums.
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class Tile extends Pane {
    private TileNums tileNums;
    private TileColors colors;
    private boolean tileFace;
    GameCoordinator gameCoordinator;

    /**
     * Constructs an object with a color and
     * a number.
     * @param num of the tile
     * @param color of the tile
     */
    public Tile(TileNums num, TileColors color) {
        this.tileNums = num;
        this.colors = color;
        Canvas canvas = new Canvas();
        canvas.setWidth(60);
        canvas.setHeight(100);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.TURQUOISE);
        gc.fillRect(1,1,58,98);
        gc.setFill(colors.toColor());
        gc.fillText(num.toString(), Math.round(canvas.getWidth()/2 - 5), Math
                .round(canvas.getHeight()/2) - 3);
        this.setPrefSize(60, 100);
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));
        this.getChildren().add(canvas);
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
