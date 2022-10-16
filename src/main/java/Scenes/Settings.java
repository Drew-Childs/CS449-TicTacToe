package Scenes;

import Components.GameModeSelector;
import Components.SizeSelector;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Settings {
    Label welcomeText;
    GameModeSelector gameSelector;
    SizeSelector sizeSelector;
    public Button confirm;
    BorderPane layout;
    public Scene scene;

    public Settings() {
        welcomeText = new Label("Welcome to SOS!");
        confirm = new Button("Confirm");
        gameSelector = new GameModeSelector();
        sizeSelector = new SizeSelector();

        layout = new BorderPane();

        HBox beans = new HBox(gameSelector.selection, sizeSelector.selection);
        VBox ope = new VBox(beans, confirm);

        layout.setTop(welcomeText);
        layout.setCenter(ope);

        scene = new Scene(layout, 300, 300);
    }
}
