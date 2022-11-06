package SOS.Scenes;

import SOS.Components.GameModeSelector;
import SOS.Components.SizeSelector;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import SOS.Main;

public class Settings {
    public Label welcomeText;
    public static GameModeSelector gameSelector;
    public static SizeSelector sizeSelector;
    public Button confirm;
    public HBox controls;
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

        controls = new HBox(gameSelector.segment, sizeSelector.segment);
        controls.setAlignment(Pos.TOP_CENTER);
        controls.setSpacing(50);

        segment = new VBox(welcomeText, controls, confirm);
        segment.setAlignment(Pos.BASELINE_CENTER);
        segment.setSpacing(30);

        layout.setCenter(segment);

        scene = new Scene(layout,300, 300);
    }
}
