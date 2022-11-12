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
    public RadioButton human;
    public RadioButton computer;
    public VBox segment;
    public Boolean sSelected;
    public Boolean humanSelected;
    public Label playerText;

    public MoveSelector(String player) {
        playerText = new Label(player + " Player:");
        human = new RadioButton("Human");
        computer = new RadioButton("Computer");
        sButton = new RadioButton("S");
        oButton = new RadioButton("O");

        human.setOnAction(this);
        computer.setOnAction(this);
        oButton.setOnAction(this);
        sButton.setOnAction(this);

        sSelected = true;
        humanSelected = true;
        sButton.setSelected(sSelected);
        human.setSelected(humanSelected);

        VBox so = new VBox(sButton, oButton);
        so.setAlignment(Pos.BASELINE_CENTER);

        segment = new VBox(playerText, computer, human, so);
        segment.setAlignment(Pos.TOP_LEFT);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getTarget() == computer) {
            humanSelected = false;
            human.setSelected(humanSelected);
            computer.setSelected(!humanSelected);

            oButton.setSelected(false);
            sButton.setSelected(false);
        }
        else if (event.getTarget() == human) {
            humanSelected = true;
            human.setSelected(humanSelected);
            computer.setSelected(!humanSelected);

            sButton.setSelected(sSelected);
            oButton.setSelected(!sSelected);
        }
        else {
            sSelected = !sSelected;
            sButton.setSelected(sSelected);
            oButton.setSelected(!sSelected);
        }
    }
}
