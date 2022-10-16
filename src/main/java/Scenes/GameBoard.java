package Scenes;

import Components.MoveSelector;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameBoard {
    Label header;
    public Button confirm;
    BorderPane layout;
    public Scene scene;
    MoveSelector redMoveSelector;
    MoveSelector blueMoveSelector;

    public GameBoard() {
        header = new Label("Welcome to the game board!");
        confirm = new Button("Confirm");
        layout = new BorderPane();
        redMoveSelector = new MoveSelector("Red");
        blueMoveSelector = new MoveSelector("Blue");

        HBox beans = new HBox(redMoveSelector.selection, blueMoveSelector.selection);
        VBox ope = new VBox(beans, confirm);

        layout.setTop(header);
        layout.setCenter(ope);

        scene = new Scene(layout, 300, 300);
    }
}
