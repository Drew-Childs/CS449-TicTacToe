package GameLogic;

import SOS.Components.GameModeSelector;
import SOS.Components.GameOver;
import SOS.Components.Tile;
import SOS.GameLogic.ComputerPlayer;
import SOS.GameLogic.GameLogic;
import SOS.Scenes.GameBoard;
import SOS.Scenes.Settings;
import javafx.embed.swing.JFXPanel;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class ComputerPlayerTest {
    JFXPanel panel = new JFXPanel();

    Settings settings;
    GameModeSelector selector;
    GameBoard gameBoard;
    GameOver gameOver;

    @BeforeEach
    public void setup() {
        settings = new Settings();
        Settings.sizeSelector.selector.setValue(3);

        gameBoard = new GameBoard();
        selector = new GameModeSelector();
        gameOver = new GameOver();
    }

    @Test
    public void testComputeMove_RedComputerNotSelected() {
        // given
        GameBoard.redMoveSelector.computerSelected = false;

        // when
        ComputerPlayer.computeMove();

        // then
        for (Integer x = 0; x < Settings.sizeSelector.selector.getValue(); x++) {
            for (Integer y = 0; y < Settings.sizeSelector.selector.getValue(); y++) {
                assertEquals(null, GameBoard.tileGrid.get(y).get(x).value.getText());
            }
        }
    }

    @Test
    public void testComputeMove_BlueComputerNotSelected() {
        // given
        GameBoard.redMoveSelector.computerSelected = false;
        GameModeSelector.gameLogic.playerOneTurn = false;

        // when
        ComputerPlayer.computeMove();

        // then
        for (Integer x = 0; x < Settings.sizeSelector.selector.getValue(); x++) {
            for (Integer y = 0; y < Settings.sizeSelector.selector.getValue(); y++) {
                assertEquals(null, GameBoard.tileGrid.get(y).get(x).value.getText());
            }
        }
    }

    @Test
    public void testComputeMove_OpenSO() {
        // given
        GameBoard.redMoveSelector.computerSelected = true;

        GameBoard.tileGrid.get(0).get(0).value.setText("S");
        GameBoard.tileGrid.get(0).get(1).value.setText("O");

        // when
        try {
            ComputerPlayer.computeMove();
        }
        catch (IllegalStateException e) {}

        // then
        assertEquals("S", GameBoard.tileGrid.get(0).get(2).value.getText());
    }

    @Test
    public void testComputeMove_OpenSS() {
        // given
        GameBoard.redMoveSelector.computerSelected = true;

        GameBoard.tileGrid.get(0).get(0).value.setText("S");
        GameBoard.tileGrid.get(0).get(2).value.setText("S");

        // when
        try {
            ComputerPlayer.computeMove();
        }
        catch (IllegalStateException e) {}

        // then
        assertEquals("O", GameBoard.tileGrid.get(0).get(1).value.getText());
    }

    @Test
    public void testComputeMove_RandomMove() {
        // given
        GameBoard.redMoveSelector.computerSelected = true;

        // when
        try {
            ComputerPlayer.computeMove();
        }
        catch (IllegalStateException e) {}

        // then
        int placed = 0;

        for (Integer x = 0; x < Settings.sizeSelector.selector.getValue(); x++) {
            for (Integer y = 0; y < Settings.sizeSelector.selector.getValue(); y++) {
                if (!StringUtils.equals(null, GameBoard.tileGrid.get(y).get(x).value.getText())) {
                    placed += 1;
                }
            }
        }
        assertEquals(1, placed);
    }
}
