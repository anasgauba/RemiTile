import javafx.scene.paint.Color;

/**
 * Created enums for the tile colors. For console based
 * game, I have color as strings and for the GUI based game,
 * I have actual colors to display on the tile.
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public enum TileColors {
    RED("R",Color.RED), YELLOW("Y", Color.YELLOW), GREEN("G",Color.GREEN), BLUE
            ("B", Color.BLUE);

    private final String str;
    private final Color color;

    /**
     * Contructor for tile colors.
     * @param str string value of tile color.
     * @param color actual color.
     */
    TileColors(String str, Color color) {
        this.str = str;
        this.color = color;
    }

    /**
     *
     * @return string rep of tile color.
     */
    public String toString() {
        return this.str;
    }

    /**
     *
     * @return color rep of tile color.
     */
    public Color toColor() {
        return this.color;
    }
}
