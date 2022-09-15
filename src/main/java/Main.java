import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    CheckBox checkBox;
    Line line;
    Text text;
    RadioButton radioButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello this is title of my window");

        checkBox = new CheckBox();
        checkBox.setText("Click me!");

        text = new Text();
        text.setText("Hello world!");

        radioButton = new RadioButton();
        radioButton.setText("Click me!");

        line = new Line();
        line.setStartX(20);
        line.setEndX(120);
        line.setStartY(20);
        line.setEndY(20);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(checkBox, line, text, radioButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
