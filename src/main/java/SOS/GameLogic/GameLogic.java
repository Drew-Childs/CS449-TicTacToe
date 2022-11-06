package SOS.GameLogic;

import SOS.Scenes.GameBoard;
import SOS.Scenes.Settings;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class GameLogic {
    public static Boolean simpleGameMode;
    static Map<String, Boolean> scoredSOS;

    public static Boolean playerOneTurn;
    public static Boolean playerOneWin;
    public static Boolean draw;

    public GameLogic() {
        simpleGameMode = true;
        scoredSOS = new HashMap<>();

        playerOneTurn = true;
        draw = false;
    }

    // TODO: implement grade move logic
    public Boolean isGameOver() {
        if (simpleGameMode) {
            return checkSimpleGame();
        }
        else {
            return checkStandardGame();
        }
    }

    // TODO: implement simple game logic
    private Boolean checkSimpleGame() {
        searchBoard();

        if (!scoredSOS.isEmpty()) {
            playerOneWin = playerOneTurn;
            return true;
        }
        else if (checkBoardFull()) {
            draw = true;
            return true;
        }

        return false;
    }

    // TODO: implement standard game logic
    private Boolean checkStandardGame() {
        searchBoard();

        if (checkBoardFull()) {
            Integer playerOneStrikeThrough = 0;
            Integer playerTwoStrikeThrough = 0;

            for (Map.Entry<String, Boolean> strikeThrough : scoredSOS.entrySet()) {
                if (strikeThrough.getValue()) {
                    playerOneStrikeThrough += 1;
                }
                else {
                    playerTwoStrikeThrough += 1;
                }
            }

            if (playerOneStrikeThrough == playerTwoStrikeThrough) {
                draw = true;
            }
            else {
                playerOneWin = playerOneStrikeThrough > playerTwoStrikeThrough;
            }
            return true;
        }

        return false;
    }

    // TODO: implement line drawing logic
    private void searchBoard() {
        for (Integer x = 0; x < Settings.sizeSelector.selector.getValue(); x++) {
            for (Integer y = 0; y < Settings.sizeSelector.selector.getValue(); y++) {
                if (StringUtils.equals(GameBoard.tileGrid.get(y).get(x).value.getText(), "O")) {
                    // horizontal check
                    try {
                        if (StringUtils.equals(GameBoard.tileGrid.get(y).get(x - 1).value.getText(), "S") && StringUtils.equals(GameBoard.tileGrid.get(y).get(x + 1).value.getText(), "S")) {
                            if (!scoredSOS.containsKey(y.toString() + String.valueOf(x - 1) + y.toString() + x.toString() + y.toString() + String.valueOf(x + 1))) {
                                scoredSOS.put(y.toString() + String.valueOf(x - 1) + y.toString() + x.toString() + y.toString() + String.valueOf(x + 1), playerOneTurn);

                                GameBoard.tileGrid.get(y).get(x - 1).horizontalLineVisible();
                                GameBoard.tileGrid.get(y).get(x).horizontalLineVisible();
                                GameBoard.tileGrid.get(y).get(x + 1).horizontalLineVisible();
                            }
                        }
                    }
                    catch (Exception e) {}

                    // vertical check
                    try {
                        if (StringUtils.equals(GameBoard.tileGrid.get(y - 1).get(x).value.getText(), "S") && StringUtils.equals(GameBoard.tileGrid.get(y + 1).get(x).value.getText(), "S")) {
                            if (!scoredSOS.containsKey(String.valueOf(y - 1) + x.toString() + y.toString() + x.toString() + String.valueOf(y + 1) + x.toString())) {
                                scoredSOS.put(String.valueOf(y - 1) + x.toString() + y.toString() + x.toString() + String.valueOf(y + 1) + x.toString(), playerOneTurn);

                                GameBoard.tileGrid.get(y - 1).get(x).verticalLineVisible();
                                GameBoard.tileGrid.get(y).get(x).verticalLineVisible();
                                GameBoard.tileGrid.get(y + 1).get(x).verticalLineVisible();
                            }
                        }
                    }
                    catch (Exception e) {}

                    // diagonal 1 check
                    try {
                        if (StringUtils.equals(GameBoard.tileGrid.get(y - 1).get(x - 1).value.getText(), "S") && StringUtils.equals(GameBoard.tileGrid.get(y + 1).get(x + 1).value.getText(), "S")) {
                            if (!scoredSOS.containsKey(String.valueOf(y - 1) + String.valueOf(x - 1) + y.toString() + x.toString() + String.valueOf(y + 1) + String.valueOf(x + 1))) {
                                scoredSOS.put(String.valueOf(y - 1) + String.valueOf(x - 1) + y.toString() + x.toString() + String.valueOf(y + 1) + String.valueOf(x + 1), playerOneTurn);

                                GameBoard.tileGrid.get(y - 1).get(x - 1).diagonalLineOneVisible();
                                GameBoard.tileGrid.get(y).get(x).diagonalLineOneVisible();
                                GameBoard.tileGrid.get(y + 1).get(x + 1).diagonalLineOneVisible();
                            }
                        }
                    }
                    catch (Exception e) {}

                    // diagonal 2 check
                    try {
                        if (StringUtils.equals(GameBoard.tileGrid.get(y - 1).get(x + 1).value.getText(), "S") && StringUtils.equals(GameBoard.tileGrid.get(y + 1).get(x - 1).value.getText(), "S")) {
                            if (!scoredSOS.containsKey(String.valueOf(y - 1) + String.valueOf(x + 1) + y.toString() + x.toString() + String.valueOf(y + 1) + String.valueOf(x - 1))) {
                                scoredSOS.put(String.valueOf(y - 1) + String.valueOf(x + 1) + y.toString() + x.toString() + String.valueOf(y + 1) + String.valueOf(x - 1), playerOneTurn);

                                GameBoard.tileGrid.get(y - 1).get(x + 1).diagonalLineTwoVisible();
                                GameBoard.tileGrid.get(y).get(x).diagonalLineTwoVisible();
                                GameBoard.tileGrid.get(y + 1).get(x - 1).diagonalLineTwoVisible();
                            }
                        }
                    }
                    catch (Exception e) {}
                }

                System.out.println("beans");
            }
        }
    }

    private Boolean checkBoardFull() {
        for (int x = 0; x < Settings.sizeSelector.selector.getValue(); x++) {
            for (int y = 0; y < Settings.sizeSelector.selector.getValue(); y++) {
                if (StringUtils.equals(GameBoard.tileGrid.get(y).get(x).value.getText(), null)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void switchTurn() {
        playerOneTurn = !playerOneTurn;
    }
}
