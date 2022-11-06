package Components;

import SOS.Components.GameModeSelector;
import SOS.Components.MoveSelector;
import SOS.Components.SizeSelector;
import SOS.Components.Tile;
import SOS.GameLogic.GameLogic;
import SOS.Scenes.GameBoard;
import SOS.Scenes.Settings;
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
        GameModeSelector.gameLogic = new GameLogic();
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
        GameModeSelector.gameLogic.switchTurn();

        // when
        tile.placeMove();

        // then
        assertEquals(tile.value.getText(), "S");
    }

    @Test
    public void testPlaceMove_PlayerTwoOSelected() {
        // given
        GameModeSelector.gameLogic.switchTurn();
        GameBoard.blueMoveSelector.handle(new ActionEvent());

        // when
        tile.placeMove();

        // then
        assertEquals(tile.value.getText(), "O");
    }

    @Test
    public void testHorizontalLineVisible_playerOneTurn() {
        // given
        GameModeSelector.gameLogic.playerOneTurn = true;

        // when
        tile.horizontalLineVisible();

        // then
        assertEquals(3, tile.horizontalLine.getStrokeWidth());
        assertEquals(Color.RED, tile.horizontalLine.getStroke());
    }

    @Test
    public void testHorizontalLineVisible_playerTwoTurn() {
        // given
        GameModeSelector.gameLogic.playerOneTurn = false;

        // when
        tile.horizontalLineVisible();

        // then
        assertEquals(3, tile.horizontalLine.getStrokeWidth());
        assertEquals(Color.BLUE, tile.horizontalLine.getStroke());
    }

    @Test
    public void testVerticalLineVisible_playerOneturn() {
        // given
        GameModeSelector.gameLogic.playerOneTurn = true;

        // when
        tile.verticalLineVisible();

        // then
        assertEquals(3, tile.verticalLine.getStrokeWidth());
        assertEquals(Color.RED, tile.verticalLine.getStroke());
    }

    @Test
    public void testVerticalLineVisible_playerTwoTurn() {
        // given
        GameModeSelector.gameLogic.playerOneTurn = false;

        // when
        tile.verticalLineVisible();

        // then
        assertEquals(3, tile.verticalLine.getStrokeWidth());
        assertEquals(Color.BLUE, tile.verticalLine.getStroke());
    }

    @Test
    public void testDiagonalLineOneVisible_playerOneTurn() {
        // given
        GameModeSelector.gameLogic.playerOneTurn = true;

        // when
        tile.diagonalLineOneVisible();

        // then
        assertEquals(3, tile.diagonalLineOne.getStrokeWidth());
        assertEquals(Color.RED, tile.diagonalLineOne.getStroke());
    }

    @Test
    public void testDiagonalLineOneVisible_playerTwoTurn() {
        // given
        GameModeSelector.gameLogic.playerOneTurn = false;

        // when
        tile.diagonalLineOneVisible();

        // then
        assertEquals(3, tile.diagonalLineOne.getStrokeWidth());
        assertEquals(Color.BLUE, tile.diagonalLineOne.getStroke());
    }

    @Test
    public void testDiagonalLineTwoVisible_playerOneTurn() {
        // given
        GameModeSelector.gameLogic.playerOneTurn = true;

        // when
        tile.diagonalLineTwoVisible();

        // then
        assertEquals(3, tile.diagonalLineTwo.getStrokeWidth());
        assertEquals(Color.RED, tile.diagonalLineTwo.getStroke());
    }

    @Test
    public void testDiagonalLineTwoVisible_playerTwoTurn() {
        // given
        GameModeSelector.gameLogic.playerOneTurn = false;

        // when
        tile.diagonalLineTwoVisible();

        // then
        assertEquals(3, tile.diagonalLineTwo.getStrokeWidth());
        assertEquals(Color.BLUE, tile.diagonalLineTwo.getStroke());
    }
}
