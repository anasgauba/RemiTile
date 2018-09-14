import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    Pane root;
    BorderPane borderPane;
    VBox vBox;

    StackPane tilePane;
    Region emptyRegion;

    HBox humanHbox;
    HBox compHbox;

    StackPane humanDiscardStack;
    StackPane compDiscardStack;
    StackPane humanScoreStack;
    StackPane compScoreStack;

    LinkedList<Tile> humanHand;
    LinkedList<Tile> computerHand;
    LinkedList<Tile> tilePool;
    LinkedList<Tile> humanDiscard;
    LinkedList<Tile> compDiscard;

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
            humanHbox.getChildren().add(new StackPane(new Tile(humanHand.get(i)
                            .getNum(),
                    humanHand.get(i).getColor())));
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

    public void drawTilePool() {
        for (Tile tile : tilePool) {
            tilePane.setPrefSize(160, 300);
            tilePane.setPadding(new Insets(246, 58,50,40));
            tilePane.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
            tilePane.getChildren().add(new Tile(tile.getNum(), tile.getColor()));
        }
    }

    public void startOfGame() {

        root = new Pane();
        borderPane = new BorderPane();
        vBox = new VBox();

        tilePane = new StackPane();
        emptyRegion = new Region();

        humanHbox = new HBox();
        compHbox = new HBox();

        humanDiscardStack = new StackPane();
        compDiscardStack = new StackPane();
        humanScoreStack = new StackPane();
        compScoreStack = new StackPane();

        humanHand = gameCoordinator.getHumanPlayersHand();
        System.out.println("human hand size 2 " + humanHand.size());
        computerHand = gameCoordinator.getComputerPlayersHand();
        tilePool = gameCoordinator.getTilePool();
        humanDiscard = gameCoordinator.getDiscardPile1();
        compDiscard = gameCoordinator.getDiscardPile2();


        borderPane.setPrefSize(1280, 600);
        borderPane.setRight(vBox);

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
        drawTilePool();
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
                            humanHbox.getChildren().remove(6);
                            tilePane.getChildren().remove(tilePool.removeLast());
                            drawTilePool();
                            for (Tile tile : humanDiscard) {
                                humanDiscardStack.setPrefSize(150, 100);
                                humanDiscardStack.setBorder(new Border(new BorderStroke(Color.YELLOW,
                                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                                        .DEFAULT, Insets.EMPTY)));
                                humanDiscardStack.getChildren().add(new Tile(tile.getNum(), tile.getColor()));
                            }
                            gameCoordinator.turn = true;
                        }
                    });
                    compDiscardStack.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            System.out.println("Click!");
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
//                            compHbox.getChildren().remove();
                            tilePane.getChildren().remove(tilePool.removeLast());
                            drawTilePool();
                            gameCoordinator.turn = false;
                        }
                    });
                }
                rules.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Rules");
                        alert.setHeaderText("Rules of the Game");
                        alert.setContentText("Each player takes turns.");
                        alert.showAndWait();

                    }
                });
//                newGame.setOnMousePressed(new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent event) {
//                        humanHbox.getChildren().removeAll();
//                        compHbox.getChildren().removeAll();
//                        humanHand.clear();
//                        computerHand.clear();
//                        gameCoordinator.gameSetUp();
//                        startOfGame();
//                    }
//                });


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
        vBox.setSpacing(200);
        vBox.getChildren().addAll(rules, newGame);

        vBox.setPrefSize(150, 300);
        vBox.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));




        root.getChildren().addAll(borderPane);

        primaryStage.setTitle("Remi Tile Game");
        primaryStage.setScene(new Scene(root, 1280, 600));
        primaryStage.show();
    }
}
