package GameLogic;

import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovesTest {
    JFXPanel panel = new JFXPanel();

    @Test
    public void testConstructor() {
        // given/when
        Moves moves = new Moves();

        // then
        assertEquals(moves.playerOneTurn, true);
    }

    @Test
    public void testSwitchTurn() {
        // given
        Moves moves = new Moves();

        // when
        moves.switchTurn();

        // then
        assertEquals(moves.playerOneTurn, false);
    }
}
