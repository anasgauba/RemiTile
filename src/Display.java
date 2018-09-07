import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class Display {

    Pane root = new Pane();

    public Display(Stage primaryStage) {

        primaryStage.setTitle("Remi Tile Game");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }
}
