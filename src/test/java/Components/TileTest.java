package Components;

import GameLogic.GameMode;
import Scenes.GameBoard;
import Scenes.Settings;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TileTest {
    JFXPanel panel = new JFXPanel();
    Tile tile;

    @BeforeEach
    void setup() {
        tile = new Tile();
        Settings.sizeSelector = new SizeSelector();
        GameModeSelector.gameMode = new GameMode();
        GameBoard gameBoard = new GameBoard();
        GameBoard.redMoveSelector = new MoveSelector("Red");
        GameBoard.blueMoveSelector = new MoveSelector("Blue");
    }

    @Test
    public void testConstructor() {
        // then
        assertEquals(tile.box.getHeight(), 50);
        assertEquals(tile.box.getWidth(), 50);
        assertEquals(tile.box.getStroke(), Color.rgb(0, 0, 0));

        assertEquals(tile.value.getText(), null);
    }

    @Test
    public void testPlaceMove_ExistingMove() {
        // given
        Tile tile = new Tile();
        tile.value.setText("Testing");

        // when
        tile.placeMove();

        // then
        assertEquals(tile.value.getText(), "Testing");
    }

    @Test
    public void testPlaceMove_PlayerOneSSelected() {
        // when
        tile.placeMove();

        // then
        assertEquals(tile.value.getText(), "S");
    }

    @Test
    public void testPlaceMove_PlayerOneOSelected() {
        // given
        GameBoard.redMoveSelector.handle(new ActionEvent());

        // when
        tile.placeMove();

        // then
        assertEquals(tile.value.getText(), "O");
    }

    @Test
    public void testPlaceMove_PlayerTwoSSelected() {
        // given
        GameModeSelector.gameMode.currentTurn.switchTurn();

        // when
        tile.placeMove();

        // then
        assertEquals(tile.value.getText(), "S");
    }

    @Test
    public void testPlaceMove_PlayerTwoOSelected() {
        // given
        GameModeSelector.gameMode.currentTurn.switchTurn();
        GameBoard.blueMoveSelector.handle(new ActionEvent());

        // when
        tile.placeMove();

        // then
        assertEquals(tile.value.getText(), "O");
    }
}