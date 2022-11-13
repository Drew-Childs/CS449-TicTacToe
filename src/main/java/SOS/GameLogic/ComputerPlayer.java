package SOS.GameLogic;

import SOS.Components.GameModeSelector;
import SOS.Scenes.GameBoard;
import SOS.Scenes.Settings;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class ComputerPlayer {
    public static void computeMove() {
        if ((GameBoard.redMoveSelector.computerSelected && GameModeSelector.gameLogic.playerOneTurn) ||  (GameBoard.blueMoveSelector.computerSelected && !GameModeSelector.gameLogic.playerOneTurn)) {
            // checks for SO_ configuration
            String checkSO = findLocation("S", "O", null, true);

            // checks for S_S configuration
            String checkSS = findLocation("S", null, "S", false);

            if (StringUtils.equals(checkSO, null)) {
                if (StringUtils.equals(checkSS, null)) {
                    // place move randomly
                    Random seed = new Random();

                    if (GameModeSelector.gameLogic.playerOneTurn) {
                        GameBoard.redMoveSelector.sSelected = seed.nextBoolean();
                    }
                    else {
                        GameBoard.blueMoveSelector.sSelected = seed.nextBoolean();
                    }

                    while (true) {
                        int randomX = seed.nextInt(0, Settings.sizeSelector.selector.getValue());
                        int randomY = seed.nextInt(0, Settings.sizeSelector.selector.getValue());

                        if (StringUtils.equals(GameBoard.tileGrid.get(randomY).get(randomX).value.getText(), null)) {
                            GameBoard.tileGrid.get(randomY).get(randomX).placeMove();
                            break;
                        }
                    }
                }
                else {
                    // Place "O" to complete SOS
                    if (GameModeSelector.gameLogic.playerOneTurn) {
                        GameBoard.redMoveSelector.sSelected = false;
                    }
                    else {
                        GameBoard.blueMoveSelector.sSelected = false;
                    }
                    GameBoard.tileGrid.get(Integer.parseInt(String.valueOf(checkSS.charAt(1)))).get(Integer.parseInt(String.valueOf(checkSS.charAt(0)))).placeMove();
                }
            }
            else {
                // Place "S" to complete SOS
                if (GameModeSelector.gameLogic.playerOneTurn) {
                    GameBoard.redMoveSelector.sSelected = true;
                } else {
                    GameBoard.blueMoveSelector.sSelected = true;
                }
                GameBoard.tileGrid.get(Integer.parseInt(String.valueOf(checkSO.charAt(1)))).get(Integer.parseInt(String.valueOf(checkSO.charAt(0)))).placeMove();
            }
        }
    }

    private static String findLocation(String left, String middle, String right, Boolean oCheck) {
        for (Integer x = 0; x < Settings.sizeSelector.selector.getValue(); x++) {
            for (Integer y = 0; y < Settings.sizeSelector.selector.getValue(); y++) {
                if (StringUtils.equals(GameBoard.tileGrid.get(y).get(x).value.getText(), middle)) {
                    // horizontal check
                    if (checkLocation(x - 1, y, left) && checkLocation(x + 1, y, right)) {
                        return oCheck ? String.valueOf(x + 1) + String.valueOf(y) : String.valueOf(x) + String.valueOf(y);
                    }
                    if (checkLocation(x + 1, y, left) && checkLocation(x - 1, y, right)) {
                        return oCheck ? String.valueOf(x - 1) + String.valueOf(y) : String.valueOf(x) + String.valueOf(y);
                    }

                    // vertical check
                    if (checkLocation(x, y - 1, left) && checkLocation(x, y + 1, right)) {
                        return oCheck ? String.valueOf(x) + String.valueOf(y + 1) : String.valueOf(x) + String.valueOf(y);
                    }
                    if (checkLocation(x, y + 1, left) && checkLocation(x, y - 1, right)) {
                        return oCheck ? String.valueOf(x) + String.valueOf(y - 1) : String.valueOf(x) + String.valueOf(y);
                    }

                    // diagonal 1 check
                    if (checkLocation(x - 1, y - 1, left) && checkLocation(x + 1, y + 1, right)) {
                        return oCheck ? String.valueOf(x + 1) + String.valueOf(y + 1) : String.valueOf(x) + String.valueOf(y);
                    }
                    if (checkLocation(x + 1, y + 1, left) && checkLocation(x - 1, y - 1, right)) {
                        return oCheck ? String.valueOf(x - 1) + String.valueOf(y - 1) : String.valueOf(x) + String.valueOf(y);
                    }

                    // diagonal 2 check
                    if (checkLocation(x - 1, y + 1, left) && checkLocation(x + 1, y - 1, right)) {
                        return oCheck ? String.valueOf(x + 1) + String.valueOf(y - 1) : String.valueOf(x) + String.valueOf(y);
                    }
                    if (checkLocation(x + 1, y - 1, left) && checkLocation(x - 1, y + 1, right)) {
                        return oCheck ? String.valueOf(x - 1) + String.valueOf(y + 1) : String.valueOf(x) + String.valueOf(y);
                    }
                }
            }
        }
        return null;
    }

    private static Boolean checkLocation(int x, int y, String value) {
        try {
            if (StringUtils.equals(GameBoard.tileGrid.get(y).get(x).value.getText(), value)) {
                return true;
            }
        }
        catch (Exception e) {}

        return false;
    }
}
