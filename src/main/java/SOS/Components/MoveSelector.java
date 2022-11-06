package SOS.Components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class MoveSelector implements EventHandler<ActionEvent> {
    public RadioButton sButton;
    public RadioButton oButton;
    public VBox segment;
    public Boolean sSelected;
    public Label playerText;

    public MoveSelector(String player) {
        playerText = new Label(player + " Player:");
        sButton = new RadioButton("S");
        oButton = new RadioButton("O");

        oButton.setOnAction(this);
        sButton.setOnAction(this);

        sSelected = true;
        sButton.setSelected(sSelected);

        segment = new VBox(playerText, sButton, oButton);
        segment.setAlignment(Pos.TOP_LEFT);
    }

    @Override
    public void handle(ActionEvent event) {
        sSelected = !sSelected;
        sButton.setSelected(sSelected);
        oButton.setSelected(!sSelected);
    }
}
