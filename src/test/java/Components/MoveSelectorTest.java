package Components;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveSelectorTest {
    JFXPanel panel = new JFXPanel();

    @Test
    public void testConstructor() {
        // given/when
        MoveSelector moveSelector = new MoveSelector("Red");

        // then
        assertEquals(moveSelector.playerText.getText(), "Red Player:");

        assertEquals(moveSelector.sButton.getText(), "S");
        assertEquals(moveSelector.oButton.getText(), "O");
        assertEquals(moveSelector.sButton.isSelected(), true);

        assertEquals(moveSelector.sSelected, true);
    }

    @Test
    public void testHandle() {
        // given
        MoveSelector moveSelector = new MoveSelector("Red");

        // when
        moveSelector.handle(new ActionEvent());

        // then
        assertEquals(moveSelector.sSelected, false);
        assertEquals(moveSelector.sButton.isSelected(), false);
        assertEquals(moveSelector.oButton.isSelected(), true);
    }
}
