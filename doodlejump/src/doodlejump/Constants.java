package doodlejump;

public class Constants {

    public static final int GRAVITY = 1000; // acceleration constant (UNITS: pixels/s^2)
    public static final int REBOUND_VELOCITY = -650; // initial jump velocity (UNITS: pixels/s)
    public static final double DURATION = 0.016; // KeyFrame duration (UNITS: s)

    public static final int PLATFORM_WIDTH = 40; // (UNITS: pixels)
    public static final int PLATFORM_HEIGHT = 10; // (UNITS: pixels)
    public static final int DOODLE_WIDTH = 20; // (UNITS: pixels)
    public static final int DOODLE_HEIGHT = 40; // (UNITS: pixels)

    // Sets the app's width and height.

    public static final int APP_WIDTH = 500;
    public static final int APP_HEIGHT = 800;

    // Sets the doodle's initial x-coordinate.

    public static final int DOODLE_X = 250;

    // Sets how far the doodle can move left or right when pressing keys.

    public static final int DOODLE_MOVE = 20;

    // Sets the ground's height and y-coordinate.

    public static final double GROUND_HEIGHT = 200;
    public static final double GROUND_Y = 650;

    // Sets the range for how far each platform can be from the last platform.

    public static final int X_OFFSET = 150;
    public static final int Y_OFFSET_MIN = 125;
    public static final int Y_OFFSET_MAX = 175;

    // Sets the initial location of the first platform.

    public static final int PLATFORM_X = 250;
    public static final int PLATFORM_Y = 500;

    // Sets the location of the label and quit button.

    public static final int LABEL_X = 220;
    public static final int LABEL_Y = 200;
    public static final int QUIT_Y = -75;

    // Sets the midpoint of the game.

    public static final double SCENE_HALF = APP_HEIGHT/2 - GROUND_HEIGHT;
}
