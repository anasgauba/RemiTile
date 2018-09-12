import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        Button newGame = new Button("New Game");

        GameCoordinator gameCoordinator = new GameCoordinator();
        Pane root = new Pane();
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        vBox.setSpacing(200);
        StackPane stackPane = new StackPane();
        Region emptyRegion = new Region();
        HBox humanHbox = new HBox();
        humanHbox.setSpacing(5);
        HBox compHbox = new HBox();
        compHbox.setSpacing(5);

        StackPane humanDiscardStack = new StackPane();
        StackPane compDiscardStack = new StackPane();
        StackPane humanScoreStack = new StackPane();
        StackPane compScoreStack = new StackPane();


        borderPane.setPrefSize(1280, 600);
        borderPane.setRight(vBox);
        vBox.getChildren().addAll(rules, newGame);

        vBox.setPrefSize(150, 300);
        vBox.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));

        borderPane.setBottom(humanHbox);
        humanHbox.getChildren().add(humanDiscardStack);

        borderPane.setTop(compHbox);
        compHbox.getChildren().add(compDiscardStack);

        borderPane.setLeft(stackPane);

//        BorderPane.setAlignment(emptyRegion, Pos.CENTER);
        borderPane.setCenter(emptyRegion);

//        emptyRegion.setPrefSize(1090,140);

        emptyRegion.setBorder(new Border(new BorderStroke(Color.DARKBLUE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));

//        humanDiscardStack.setAlignment(Pos.CENTER_LEFT);
        humanDiscardStack.setPrefSize(150, 100);
        humanDiscardStack.setBorder(new Border(new BorderStroke(Color.YELLOW,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));

        compDiscardStack.setPrefSize(150, 100);
        compDiscardStack.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));

        gameCoordinator.gameSetUp();

        LinkedList<Tile> humanHand = gameCoordinator.getHumanPlayersHand();
        LinkedList<Tile> computerHand = gameCoordinator.getComputerPlayersHand();
        LinkedList<Tile> tilePool = gameCoordinator.getTilePool();
        LinkedList<Tile> humanDiscard = gameCoordinator.getDiscardPile1();
        LinkedList<Tile> compDiscard = gameCoordinator.getDiscardPile2();

//        for (Tile tile : humanDiscard) {
////            humanDiscardStack.setPrefSize(50, 50);
//            humanDiscardStack.getChildren().add(new Tile(tile.getNum(), tile
//                    .getColor()));
//        }

        for (int i = 0; i< humanHand.size(); i++) {
            humanHbox.getChildren().add(new Tile(humanHand.get(i).getNum(),
                    humanHand.get(i).getColor()));
//            humanHbox.setAlignment(Pos.CENTER);
            humanHbox.setBorder(new Border(new BorderStroke(Color.GREEN,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
        }
        humanHbox.getChildren().add(humanScoreStack);
//        humanScoreStack.setAlignment(Pos.CENTER);
        humanScoreStack.setPrefSize(150, 100);
        humanScoreStack.setBorder(new Border(new BorderStroke(Color.YELLOW,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));
        for (int i = 0; i < computerHand.size(); i++) {
            compHbox.getChildren().add(new Tile(computerHand.get(i).getNum(),
                    computerHand.get(i).getColor()));
        }
        compHbox.getChildren().add(compScoreStack);
        compScoreStack.setPrefSize(150, 100);
        compScoreStack.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));
        for (Tile tile : tilePool) {
            stackPane.setPrefSize(160, 300);
            stackPane.setPadding(new Insets(246, 58,50,40));
            stackPane.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
            stackPane.getChildren().add(new Tile(tile.getNum(), tile.getColor()));
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
        primaryStage.setScene(new Scene(root, 1280, 600));
        primaryStage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
//                if (!gameCoordinator.turn) {
//
//                }
            }
        };
    }
}
