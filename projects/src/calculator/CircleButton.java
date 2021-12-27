package calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class CircleButton {
    private Button _btn;
    private Boolean _num;

    public CircleButton(GridPane pane, String text, int x, int y) {
        _btn = new Button(text);
        _btn.setShape(new Circle(Constants.RADIUS));
        _btn.setMinSize(2*Constants.RADIUS, 2*Constants.RADIUS);
        _btn.setMaxSize(2*Constants.RADIUS, 2*Constants.RADIUS);

        pane.add(_btn, x, y, 1, 1);
        _btn.setTranslateY(125);
        _num = false;
    }

    public void setOnAction(EventHandler<ActionEvent> e) {
        _btn.setOnAction(e);
    }

}
