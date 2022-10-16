package Components;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class GameModeSelector implements EventHandler<ActionEvent> {
    RadioButton simpleGame;
    RadioButton standardGame;
    public VBox selection;
    public Boolean simpleGameMode;

    public GameModeSelector() {
        simpleGame = new RadioButton("Simple Game");
        standardGame = new RadioButton("Standard Game");

        simpleGame.setOnAction(this);
        standardGame.setOnAction(this);

        simpleGameMode = true;
        simpleGame.setSelected(simpleGameMode);

        selection = new VBox(simpleGame, standardGame);
    }

    @Override
    public void handle(ActionEvent event) {
        simpleGameMode = !simpleGameMode;
        simpleGame.setSelected(simpleGameMode);
        standardGame.setSelected(!simpleGameMode);
    }
}
