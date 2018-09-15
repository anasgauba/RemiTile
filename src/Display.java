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

    private Button rules = new Button("Rules");
//    Button newGame = new Button("New Game");
    private GameCoordinator gameCoordinator = new GameCoordinator();
    private Pane root;
    private BorderPane borderPane;
    private VBox vBox;

    private StackPane tilePane;
    private Region emptyRegion;

    private HBox humanHbox;
    private HBox compHbox;

    private StackPane humanDiscardStack;
    private StackPane compDiscardStack;

    private LinkedList<Tile> humanHand;
    private LinkedList<Tile> computerHand;
    private LinkedList<Tile> tilePool;
    private LinkedList<Tile> humanDiscard;
    private LinkedList<Tile> compDiscard;

    /**
     * Launches the game.
     * @param args arguments
     */
    public static void main(String[]args) {
        launch(args);
    }

    /**
     * Helper method to draw tiles for human player.
     */
    private void addTilesToHuman() {
        humanHbox.setSpacing(5);
        for (int i = 0; i < humanHand.size(); i++) {
            humanHbox.getChildren().add(new StackPane(new Tile(humanHand.get(i)
                    .getNum(),
                    humanHand.get(i).getColor())));
            humanHbox.setBorder(new Border(new BorderStroke(Color.GREEN,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
        }
        humanHbox.setBackground(new Background(new BackgroundFill(Color
                .rgb(72, 103, 178), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    /**
     * Helper method to draw tiles for computer player.
     */
    private void addTilesToComp() {
        compHbox.setSpacing(5);
        for (int i = 0; i < computerHand.size(); i++) {
            compHbox.getChildren().add(new Tile(computerHand.get(i).getNum(),
                    computerHand.get(i).getColor()));
        }
        compHbox.setBackground(new Background(new BackgroundFill(Color
                .rgb(72, 103, 178),CornerRadii.EMPTY, Insets.EMPTY)));
    }

    /**
     * Helper method to draw tiles in tilepool (deck of tiles).
     */
    private void drawTilePool() {
        for (Tile tile : tilePool) {
            tilePane.setPrefSize(160, 300);
            tilePane.setPadding(new Insets(246, 58,50,40));
            tilePane.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
            tilePane.getChildren().add(new Tile(tile.getNum(), tile.getColor()));
        }
        tilePane.setBackground(new Background(new BackgroundFill(Color
                .rgb(72, 103, 178),CornerRadii.EMPTY, Insets.EMPTY)));
    }

    /**
     * Helper method to draw discard area for human player.
     */
    private void drawHumanDiscardStack() {
        for (Tile tile : humanDiscard) {
            humanDiscardStack.setPrefSize(150, 100);
            humanDiscardStack.setBorder(new Border(new BorderStroke(Color.YELLOW,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
            humanDiscardStack.getChildren().add(new Tile(tile.getNum(), tile.getColor()));
        }
    }
    /**
     * Helper method to draw discard area for computer player.
     */
    private void drawCompDiscardStack() {
        for (Tile tile : compDiscard) {
            compDiscardStack.setPrefSize(150, 100);
            compDiscardStack.setBorder(new Border(new BorderStroke(Color
                    .YELLOW,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                    .DEFAULT, Insets.EMPTY)));
            compDiscardStack.getChildren().add(new Tile(tile.getNum(),
                    tile.getColor()));
        }
    }

    /**
     * Setting up the game, drawing panels, and layout
     * draws the layout.
     */
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

        humanHand = gameCoordinator.getHumanPlayersHand();
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

        borderPane.setCenter(emptyRegion);

        emptyRegion.setBackground(new Background(new BackgroundFill(Color
         .rgb(72, 103, 178),CornerRadii.EMPTY, Insets.EMPTY)));
        emptyRegion.setBorder(new Border(new BorderStroke(Color.DARKBLUE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));

        humanDiscardStack.setBackground(new Background(new BackgroundFill(Color
                .rgb(72, 103, 178),CornerRadii.EMPTY, Insets.EMPTY)));
        humanDiscardStack.setPrefSize(150, 100);
        humanDiscardStack.setBorder(new Border(new BorderStroke(Color.YELLOW,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));

        compDiscardStack.setBackground(new Background(new BackgroundFill(Color
                .rgb(72, 103, 178),CornerRadii.EMPTY, Insets.EMPTY)));
        compDiscardStack.setPrefSize(150, 100);
        compDiscardStack.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));

        addTilesToHuman();

        addTilesToComp();

        drawTilePool();
    }

    @Override
    /**
     * Initally, sets the game, give each player 14 tiles.
     * Human takes first turn, he has the option of either picking
     * up from the computer's discard pile or from the tilePool, then discard
     * the tile. Computer player picks from tilePool and discards the tile
     * after. Using mouse events to detect a human clicked. Also, have a dialog
     * box for the rules of the game.
     */
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
                            tilePane.getChildren().remove(tilePool.removeLast());
                            drawTilePool();
                            humanHbox.getChildren().remove(6);
                            drawHumanDiscardStack();
                            gameCoordinator.turn = true;
                        }
                    });
                    compDiscardStack.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            gameCoordinator.playerOptions("discard");
                            humanHbox.getChildren().add(new Tile(humanHand.getLast()
                                    .getNum(),
                                    humanHand.getLast().getColor()));
                            compDiscardStack.getChildren().remove(compDiscard.removeLast());
                            drawCompDiscardStack();
                            humanHbox.getChildren().remove(6);

                            gameCoordinator.turn = true;
                        }
                    });
                    humanHbox.setOnMousePressed(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {

                        }
                    });
                }
                else {
                    gameCoordinator.playerOptions("tilePool");
                    compHbox.getChildren().add(new Tile(computerHand.getLast
                            ().getNum(), computerHand.getLast().getColor()));
                    tilePane.getChildren().remove(tilePool.removeLast());
                    compHbox.getChildren().remove(gameCoordinator.computerDiscarded());
                    drawTilePool();
                    drawCompDiscardStack();
                }
            }
        };
        timer.start();

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

        vBox.setSpacing(200);
        vBox.getChildren().addAll(rules);

        vBox.setPrefSize(150, 300);
        vBox.setBackground(new Background(new BackgroundFill(Color
                .rgb(72, 103, 178),CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths
                .DEFAULT, Insets.EMPTY)));




        root.getChildren().addAll(borderPane);

        primaryStage.setTitle("Remi Tile Game");
        primaryStage.setScene(new Scene(root, 1280, 600));
        primaryStage.show();
    }
}
