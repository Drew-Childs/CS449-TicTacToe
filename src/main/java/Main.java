import Scenes.GameBoard;
import Scenes.Settings;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    Settings settings;
    GameBoard gameBoard;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SOS");

        settings = new Settings();

        settings.confirm.setOnAction(e -> {
            gameBoard = new GameBoard();
            primaryStage.setScene(gameBoard.scene);
        });

        primaryStage.setScene(settings.scene);
        primaryStage.show();
    }
}
