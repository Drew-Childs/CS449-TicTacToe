package SOS.Components;

import SOS.Components.Tile;
import SOS.Scenes.GameBoard;
import SOS.Scenes.Settings;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecordGame {
    public static CheckBox checkBox;
    public VBox segment;
    private static List<List<String>> recordedMoves;
    final static int boardSize = Settings.sizeSelector.selector.getValue();

    public RecordGame() {
        checkBox = new CheckBox("Record Game");

        recordedMoves = new ArrayList<>(boardSize);
        for (int i = 0; i < boardSize; i++) {
            recordedMoves.add(new ArrayList<>());
        }

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                recordedMoves.get(i).add(null);
            }
        }

        segment = new VBox(checkBox);
        segment.setAlignment(Pos.TOP_CENTER);
    }
    public static void recordMove() {
        try {
            FileWriter writer = new FileWriter("output.txt", true);

            for (Integer x = 0; x < boardSize; x++) {
                for (Integer y = 0; y < boardSize; y++) {
                    if (GameBoard.tileGrid.get(y).get(x).value.getText() != recordedMoves.get(y).get(x)) {
                        recordedMoves.get(y).set(x, GameBoard.tileGrid.get(y).get(x).value.getText());
                        writer.write(String.format("%d, %d, %s\n", x, y, GameBoard.tileGrid.get(y).get(x).value.getText()));
                    }
                }
            }

            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Unable to write to file...");
        }
    }
}
