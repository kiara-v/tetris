package cartoon;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

//This is the PaneOrganizer class.

public class PaneOrganizer {
    private BorderPane _root;

    /**
     * This is the PaneOrganizer's constructor.
     */

    public PaneOrganizer() {
        _root = new BorderPane();
        BackgroundFill fill = new BackgroundFill(Color.MIDNIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(fill);
        _root.setBackground(background);

        Pane alienPane = new Pane();
        _root.setTop(alienPane);
        Pane cowPane = new Pane();
        _root.setBottom(cowPane);

        Button btn = new Button("Sicko Mode");
        _root.setRight(btn);
        btn.setTranslateY(40);
        btn.setTranslateX(-20);

        Button quitButton = new Button("Quit!");
        quitButton.setOnAction(new QuitHandler());
        _root.setLeft(quitButton);
        quitButton.setTranslateY(40);
        quitButton.setTranslateX(20);

        Label label = new Label("Status: Alien Searching");
        label.setTextFill(Color.WHITE);
        label.setTranslateY(40);
        label.setTranslateX(20);
        _root.setCenter(label);

        new Cartoon(alienPane, cowPane, btn, label);
    }

    //The QuitHandler class exits the program when the quitButton is pressed.
    private class QuitHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Platform.exit();
            event.consume();
        }
    }

    //This method returns the root node.
    public BorderPane getRoot() {
        return _root;
    }

}


