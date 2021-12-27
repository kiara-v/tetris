package doodlejump;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.ArrayList;

public class Game {
    private doodlejump.Doodle _doodle;
    private Pane _gamePane;
    private Platform _bottomPlatform;
    private Platform _newPlatform;
    private Rectangle _ground;
    private double _velocity;
    private Label _gameOver;
    private Timeline _timeline;
    private ArrayList<Platform> _listOfPlatforms;
    private double _midpointDifference;
    private int _points;

    /**
     * This is the Game's constructor.
     * It takes in parameters so that the game knows about the game pane, ground, and label.
     * @param gamePane
     * @param ground
     * @param gameOver
     *
     * A new doodle is instantiated and takes in the game pane as a parameter.
     * The doodle adds an event handler.
     *
     * A new platform is instantiated and placed below the doodle.
     * An arraylist is instantiated of type Platform and the new platform is added.
     * It calls on the method to generate platforms.
     * The timeline is setup.
     */

    public Game(Pane gamePane, Rectangle ground, Label gameOver) {
        _gamePane = gamePane;
        _ground = ground;
        _gameOver = gameOver;
        _points = 0;

        _doodle = new doodlejump.Doodle(_gamePane);
        _doodle.setXLoc(doodlejump.Constants.DOODLE_X);
        _doodle.setYLoc(doodlejump.Constants.SCENE_HALF);

        _doodle.getDoodle().addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
        _doodle.getDoodle().setFocusTraversable(true);

        _bottomPlatform = new Platform(_gamePane);
        _bottomPlatform.setXLoc(doodlejump.Constants.PLATFORM_X);
        _bottomPlatform.setYLoc(doodlejump.Constants.PLATFORM_Y);

        _listOfPlatforms = new ArrayList<Platform>();
        _listOfPlatforms.add(_bottomPlatform);

        this.setupTimeline();


    }

    /**
     * This is the KeyHandler class.
     *
     * There's a switch statement, which changes the distance.
     * If the left key is pressed, the distance turns negative so the doodle moves left on the screen.
     * If the right key is pressed, the doodle moves right on the screen.
     *
     * If the doodle moves past the left and right border of the app,
     * the doodle moves back into the screen from the other side.
     *
     * If the doodle hits the ground, the KeyHandler stops.
     */

    private class KeyHandler implements EventHandler<KeyEvent> {
        private int _distance;

        @Override
        public void handle(KeyEvent e) {
            _distance = doodlejump.Constants.DOODLE_MOVE;

            KeyCode keyPressed = e.getCode();
            switch (keyPressed) {
                case LEFT:
                    _distance = _distance*-1;
                    break;
                case RIGHT:
                    break;
            }
            _doodle.setXLoc(_doodle.getDoodle().getX() + _distance);

            if (_doodle.getXLoc() >= doodlejump.Constants.APP_WIDTH) {
                _doodle.setXLoc(0);
            } else if (_doodle.getXLoc() <= -doodlejump.Constants.DOODLE_WIDTH) {
                _doodle.setXLoc(doodlejump.Constants.APP_WIDTH- doodlejump.Constants.DOODLE_WIDTH);
            }

            if (_doodle.getDoodle().intersects(_ground.getLayoutBounds())) {
                _doodle.getDoodle().removeEventHandler(KeyEvent.KEY_PRESSED, this);
            }
            e.consume();
        }
    }

