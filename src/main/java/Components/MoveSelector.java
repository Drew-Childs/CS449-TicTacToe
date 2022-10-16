package Components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

import javax.swing.*;

public class MoveSelector implements EventHandler<ActionEvent> {
    RadioButton sButton;
    RadioButton oButton;
    public VBox selection;
    public Boolean sSelected;
    Label playerText;

    public MoveSelector(String player) {
        playerText = new Label(player + " Player:");
        sButton = new RadioButton("S");
        oButton = new RadioButton("O");

        oButton.setOnAction(this);
        sButton.setOnAction(this);

        sSelected = true;
        sButton.setSelected(sSelected);

        selection = new VBox(playerText, sButton, oButton);
    }

    @Override
    public void handle(ActionEvent event) {
        sSelected = !sSelected;
        sButton.setSelected(sSelected);
        oButton.setSelected(!sSelected);
    }
}
