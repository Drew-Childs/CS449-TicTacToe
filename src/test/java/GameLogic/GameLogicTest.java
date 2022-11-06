package GameLogic;

import SOS.Components.SizeSelector;
import SOS.GameLogic.GameLogic;
import SOS.Scenes.GameBoard;
import SOS.Scenes.Settings;
import javafx.scene.control.ChoiceBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameLogicTest {
    JFXPanel panel = new JFXPanel();
    GameLogic gameLogic;
    GameBoard gameBoard;
    Settings settings;

    @BeforeEach
    public void setup() {
        settings = new Settings();
        Settings.sizeSelector.selector.setValue(3);

        gameLogic = new GameLogic();
        gameBoard = new GameBoard();
    }

    @Test
    public void testConstructor() {
        // given/when
        GameLogic gameLogic = new GameLogic();

        // then
        assertEquals(gameLogic.playerOneTurn, true);
        assertEquals(gameLogic.simpleGameMode, true);
    }

    @Test
    public void testIsGameOver_simpleGame_oneStrikeThrough() {
        // given
        GameLogic.simpleGameMode = true;
        GameLogic.scoredSOS.put("000102", true);

        // when
        Boolean response = gameLogic.isGameOver();

        // then
        assertEquals(true, GameLogic.playerOneWin);
        assertEquals(true, response);
    }

    @Test
    public void testIsGameOver_simpleGame_emptyBoard() {
        // given
        GameLogic.simpleGameMode = true;

        // when
        Boolean response = gameLogic.isGameOver();

        // then
        assertEquals(false, response);
    }

    @Test
    public void testIsGameOver_simpleGame_fullBoard() {
        // given
        GameLogic.simpleGameMode = true;

        GameBoard.tileGrid.get(0).get(0).value.setText("S");
        GameBoard.tileGrid.get(0).get(1).value.setText("S");
        GameBoard.tileGrid.get(0).get(2).value.setText("S");
        GameBoard.tileGrid.get(1).get(0).value.setText("S");
        GameBoard.tileGrid.get(1).get(1).value.setText("S");
        GameBoard.tileGrid.get(1).get(2).value.setText("S");
        GameBoard.tileGrid.get(2).get(0).value.setText("S");
        GameBoard.tileGrid.get(2).get(1).value.setText("S");
        GameBoard.tileGrid.get(2).get(2).value.setText("S");

        // when
        Boolean response = gameLogic.isGameOver();

        // then
        assertEquals(true, response);
        assertEquals(true, GameLogic.draw);
    }

    @Test
    public void testIsGameOver_standardGame_emptyBoard() {
        // given
        GameLogic.simpleGameMode = false;

        // when
        Boolean response = gameLogic.isGameOver();

        // then
        assertEquals(false, response);
    }

    @Test
    public void testCheckStandardGame_equalStrikeThrough() {
        // given
        GameLogic.simpleGameMode = false;

        GameBoard.tileGrid.get(0).get(0).value.setText("S");
        GameBoard.tileGrid.get(0).get(1).value.setText("S");
        GameBoard.tileGrid.get(0).get(2).value.setText("S");
        GameBoard.tileGrid.get(1).get(0).value.setText("S");
        GameBoard.tileGrid.get(1).get(1).value.setText("S");
        GameBoard.tileGrid.get(1).get(2).value.setText("S");
        GameBoard.tileGrid.get(2).get(0).value.setText("S");
        GameBoard.tileGrid.get(2).get(1).value.setText("S");
        GameBoard.tileGrid.get(2).get(2).value.setText("S");

        GameLogic.scoredSOS.put("000102", true);
        GameLogic.scoredSOS.put("001122", false);

        // when
        Boolean response = gameLogic.isGameOver();

        // then
        assertEquals(true, response);
        assertEquals(true, GameLogic.draw);
    }

    @Test
    public void testCheckStandardGame_playerOneWin() {
        // given
        GameLogic.simpleGameMode = false;

        GameBoard.tileGrid.get(0).get(0).value.setText("S");
        GameBoard.tileGrid.get(0).get(1).value.setText("S");
        GameBoard.tileGrid.get(0).get(2).value.setText("S");
        GameBoard.tileGrid.get(1).get(0).value.setText("S");
        GameBoard.tileGrid.get(1).get(1).value.setText("S");
        GameBoard.tileGrid.get(1).get(2).value.setText("S");
        GameBoard.tileGrid.get(2).get(0).value.setText("S");
        GameBoard.tileGrid.get(2).get(1).value.setText("S");
        GameBoard.tileGrid.get(2).get(2).value.setText("S");

        GameLogic.scoredSOS.put("000102", true);

        // when
        Boolean response = gameLogic.isGameOver();

        // then
        assertEquals(true, response);
        assertEquals(true, GameLogic.playerOneWin);
    }

    @Test
    public void testCheckStandardGame_playerTwoWin() {
        // given
        GameLogic.simpleGameMode = false;

        GameBoard.tileGrid.get(0).get(0).value.setText("S");
        GameBoard.tileGrid.get(0).get(1).value.setText("S");
        GameBoard.tileGrid.get(0).get(2).value.setText("S");
        GameBoard.tileGrid.get(1).get(0).value.setText("S");
        GameBoard.tileGrid.get(1).get(1).value.setText("S");
        GameBoard.tileGrid.get(1).get(2).value.setText("S");
        GameBoard.tileGrid.get(2).get(0).value.setText("S");
        GameBoard.tileGrid.get(2).get(1).value.setText("S");
        GameBoard.tileGrid.get(2).get(2).value.setText("S");

        GameLogic.scoredSOS.put("000102", false);

        // when
        Boolean response = gameLogic.isGameOver();

        // then
        assertEquals(true, response);
        assertEquals(false, GameLogic.playerOneWin);
    }
}
