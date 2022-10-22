package GameLogic;

public class GameMode {
    public Moves currentTurn;
    public Boolean simpleGameMode;

    public GameMode() {
        currentTurn = new Moves();
        simpleGameMode = true;
    }
}
