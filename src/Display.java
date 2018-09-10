import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class Display extends Application{

    /**
     * Launches the game.
     * @param args arguments
     */
    public static void main(String[]args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button helpButton = new Button("Help?");

        GameCoordinator gameCoordinator = new GameCoordinator();
        Pane root = new Pane();
        BorderPane borderPane = new BorderPane();
        Region emptyRegion = new Region();
        HBox hbox = new HBox();

        borderPane.setRight(helpButton);


        gameCoordinator.gameSetUp();
        LinkedList<Tile> humanHand = gameCoordinator.getHumanPlayersHand();
        LinkedList<Tile> computerHand = gameCoordinator
                .getComputerPlayersHand();
        int currentWidth = 180;
        for (Tile tile : humanHand) {
            Rectangle rectangle = new Rectangle(currentWidth, 30, 60 ,100);
            currentWidth += 65;
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLUE);
            borderPane.getChildren().add(rectangle);
        }
        currentWidth = 180;
        for (Tile tile : computerHand) {
            Rectangle rectangle = new Rectangle(currentWidth, 450, 60 ,100);
            currentWidth += 65;
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLUE);
            borderPane.getChildren().add(rectangle);
        }
        root.getChildren().add(borderPane);

        primaryStage.setTitle("Remi Tile Game");
        primaryStage.setScene(new Scene(root, 1200, 600));
        primaryStage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        };
    }
}
