package tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This is the Square class.
 */

public class Square {
    private Rectangle _square;

    /**
     * This is the Square's constructor.
     * It instantiates a new Rectangle.
     */

    public Square() {
        _square = new Rectangle(Constants.SQUARE_WIDTH, Constants.SQUARE_WIDTH);

    }

    // This method helps set the square's x-location in other classes.

    public void setXLoc(double x) {
        _square.setX(x);
    }

    // This method helps set the square's y-location in other classes.

    public void setYLoc(double y) {
        _square.setY(y);
    }

    // This method helps set the square's x-location in other classes.

    public double getXLoc() {
        return _square.getX();
    }

    // This method helps set the square's y-location in other classes.

    public double getYLoc() {
        return _square.getY();
    }

    // This method helps set the square's color in other classes.

    public void setColor(Color color) {
        _square.setFill(color);
    }

    // This method returns the square made.

    public Rectangle getSquare() {
        return _square;
    }
}
