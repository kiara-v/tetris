package doodlejump;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Platform {
    private Rectangle _platform;
    private Pane _gamePane;

    /**
     * This is the Platform's constructor, which creates a platform.
     * It takes in the game pane as a parameter so that it can add the platforms to the pane.
     * @param gamePane
     */

    public Platform(Pane gamePane) {
        _gamePane = gamePane;

        _platform = new Rectangle();
        _platform.setWidth(doodlejump.Constants.PLATFORM_WIDTH);
        _platform.setHeight(doodlejump.Constants.PLATFORM_HEIGHT);
        _platform.setFill(Color.DARKTURQUOISE);

        _gamePane.getChildren().add(_platform);
    }

    /**
     * This method returns the platform made so that the actual platform's methods can be called on in the Game class.
     * This helps when testing if the doodle intersects the platforms.
     * @return
     */

    public Rectangle getPlatform() {
        return _platform;
    }

    // This method helps the platform get its current x-coordinate in the Game class.

    public double getXLoc() {
        return _platform.getX();
    }

    // This method helps the platform change its x-coordinate in the Game class.

    public void setXLoc(double x) {
        _platform.setX(x);
    }

    // This method helps the platform get its current y-coordinate in the Game class.

    public double getYLoc() {
        return _platform.getY();
    }

    // This method helps the platform change its y-coordinate in the Game class.

    public void setYLoc(double y) {
        _platform.setY(y);
    }
}
