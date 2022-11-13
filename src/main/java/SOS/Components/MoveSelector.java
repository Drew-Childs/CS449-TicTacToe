package SOS.Components;

import SOS.GameLogic.ComputerPlayer;
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
    public Label playerText;
    public Boolean sSelected;
    public Boolean computerSelected;
    public ComputerPlayer computerLogic;

    public MoveSelector(String player) {
        playerText = new Label(player + " Player:");
        human = new RadioButton("Human");
        computer = new RadioButton("Computer");
        sButton = new RadioButton("S");
        oButton = new RadioButton("O");

        computerLogic = new ComputerPlayer();

        human.setOnAction(this);
        computer.setOnAction(this);
        oButton.setOnAction(this);
        sButton.setOnAction(this);

        sSelected = true;
        computerSelected = false;
        sButton.setSelected(sSelected);
        human.setSelected(!computerSelected);

        VBox so = new VBox(sButton, oButton);
        so.setAlignment(Pos.BASELINE_CENTER);

        segment = new VBox(playerText, computer, human, so);
        segment.setAlignment(Pos.TOP_LEFT);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getTarget() == computer) {
            computerSelected = true;
            human.setSelected(!computerSelected);
            computer.setSelected(computerSelected);

            oButton.setSelected(false);
            sButton.setSelected(false);

            computerLogic.computeMove();
        }
        else if (event.getTarget() == human) {
            computerSelected = false;
            human.setSelected(!computerSelected);
            computer.setSelected(computerSelected);

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
