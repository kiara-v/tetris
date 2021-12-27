package doodlejump;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Doodle {
    private Rectangle _doodle;
    private Pane _gamePane;

    public Doodle(Pane gamePane) {
        _gamePane = gamePane;
        this.makeDoodle();
    }

    // This method makes the doodle and adds it to the game pane.

    public void makeDoodle() {
        _doodle = new Rectangle();
        _doodle.setWidth(doodlejump.Constants.DOODLE_WIDTH);
        _doodle.setHeight(doodlejump.Constants.DOODLE_HEIGHT);
        _doodle.setFill(Color.GREENYELLOW);

        _gamePane.getChildren().add(_doodle);
    }

    /**
     * This method returns the doodle made so that the actual doodle's methods can be called on in the Game class.
     * This comes in handy when testing if the doodle intersects with the ground or the platforms and adding an
     * event handler.
     */

    public Rectangle getDoodle() {
        return _doodle;
    }

    // This method helps the doodle get its current x-coordinate in the Game class.

    public double getXLoc() {
        return _doodle.getX();
    }

    // This method helps the doodle change its x-coordinate in the Game class.

    public void setXLoc(double x) {
        _doodle.setX(x);
    }

    // This method helps the doodle get its current y-coordinate in the Game class.

    public double getYLoc() {
        return _doodle.getY();
    }

    // This method help the doodle change its y-coordinate in the Game class.

    public void setYLoc(double y) {
        _doodle.setY(y);
    }
}
