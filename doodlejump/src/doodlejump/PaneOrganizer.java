package doodlejump;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class PaneOrganizer {
    private BorderPane _root;
    private Rectangle _ground;
    private Label _gameOver;
    private Label _score;

    /**
     * This is the PaneOrganizer's constructor.
     *
     * A new BorderPane is instantiated as the root used to set the scene.
     * A vanilla pain is made to place the doodle and platforms on, and added to the root.
     * The ground rectangle and game over label is also set up.
     * The quit button is created and added to the root.
     * Then a new Game is instantiated.
     */

    public PaneOrganizer() {
        _root = new BorderPane();
        BackgroundFill fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(fill);
        _root.setBackground(background);

        Pane gamePane = new Pane();
        _root.setCenter(gamePane);

        this.setupGround();

        Button quitButton = new Button("Quit!");
        quitButton.setOnAction(new QuitHandler());
        _root.setBottom(quitButton);
        quitButton.setTranslateX(doodlejump.Constants.APP_WIDTH/2 - 10);
        quitButton.setTranslateY(doodlejump.Constants.QUIT_Y);

        this.setupGameOver();

        new doodlejump.Game(gamePane, _ground, _gameOver);
    }

    /**
     * This method creates an empty label and adds it to the root.
     * This is so nothing shows up until the text is set after the doodle hits the ground.
     */

    private void setupGameOver() {
        _gameOver = new Label();
        _gameOver.setTextFill(Color.GREENYELLOW);
        _gameOver.setTranslateX(doodlejump.Constants.LABEL_X);
        _gameOver.setTranslateY(doodlejump.Constants.LABEL_Y);
        _gameOver.setScaleX(4.0);
        _gameOver.setScaleY(4.0);
        _root.setTop(_gameOver);
    }

    // This method creates the ground.

    private void setupGround() {
        _ground = new Rectangle(0, doodlejump.Constants.GROUND_Y, doodlejump.Constants.APP_WIDTH, doodlejump.Constants.GROUND_HEIGHT);
        _ground.setFill(Color.DARKMAGENTA);
        _root.getChildren().add(_ground);
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
