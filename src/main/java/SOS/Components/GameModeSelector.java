package SOS.Components;

import SOS.GameLogic.GameLogic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class GameModeSelector implements EventHandler<ActionEvent> {
    public RadioButton simpleGame;
    public RadioButton standardGame;
    public VBox segment;
    public static GameLogic gameLogic;

    public GameModeSelector() {
        gameLogic = new GameLogic();
        simpleGame = new RadioButton("Simple Game");
        standardGame = new RadioButton("Standard Game");

        simpleGame.setOnAction(this);
        standardGame.setOnAction(this);

        simpleGame.setSelected(gameLogic.simpleGameMode);

        segment = new VBox(simpleGame, standardGame);
    }

    @Override
    public void handle(ActionEvent event) {
        gameLogic.simpleGameMode = !gameLogic.simpleGameMode;
        simpleGame.setSelected(gameLogic.simpleGameMode);
        standardGame.setSelected(!gameLogic.simpleGameMode);
    }
}
