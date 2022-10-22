package Scenes;

import Components.GameModeSelector;
import Components.MoveSelector;
import Components.Tile;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    Label header;
    BorderPane layout;
    static Label turnOrder;
    public Scene scene;
    public static MoveSelector redMoveSelector;
    public static MoveSelector blueMoveSelector;
    public List<List<Tile>> tileGrid;
    final int boardSize = Settings.sizeSelector.selector.getValue();

    public GameBoard() {
        layout = new BorderPane();
        header = new Label("Welcome to the game board!");

        turnOrder = new Label();
        setTurnText(GameModeSelector.gameMode.currentTurn.playerOneTurn);

        redMoveSelector = new MoveSelector("Red");
        blueMoveSelector = new MoveSelector("Blue");

        HBox boardWithControls = new HBox(redMoveSelector.segment, drawBlankBoard(), blueMoveSelector.segment);
        boardWithControls.setAlignment(Pos.TOP_CENTER);
        boardWithControls.setSpacing(30);

        VBox gameBoard = new VBox(header, boardWithControls, turnOrder);
        gameBoard.setAlignment(Pos.BASELINE_CENTER);
        gameBoard.setSpacing(20);

        layout.setCenter(gameBoard);

        scene = new Scene(layout, 600, 500);
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
        }
        else {
            turnOrder.setText("Blue's Turn!");
        }
    }
}
