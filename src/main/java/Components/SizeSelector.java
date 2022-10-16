package Components;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SizeSelector {
    Text text;
    TextField size;
    ChoiceBox<Integer> selector;
    public VBox selection;

    public SizeSelector() {
        selector = new ChoiceBox<>();
        selector.getItems().addAll(3, 4, 5, 6, 7, 8);

        selection = new VBox(selector);
    }
}
