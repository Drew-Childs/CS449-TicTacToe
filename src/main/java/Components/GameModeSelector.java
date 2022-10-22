package Components;

import GameLogic.GameMode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class GameModeSelector implements EventHandler<ActionEvent> {
    RadioButton simpleGame;
    RadioButton standardGame;
    public VBox segment;
    public static GameMode gameMode;

    public GameModeSelector() {
        gameMode = new GameMode();
        simpleGame = new RadioButton("Simple Game");
        standardGame = new RadioButton("Standard Game");

        simpleGame.setOnAction(this);
        standardGame.setOnAction(this);

        simpleGame.setSelected(gameMode.simpleGameMode);

        segment = new VBox(simpleGame, standardGame);
    }

    @Override
    public void handle(ActionEvent event) {
        gameMode.simpleGameMode = !gameMode.simpleGameMode;
        simpleGame.setSelected(gameMode.simpleGameMode);
        standardGame.setSelected(!gameMode.simpleGameMode);
    }
}
