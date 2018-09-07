import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class GameCoordinator extends Application{
    /**
     * Launches the game.
     * @param args arguments
     */
    public static void main(String[]args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePool tilePool = new TilePool();
        TileCards discardPile1 = new TileCards();
        TileCards discardPile2 = new TileCards();

        Player humanPlayer = new Player(discardPile1);
        Player computerPlayer = new Player(discardPile2);

        Display display = new Display(primaryStage);
    }
}
