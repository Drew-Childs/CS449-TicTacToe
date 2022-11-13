package SOS.Scenes;

import SOS.Components.GameModeSelector;
import SOS.Components.MoveSelector;
import SOS.Components.Tile;
import SOS.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    final int boardSize = Settings.sizeSelector.selector.getValue();
    public static List<List<Tile>> tileGrid;
    public Label header;
    public static Label turnOrder;
    public static MoveSelector redMoveSelector;
    public static MoveSelector blueMoveSelector;
    Button newGame;
    public HBox boardWithControls;
    public VBox gameBoard;
    BorderPane layout;
    public Scene scene;

    public GameBoard() {
        layout = new BorderPane();
        header = new Label("Welcome to the game board!");

        redMoveSelector = new MoveSelector("Red");
        blueMoveSelector = new MoveSelector("Blue");

        boardWithControls = new HBox(redMoveSelector.segment, drawBlankBoard(), blueMoveSelector.segment);
        boardWithControls.setAlignment(Pos.TOP_CENTER);
        boardWithControls.setSpacing(30);

        newGame = new Button("New Game");
        newGame.setOnAction(e -> {
            Main.primaryStage.setScene(new Settings().scene);
        });

        turnOrder = new Label();
        setTurnText(GameModeSelector.gameLogic.playerOneTurn);

        gameBoard = new VBox(header, boardWithControls, turnOrder, newGame);
        gameBoard.setAlignment(Pos.BASELINE_CENTER);
        gameBoard.setSpacing(20);

        layout.setCenter(gameBoard);

        scene = new Scene(layout, 700, 600);
    }

    VBox drawBlankBoard() {
        tileGrid = new ArrayList<>(boardSize);
        for(int i = 0; i < boardSize; i++) {
            tileGrid.add(new ArrayList());
        }

        VBox tileColumns = new VBox();

        for (int i = 0; i < boardSize; i++) {
            HBox tileRows = new HBox();
            for (int j = 0; j < boardSize; j++) {
                Tile gameTile = new Tile();
                tileGrid.get(i).add(j, gameTile);
                tileRows.getChildren().add(tileGrid.get(i).get(j).segment);
            }
            tileColumns.getChildren().add(tileRows);
        }

        return tileColumns;
    }

    public static void setTurnText(Boolean playerOneTurn) {
        if (playerOneTurn) {
            turnOrder.setText("Red's Turn!");

            if (redMoveSelector.computerSelected) {
                redMoveSelector.computerLogic.computeMove();
            }
        }
        else {
            turnOrder.setText("Blue's Turn!");

            if (blueMoveSelector.computerSelected) {
                blueMoveSelector.computerLogic.computeMove();
            }
        }
    }
}
