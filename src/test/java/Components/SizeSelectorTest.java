package Components;

import SOS.Components.SizeSelector;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SizeSelectorTest {
    JFXPanel panel = new JFXPanel();

    @Test
    public void testConstructor() {
        // given
        ArrayList items = new ArrayList<>();
        items.add(3);
        items.add(4);
        items.add(5);
        items.add(6);
        items.add(7);
        items.add(8);

        // when
        SizeSelector sizeSelector = new SizeSelector();

        // then
        assertEquals(sizeSelector.selector.getItems(), items);
        assertEquals(sizeSelector.selector.getValue(), 3);
    }
}
