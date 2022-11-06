package Components;


import SOS.Components.GameModeSelector;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicSelectorTest {
    JFXPanel panel = new JFXPanel();

    @Test
    public void testConstructor() {
        // given/when
        GameModeSelector gameModeSelector = new GameModeSelector();

        // then
        assertEquals(GameModeSelector.gameLogic.simpleGameMode, true);
        assertEquals(gameModeSelector.simpleGame.isSelected(), true);
        assertEquals(gameModeSelector.simpleGame.getText(), "Simple Game");
        assertEquals(gameModeSelector.standardGame.getText(), "Standard Game");
    }

    @Test
    public void testHandle() {
        // given
        GameModeSelector gameModeSelector = new GameModeSelector();

        // when
        gameModeSelector.handle(new ActionEvent());

        // then
        assertEquals(GameModeSelector.gameLogic.simpleGameMode, false);
        assertEquals(gameModeSelector.simpleGame.isSelected(), false);
        assertEquals(gameModeSelector.standardGame.isSelected(), true);
    }
}
