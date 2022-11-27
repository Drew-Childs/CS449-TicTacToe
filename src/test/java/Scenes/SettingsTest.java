package Scenes;

import SOS.Scenes.Settings;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SettingsTest {
    Settings settings;
    JFXPanel panel = new JFXPanel();

    @Test
    public void testConstructor() {
        // given/when
        settings = new Settings();

        // then
        assertEquals(settings.welcomeText.getText(), "Welcome to SOS!");
        assertEquals(settings.confirm.getText(), "Confirm");

        assertEquals(settings.controls.getAlignment(), Pos.TOP_LEFT);
        assertEquals(settings.controls.getSpacing(), 20);

        assertEquals(settings.segment.getAlignment(), Pos.BASELINE_CENTER);
        assertEquals(settings.segment.getSpacing(), 30);
    }
}
