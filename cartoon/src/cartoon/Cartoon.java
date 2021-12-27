package cartoon;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

//This is the Cartoon class.

public class Cartoon {
    private Cow _cow;
    private Pane _cowPane;
    private Alien _alien;
    private Label _label;
    private String _update;
    private static int _points = 0;

    /**
     * This is the Cartoon's constructor.
     *
     * It instantiates a new Alien and Cow. Then it sets up the timeline.
     */

    public Cartoon(Pane alienPane, Pane cowPane, Button btn, Label label) {
        _cowPane = cowPane;
        _alien = new Alien(alienPane, btn);
        _cow = new Cow(cowPane);
        _label = label;

        this.setupTimeline();
    }

    //This method creates an animation by instantiating a new Location Handler for each keyframe.
    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(0.003), new LocationHandler());

        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * This is the LocationHandler class, moves the composite Alien shape to the right.
     *
     * Once the Alien shape moves past 750, it repositions to the left then continues moving right.
     * The label also changes its text, depending on the String returned from the updateLabel method.
     */
    private class LocationHandler implements EventHandler<ActionEvent> {
        private double _distance;
        @Override
        public void handle(ActionEvent event) {
            _distance = Constants.DISTANCE_Y;
            _alien.setXLoc(_alien.getXLoc() + _distance);
            _label.setText(updateLabel());

            if (_alien.getXLoc() <= _cow.getXLoc()+50 && _alien.getXLoc() >= _cow.getXLoc()-50) {
                _cowPane.setTranslateY(-250);
                _cowPane.setRotate(_cowPane.getRotate() + 10);
            } else {
                _cowPane.setTranslateY(0);
                _cowPane.setRotate(0);
            }

            if (_alien.getXLoc() > 750) {
                _alien.setXLoc(-225);
            } else {}
            event.consume();
        }
    }

    /**
     * This method returns a string based on if the Alien shape is above the Cow shape or not.
     *
     * When they are aligned, the cow shrinks and loses opacity and adds a count to how many times the
     * cow was caught.
     * @return
     */
    public String updateLabel() {
        if (_alien.getXLoc() == _cow.getXLoc()) {
            _points++;
        }

        if (_alien.getXLoc() <= _cow.getXLoc()+50 && _alien.getXLoc() >= _cow.getXLoc()-50) {
            _cowPane.setScaleX(0.3);
            _cowPane.setScaleY(0.3);
            _cowPane.setTranslateY(-100);
            _cowPane.setOpacity(0.75);
            _update = "Status: Caught by Alien " + _points +"x";
        } else {
            _update = "Status: Escaped Alien (Caught " + _points + "x)";
            _cowPane.setScaleX(1.0);
            _cowPane.setScaleY(1.0);
            _cowPane.setTranslateY(0);
            _cowPane.setOpacity(1);
        }

        return _update;
    }
}


