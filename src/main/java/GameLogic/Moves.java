package GameLogic;

public class Moves {
    public Boolean playerOneTurn;

    public Moves() {
        playerOneTurn = true;
    }

    public void switchTurn() {
        playerOneTurn = !playerOneTurn;
    }
}
