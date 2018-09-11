import javafx.scene.paint.Color;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public enum TileColors {
    RED("R",Color.RED), YELLOW("Y", Color.YELLOW), GREEN("G",Color.GREEN), BLUE
            ("B", Color.BLUE);

    private final String str;
    private final Color color;

    TileColors(String str, Color color) {
        this.str = str;
        this.color = color;
    }
    public String toString() {
        return this.str;
    }

    public Color toColor() {
        return this.color;
    }
}