    // This method sets up the timeline by instantiating a new TimeHandler each keyframe, creating the animation.

    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(doodlejump.Constants.DURATION), new TimeHandler());
        _timeline = new Timeline(kf);
        _timeline.setCycleCount(Animation.INDEFINITE);
        _timeline.play();
    }

    /**
     * This is the TimeHandler class,
     *
     * This calls on the doodle to bounce and scroll platforms as the doodle moves up.
     * If the doodle hits the ground, the label's text is set to "GAME OVER!,"
     * the doodle moves out of the screen, and the timeline stops.
     *
     * Platforms are continuously generated.
     */

    private class TimeHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            bounce();
            scrollPlatforms();

            if (_doodle.getDoodle().intersects(_ground.getLayoutBounds())) {
                _gamePane.setOpacity(0.2);
                _gameOver.setText("GAME OVER!");
                _doodle.setYLoc(1000);
                _timeline.stop();
            }

            generatePlatforms();

            removePlatform(_listOfPlatforms.size());
            event.consume();
        }


        /**
         * This method moves the doodle up and down based on physics. I don't know anything about physics.
         *
         * The velocity is set so that the doodle looks like it's falling according to gravity, but
         * if the doodle is falling and it intersects any of the platforms, the doodle bounces up.
         */

        private void bounce() {
            _velocity = _velocity + doodlejump.Constants.GRAVITY * doodlejump.Constants.DURATION;
            for (Platform platform: _listOfPlatforms) {
                if (_doodle.getDoodle().intersects(platform.getPlatform().getLayoutBounds()) && _velocity >= 0) {
                    _velocity = doodlejump.Constants.REBOUND_VELOCITY;
                    break;
                }
            }
            _doodle.setYLoc(_doodle.getYLoc() + _velocity * doodlejump.Constants.DURATION);
        }

        // This method moves the doodle y-coordinate to the center of the game and moves the platforms down.

        private void scrollPlatforms() {
            if (_doodle.getYLoc() <= doodlejump.Constants.SCENE_HALF && _velocity < 0) {
                _midpointDifference = doodlejump.Constants.SCENE_HALF - _doodle.getYLoc();
                for (Platform platform: _listOfPlatforms) {
                    platform.setYLoc(platform.getYLoc() + _midpointDifference);
                }
                _doodle.setYLoc(doodlejump.Constants.SCENE_HALF);
            }
        }

        // This method removes platforms from the arraylist and the game pane if they go past the bottom of the screen.

        private void removePlatform(int numPlatforms) {
            for (int i = 0; i < numPlatforms; i++) {
                if (_listOfPlatforms.get(0).getYLoc() >= doodlejump.Constants.APP_HEIGHT) {
                    _listOfPlatforms.remove(0);
                    _gamePane.getChildren().remove(_listOfPlatforms.get(0).getPlatform());
                }
            }
        }
    }

    /**
     * This method generates semi-randomized platforms.
     *
     * While the last platform of the arraylist is below the top of the screen,
     * a random x-coordinate and y-coordinate is generated based on the last platform's location
     * and a new platform is instantiated set at those coordinates. The new platform is then added
     * to the arraylist and becomes the last platform.
     */

    private void generatePlatforms() {

        double lastPlatform = _listOfPlatforms.get(_listOfPlatforms.size()-1).getYLoc();

        while (lastPlatform >= 0) {
            double lowX = Math.max(0, _bottomPlatform.getXLoc() - doodlejump.Constants.X_OFFSET);
            double highX = Math.min(doodlejump.Constants.APP_WIDTH - doodlejump.Constants.PLATFORM_WIDTH, _bottomPlatform.getXLoc() + doodlejump.Constants.X_OFFSET);
            double x = Math.random() * (highX - lowX) + lowX;

            double lowY = _bottomPlatform.getYLoc() - doodlejump.Constants.Y_OFFSET_MIN;
            double highY = _bottomPlatform.getYLoc() - doodlejump.Constants.Y_OFFSET_MAX;
            double y = Math.random() * (highY - lowY) +lowY;

            _newPlatform = new Platform(_gamePane);
            _newPlatform.setXLoc(x);
            _newPlatform.setYLoc(y);
            _listOfPlatforms.add(_newPlatform);

            _bottomPlatform = _newPlatform;
            lastPlatform = _listOfPlatforms.get(_listOfPlatforms.size()-1).getYLoc();
        }
    }

}