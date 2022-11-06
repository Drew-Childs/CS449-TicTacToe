package SOS;

import SOS.Scenes.Settings;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle("SOS");

        Settings settings = new Settings();

        primaryStage.setScene(settings.scene);
        primaryStage.show();
    }
}
