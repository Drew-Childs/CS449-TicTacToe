package Components;

import Scenes.GameBoard;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile {
    Rectangle box;
    public StackPane segment;
    public Label value;

    public Tile() {
        box = new Rectangle(50, 50, null);
        box.setStroke(Color.rgb(0, 0, 0));
        value = new Label(null);

        segment = new StackPane(box, value);
        segment.setOnMouseClicked(e -> placeMove());
    }

    public void placeMove() {
        if (value.getText() == null) {
            if (GameModeSelector.gameMode.currentTurn.playerOneTurn) {
                if (GameBoard.redMoveSelector.sSelected) {
                    value.setText("S");
                } else {
                    value.setText("O");
                }
            } else {
                if (GameBoard.blueMoveSelector.sSelected) {
                    value.setText("S");
                } else {
                    value.setText("O");
                }
            }
            GameModeSelector.gameMode.currentTurn.switchTurn();
            GameBoard.setTurnText(GameModeSelector.gameMode.currentTurn.playerOneTurn);
        }
    }
    // TODO: Code cleanup

}
