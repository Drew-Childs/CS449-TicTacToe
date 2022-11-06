package SOS.Components;

import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

public class SizeSelector {
    public ChoiceBox<Integer> selector;
    public VBox segment;

    public SizeSelector() {
        selector = new ChoiceBox<>();
        selector.getItems().addAll(3, 4, 5, 6, 7, 8);
        selector.setValue(3);

        segment = new VBox(selector);
        segment.setAlignment(Pos.TOP_RIGHT);
    }
}
