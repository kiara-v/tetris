package cartoon;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

//This is the Alien class.

public class Alien {
    private Pane _alienPane;
    private Ellipse _ufoBase;
    private Circle _ufoTop;
    private Circle _ufoLight;
    private Ellipse _head;
    private Ellipse _leftEye;
    private Ellipse _rightEye;
    private Polygon _beam;
    private Circle _light1;
    private Circle _light2;
    private Circle _light3;
    private Button _btn;
    private Timeline _colorTimeline;

    /**
     * This is the Alien's constructor.
     *
     * It calls on methods within the class to create parts of the Alien into a composite shape.
     * It also animates the beam to change colors when the button is pressed.
     */

    public Alien(Pane pane, Button btn) {
        _btn = btn;
        _alienPane = pane;
        this.makeBeam();
        this.makeUfoTop();
        this.makeAlienFace();
        this.makeUfoBase();

        KeyFrame frame = new KeyFrame(Duration.seconds(0.2), new ClickHandler());
        _colorTimeline = new Timeline(frame);
        _colorTimeline.setCycleCount(Animation.INDEFINITE);

        _btn.setOnAction(new ColorHandler());
        _light1 = this.makeUfoLight(Constants.UFO_LIGHT1_POS);
        _light2 = this.makeUfoLight(0);
        _light3 = this.makeUfoLight(Constants.UFO_LIGHT3_POS);
        _alienPane.getChildren().addAll(_light1, _light2, _light3);
        _btn.setFocusTraversable(false);
    }

    //The ClickHandler class randomly changes the beam's color.
    public class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            int red = (int) (Math.random()*256);
            int green = (int) (Math.random()*256);
            int blue  = (int) (Math.random()*256);
            Color customColor = Color.rgb(red,green,blue);
            _beam.setFill(customColor);
        }
    }

    //The ColorHandler class sets up a timeline to animate the beam changing different colors rapidly.
    public class ColorHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            if (_colorTimeline.getStatus() == Animation.Status.RUNNING) {
                _colorTimeline.pause();
                _beam.setFill(Color.YELLOW);
            } else {
                _colorTimeline.play();
                event.consume();
            }

        }
    }

    //This method creates the UFO base and adds it to the alienPane.
    public void makeUfoBase() {
        _ufoBase = new Ellipse(Constants.UFO_BASE_POS_X, Constants.UFO_BASE_POS_Y, Constants.UFO_BASE_RAD_X, Constants.UFO_BASE_RAD_Y);
        _ufoBase.setFill(Color.GREEN);
        _ufoBase.setStroke(Color.BLACK);
        _ufoBase.setStrokeWidth(Constants.STROKE_WIDTH);
        _alienPane.getChildren().add(_ufoBase);
    }

    //This method creates the UFO top and adds it to the alienPane.
    public void makeUfoTop() {
        _ufoTop = new Circle(Constants.UFO_TOP_POS_X, Constants.UFO_TOP_POS_Y, Constants.UFO_TOP_RAD, Color.WHITE);
        _ufoTop.setStroke(Color.BLACK);
        _ufoTop.setStrokeWidth(Constants.STROKE_WIDTH);
        _alienPane.getChildren().add(_ufoTop);
    }

    //This method returns a UFO light.
    public Circle makeUfoLight(int x) {
        _ufoLight = new Circle(Constants.UFO_BASE_POS_X + x, Constants.UFO_BASE_POS_Y, Constants.UFO_LIGHT_RAD, Color.YELLOW);
        _ufoLight.setStroke(Color.BLACK);
        _ufoLight.setStrokeWidth(Constants.STROKE_WIDTH);
        return _ufoLight;
    }

    //This method creates an alien face and adds it to the alienPane.
    public void makeAlienFace() {
        _head = new Ellipse(Constants.ALIEN_FACE_POS_X, Constants.ALIEN_FACE_POS_Y, Constants.ALIEN_FACE_RAD_X, Constants.ALIEN_FACE_RAD_Y);
        _head.setFill(Color.GREENYELLOW);
        _head.setStroke(Color.BLACK);
        _head.setStrokeWidth(Constants.STROKE_WIDTH);

        _leftEye = new Ellipse(Constants.ALIEN_LEFT_EYE_POS_X, Constants.ALIEN_EYE_POS_Y, Constants.ALIEN_EYE_RAD_X, Constants.ALIEN_EYE_RAD_Y);
        _leftEye.setFill(Color.BLACK);

        _rightEye = new Ellipse(Constants.ALIEN_RIGHT_EYE_POS_X, Constants.ALIEN_EYE_POS_Y, Constants.ALIEN_EYE_RAD_X, Constants.ALIEN_EYE_RAD_Y);
        _rightEye.setFill(Color.BLACK);

        _alienPane.getChildren().addAll(_head, _leftEye, _rightEye);
    }

    //This method creates a beam and adds it to the alienPane.
    public void makeBeam() {
        _beam = new Polygon();
        _beam.getPoints().addAll(new Double[]{Constants.BEAM_PT1_POS_X, Constants.BEAM_PT1_POS_Y, Constants.BEAM_PT2_POS_X, Constants.BEAM_PT2_POS_Y, Constants.BEAM_PT3_POS_X, Constants.BEAM_PT3_POS_Y});
        _beam.setFill(Color.YELLOW);
        _alienPane.getChildren().add(_beam);
    }

    //This method sets each shape that comprises the composite alien shape to a distance horizontally.
    public void setXLoc(double x) {
        _ufoBase.setCenterX(x);
        _ufoTop.setCenterX(x);
        _light1.setCenterX(x);
        _light2.setCenterX(x-50);
        _light3.setCenterX(x+50);
        _head.setCenterX(x);
        _leftEye.setCenterX(x-7);
        _rightEye.setCenterX(x+7);
        _beam.setTranslateX(x-250);
    }

    //This method returns the location of the x position of the center of the UFO base.
    public double getXLoc() {
        return _ufoBase.getCenterX();
    }
}


