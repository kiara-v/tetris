package tetris;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * This is the PaneOrganizer class.
 */

public class PaneOrganizer {
    private BorderPane _root;

    /**
     * This is the PaneOrganizer's constructor.
     * A new BorderPane is instantiated as the root used to set the scene.
     * A vanilla pane is made to place the board and pieces on, and added to the root.
     * The label to modify for a paused game and game over is also set up.
     * The quit button is created and added to the root.
     * Then a new Game is instantiated.
     */

    public PaneOrganizer() {
        _root = new BorderPane();
        BackgroundFill fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(fill);
        _root.setBackground(background);

        Pane boardPane = new Pane();
        _root.setCenter(boardPane);

        Button quitButton = new Button("Quit!");
        quitButton.setOnAction(new QuitHandler());
        _root.setBottom(quitButton);
        quitButton.setTranslateX(Constants.SCENE_WIDTH/2 - 10);

        Label label = new Label();
        _root.setTop(label);

        new Game(boardPane, label);
    }

    /**
     * This is the QuitHandler class.
     * When the quit button is pressed, the game exits.
     */

    private class QuitHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
            event.consume();
        }
    }

    // This method returns the root used to set the scene.

    public BorderPane getRoot() {
        return _root;
    }
}
