package GameLogic;

import SOS.GameLogic.GameLogic;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicTest {
    JFXPanel panel = new JFXPanel();

    @Test
    public void testConstructor() {
        // given/when
        GameLogic gameLogic = new GameLogic();

        // then
        assertEquals(gameLogic.playerOneTurn, true);
        assertEquals(gameLogic.simpleGameMode, true);
    }
}
