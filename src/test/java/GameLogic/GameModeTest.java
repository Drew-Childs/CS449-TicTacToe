package GameLogic;

import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameModeTest {
    JFXPanel panel = new JFXPanel();

    @Test
    public void testConstructor() {
        // given/when
        GameMode gameMode = new GameMode();

        // then
        assertEquals(gameMode.currentTurn.playerOneTurn, true);
        assertEquals(gameMode.simpleGameMode, true);
    }
}
