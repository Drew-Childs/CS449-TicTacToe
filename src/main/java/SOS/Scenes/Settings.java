package SOS.Scenes;

import SOS.Components.GameModeSelector;
import SOS.Components.SizeSelector;
import SOS.Components.RecordGame;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import SOS.Main;

public class Settings {
    public Label welcomeText;
    public static GameModeSelector gameSelector;
    public static SizeSelector sizeSelector;
    public static RecordGame recordGame;
    public Button confirm;
    public VBox controls;
    public VBox segment;
    BorderPane layout;
    public Scene scene;

    public Settings() {
        welcomeText = new Label("Welcome to SOS!");

        confirm = new Button("Confirm");
        confirm.setOnAction(e -> {
            Main.primaryStage.setScene(new GameBoard().scene);
        });

        gameSelector = new GameModeSelector();
        sizeSelector = new SizeSelector();

        layout = new BorderPane();
        recordGame = new RecordGame();

        HBox sizeAndMode = new HBox(gameSelector.segment, sizeSelector.segment);
        sizeAndMode.setAlignment(Pos.TOP_CENTER);
        sizeAndMode.setSpacing(50);

        RecordGame recordGame = new RecordGame();

        controls = new VBox(sizeAndMode, recordGame.segment);
        controls.setSpacing(20);

        segment = new VBox(welcomeText, controls, confirm);
        segment.setAlignment(Pos.BASELINE_CENTER);
        segment.setSpacing(30);

        layout.setCenter(segment);

        scene = new Scene(layout,300, 300);
    }
}
