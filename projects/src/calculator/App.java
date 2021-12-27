package calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Instantiate top-level object, set up the scene, and show the stage here.
        Calculator calc = new Calculator();
        Scene scene = new Scene(calc.getRoot(), Constants.APP_WIDTH, Constants.APP_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();

    }

    public static void main(String[] argv) {
        // launch is a static method inherited from Application.
        launch(argv);
    }
}
