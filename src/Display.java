import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.LinkedList;

/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public class Display extends Application {

    Button rules = new Button("Rules");
    Button newGame = new Button("New Game");
    GameCoordinator gameCoordinator = new GameCoordinator();
    Pane root = new Pane();
    BorderPane borderPane = new BorderPane();
    VBox vBox = new VBox();

    StackPane tilePane = new StackPane();
    Region emptyRegion = new Region();

    HBox humanHbox = new HBox();
    HBox compHbox = new HBox();

    StackPane humanDiscardStack = new StackPane();
    StackPane compDiscardStack = new StackPane();
    StackPane humanScoreStack = new StackPane();
    StackPane compScoreStack = new StackPane();

    LinkedList<Tile> humanHand = gameCoordinator.getHumanPlayersHand();
    LinkedList<Tile> computerHand = gameCoordinator.getComputerPlayersHand();
    LinkedList<Tile> tilePool = gameCoordinator.getTilePool();
    LinkedList<Tile> humanDiscard = gameCoordinator.getDiscardPile1();
    LinkedList<Tile> compDiscard = gameCoordinator.getDiscardPile2();

    /**
     * Launches the game.
     * @param args arguments
     */
    public static void main(String[]args) {
        launch(args);
    }

    public void addTilesToHuman() {
        humanHbox.setSpacing(5);
        for (int i = 0; i< humanHand.size(); i++) {
            humanHbox.getChildren().add(new Tile(humanHand.get(i).getNum(),
                    humanHand.get(i).getColor()));
//            humanHbox.setAlignment(Pos.CENTER);
            humanHbox.setBorder(new Border(new BorderStroke(Color.GREEN,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
        }

    }
    public void addTilesToComp() {
        compHbox.setSpacing(5);
        for (int i = 0; i < computerHand.size(); i++) {
            compHbox.getChildren().add(new Tile(computerHand.get(i).getNum(),
                    computerHand.get(i).getColor()));
        }
    }

    public void startOfGame() {

        vBox.setSpacing(200);



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

        borderPane.setLeft(tilePane);

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

        addTilesToHuman();

//        humanHbox.getChildren().add(humanScoreStack);
////        humanScoreStack.setAlignment(Pos.CENTER);
//        humanScoreStack.setPrefSize(150, 100);
//        humanScoreStack.setBorder(new Border(new BorderStroke(Color.YELLOW,
//                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
//                .DEFAULT, Insets.EMPTY)));

        addTilesToComp();

//        compHbox.getChildren().add(compScoreStack);
//        compScoreStack.setPrefSize(150, 100);
//        compScoreStack.setBorder(new Border(new BorderStroke(Color.BLACK,
//                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
//                .DEFAULT, Insets.EMPTY)));
        for (Tile tile : tilePool) {
            tilePane.setPrefSize(160, 300);
            tilePane.setPadding(new Insets(246, 58,50,40));
            tilePane.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
            tilePane.getChildren().add(new Tile(tile.getNum(), tile.getColor()));
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        gameCoordinator.gameSetUp();
        startOfGame();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!gameCoordinator.turn) {
                    tilePane.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            gameCoordinator.playerOptions("tilePool");
                            humanHbox.getChildren().add(new Tile(humanHand.getLast()
                                    .getNum(),
                                    humanHand.getLast().getColor()));
                            gameCoordinator.turn = true;
                        }
                    });
                }
                else {
                    tilePane.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            gameCoordinator.playerOptions("tilePool");
                            compHbox.getChildren().add(new Tile(computerHand.getLast()
                                    .getNum(),
                                    computerHand.getLast().getColor()));
                            gameCoordinator.turn = false;
                        }
                    });
                }


            }
        };
        timer.start();


//        for (Tile tile : humanDiscard) {
////            humanDiscardStack.setPrefSize(50, 50);
//            humanDiscardStack.getChildren().add(new Tile(tile.getNum(), tile
//                    .getColor()));
//        }


//        for (Tile tile : discardPile1) {
//            Rectangle rectangle = new Rectangle(200, 600, 60, 100);
//            rectangle.setStroke(Color.BLUE);
//            tilePane = new StackPane();
//            tilePane.setPrefSize(160, 600);
//            tilePane.getChildren().add(rectangle);
//        }

//        newGame.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                gameCoordinator.gameSetUp();
//                startOfGame();
//            }
//        });


        root.getChildren().addAll(borderPane);

        primaryStage.setTitle("Remi Tile Game");
        primaryStage.setScene(new Scene(root, 1280, 600));
        primaryStage.show();
    }
}
