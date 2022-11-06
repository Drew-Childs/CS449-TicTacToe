package Scenes;

import SOS.Components.GameModeSelector;
import SOS.Components.SizeSelector;
import SOS.GameLogic.GameLogic;
import SOS.Scenes.GameBoard;
import SOS.Scenes.Settings;
import javafx.geometry.Pos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameBoardTest {
    JFXPanel panel = new JFXPanel();

    @BeforeEach
    void setup() {
        Settings.sizeSelector = new SizeSelector();
        GameModeSelector.gameLogic = new GameLogic();
    }

    @Test
    public void testConstructor() {
        // when
        GameBoard gameBoard = new GameBoard();

        // then
        assertEquals(gameBoard.header.getText(), "Welcome to the game board!");
        assertEquals(GameBoard.turnOrder.getText(), "Red's Turn!");

        assertEquals(gameBoard.boardWithControls.getAlignment(), Pos.TOP_CENTER);
        assertEquals(gameBoard.boardWithControls.getSpacing(), 30);
        assertEquals(gameBoard.gameBoard.getAlignment(), Pos.BASELINE_CENTER);
        assertEquals(gameBoard.gameBoard.getSpacing(), 20);
    }

    @Test
    public void testDrawBlankBoard() {
        // given
        GameBoard gameBoard = new GameBoard();

        // then
        assertEquals(gameBoard.tileGrid.size(), 3);
        assertEquals(gameBoard.tileGrid.get(2).get(2).value.getText(), null);
    }

    @Test
    public void testSetTurnText_PlayerOne() {
        // given
        GameBoard gameBoard = new GameBoard();

        // when
        GameBoard.setTurnText(true);

        // then
        assertEquals(GameBoard.turnOrder.getText(), "Red's Turn!");
    }

    @Test
    public void testSetTurnText_PlayerTwo() {
        // given
        GameBoard gameBoard = new GameBoard();

        // when
        GameBoard.setTurnText(false);

        // then
        assertEquals(GameBoard.turnOrder.getText(), "Blue's Turn!");
    }
}
