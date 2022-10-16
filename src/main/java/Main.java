import Scenes.GameBoard;
import Scenes.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Settings settings;
    GameBoard gameBoard;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SOS");

        settings = new Settings();
        gameBoard = new GameBoard();

        settings.confirm.setOnAction(e -> primaryStage.setScene(gameBoard.scene));
        gameBoard.confirm.setOnAction(e -> primaryStage.setScene(settings.scene));

        primaryStage.setScene(settings.scene);
        primaryStage.show();
    }
}
