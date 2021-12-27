package cartoon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Here's cartoon! Your first JavaFX assignment!
 * Before you start coding your cartoon, take a look at
 * the lecture slides and JavaFX Guide for all the
 * information you'll need (and more!).
 *
 * Please put your overall comments for the project here.
 *
 */

public class App extends Application {

    /**
     * This method starts the program.
     *
     * A new PaneOrganizer is instantiated.
     */

    @Override
    public void start(Stage stage) {
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(),Constants.APP_DIM_X,Constants.APP_DIM_Y);
        stage.setScene(scene);
        stage.setTitle("MOOO! by Doja Cat");
        stage.show();
    }

    /*
     * Here is the mainline! No need to change this.
     */
    public static void main(String[] argv) {
        // launch is a method inherited from Application
        launch(argv);
    }
}
