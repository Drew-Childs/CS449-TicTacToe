package SOS.Components;

import SOS.Scenes.GameBoard;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Tile {
    public Rectangle box;
    public StackPane segment;
    public Label value;
    Line horizontalLine;
    Line verticalLine;
    Line diagonalLineOne;
    Line diagonalLineTwo;

    public Tile() {
        box = new Rectangle(50, 50, null);
        box.setStroke(Color.BLACK);
        value = new Label(null);

        horizontalLine = new Line(0, 25, 45, 25);
        horizontalLine.setStrokeWidth(0);
        verticalLine = new Line(25, 0, 25, 45);
        verticalLine.setStrokeWidth(0);
        diagonalLineOne = new Line(0, 0, 45, 45);
        diagonalLineOne.setStrokeWidth(0);
        diagonalLineTwo = new Line(0, 45, 45, 0);
        diagonalLineTwo.setStrokeWidth(0);

        segment = new StackPane(box, value, horizontalLine, verticalLine, diagonalLineOne, diagonalLineTwo);
        segment.setOnMouseClicked(e -> placeMove());
    }

    public void placeMove() {
        if (value.getText() == null) {
            if (!GameModeSelector.gameLogic.isGameOver()) {
                if (GameModeSelector.gameLogic.playerOneTurn) {
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
            }
            if (GameModeSelector.gameLogic.isGameOver()) {
                // display according error message
                String message;
                if (GameModeSelector.gameLogic.draw) {
                    message = "Game is a draw!";
                }
                else if (GameModeSelector.gameLogic.playerOneWin) {
                    message = "Red player wins!";
                }
                else {
                    message = "Blue player wins!";
                }

                GameOver gameOver = new GameOver();
                gameOver.display(message);

                return;
            }

            GameModeSelector.gameLogic.switchTurn();
            GameBoard.setTurnText(GameModeSelector.gameLogic.playerOneTurn);
        }
    }

    public void horizontalLineVisible() {
        horizontalLine.setStrokeWidth(3);
        horizontalLine.setStroke(GameModeSelector.gameLogic.playerOneTurn ? Color.RED : Color.BLUE);
    }

    public void verticalLineVisible() {
        verticalLine.setStrokeWidth(3);
        verticalLine.setStroke(GameModeSelector.gameLogic.playerOneTurn ? Color.RED : Color.BLUE);
    }

    public void diagonalLineOneVisible() {
        diagonalLineOne.setStrokeWidth(3);
        diagonalLineOne.setStroke(GameModeSelector.gameLogic.playerOneTurn ? Color.RED : Color.BLUE);
    }

    public void diagonalLineTwoVisible() {
        diagonalLineTwo.setStrokeWidth(3);
        diagonalLineTwo.setStroke(GameModeSelector.gameLogic.playerOneTurn ? Color.RED : Color.BLUE);
    }
}
