import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
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

        Button rules = new Button("Rules");

        GameCoordinator gameCoordinator = new GameCoordinator();
        Pane root = new Pane();
        BorderPane borderPane = new BorderPane();
        StackPane stackPane = new StackPane();
        Region emptyRegion = new Region();
        HBox humanHbox = new HBox();
        humanHbox.setSpacing(10);
        HBox compHbox = new HBox();
        compHbox.setSpacing(10);

//        emptyRegion.setPrefSize(1090,140);
        borderPane.setPrefSize(1250, 600);
        borderPane.setRight(rules);

        borderPane.setBottom(humanHbox);
        borderPane.setTop(compHbox);

        borderPane.setLeft(stackPane);


        gameCoordinator.gameSetUp();

        LinkedList<Tile> humanHand = gameCoordinator.getHumanPlayersHand();
        LinkedList<Tile> computerHand = gameCoordinator.getComputerPlayersHand();
        LinkedList<Tile> tilePool = gameCoordinator.getTilePool();

        int currentWidth = 180;
        for (int i = 0; i< humanHand.size(); i++) {

            humanHbox.getChildren().add(new Tile(humanHand.get(i).getNum(),
                    humanHand.get(i).getColor()));
//            Rectangle rectangle = new Rectangle(currentWidth, 30, 60 ,100);
//            currentWidth += 65;
//            rectangle.setFill(Color.WHITE);
//            rectangle.setStroke(Color.BLUE);
            borderPane.setBorder(new Border(new BorderStroke(Color.GREEN,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
        }
        currentWidth = 180;
        for (int i = 0; i < computerHand.size(); i++) {
            compHbox.getChildren().add(new Tile(computerHand.get(i).getNum(),
                    computerHand.get(i).getColor()));
//            switch (tile) {
//
//            }
//            Rectangle rectangle = new Rectangle(currentWidth, 450, 60 ,100);
//            currentWidth += 65;
//
//            rectangle.setFill(Color.WHITE);
//            rectangle.setStroke(Color.BLUE);
//            borderPane.getChildren().add(rectangle);
        }

        for (Tile tile : tilePool) {
            Rectangle rectangle = new Rectangle(200, 600, 60, 100);
            rectangle.setStroke(Color.BLUE);
            stackPane.setPrefSize(160, 600);
            stackPane.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
            stackPane.getChildren().add(rectangle);
        }

//        for (Tile tile : discardPile1) {
//            Rectangle rectangle = new Rectangle(200, 600, 60, 100);
//            rectangle.setStroke(Color.BLUE);
//            stackPane = new StackPane();
//            stackPane.setPrefSize(160, 600);
//            stackPane.getChildren().add(rectangle);
//        }

        root.getChildren().addAll(borderPane);

        primaryStage.setTitle("Remi Tile Game");
        primaryStage.setScene(new Scene(root, 1250, 600));
        primaryStage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        };
    }
}
