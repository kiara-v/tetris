package cartoon;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

//This is the Cow class.

public class Cow {
    private Pane _cowPane;
    private Circle _body;
    private Double _location;

    /**
     * This is the Cow's constructor.
     *
     * It calls on methods within the class to create parts of the Cow into a composite shape.
     */

    public Cow(Pane pane) {
        _cowPane = pane;
        this.makeCowHorns();
        this.makeCowEars();
        this.makeCowHead();
        this.makeCowEyes();
        this.makeCowNose();
        this.makeCowBody();
        this.makeHooves();

        Circle spot1 = this.makeSpots(-51, 3, 1);
        Circle spot2 = this.makeSpots(-53, 16, -2);

        Circle spot3 = this.makeSpots(0, 50, 4);
        Circle spot4 = this.makeSpots(-12, 53, -1);
        Circle spot5 = this.makeSpots(14, 52, 0);

        Circle spot6 = this.makeSpots(-17, -35, -2);
        Circle spot7 = this.makeSpots(29, -27, -4);
        Circle spot8 = this.makeSpots(26, -18, -2);

        Circle spot9 = this.makeSpots(0, -144, 0);
        Circle spot10 = this.makeSpots(-10, -146, -3);
        Circle spot11 = this.makeSpots(11, -143, -2);

        Circle spot12 = this.makeSpots(37, -120, -3);
        Circle spot13 = this.makeSpots(41, -112, -5);

        _cowPane.getChildren().addAll(spot1, spot2, spot3, spot4, spot5, spot6, spot7, spot8, spot9, spot10, spot11, spot12, spot13);

        _cowPane.addEventHandler(KeyEvent.KEY_PRESSED, new PressHandler());
        _cowPane.setFocusTraversable(true);
        _location = 300.0;
    }

    /**
     * The PressHandler class moves the composite cow shape horizontally based on what key is pressed.
     *
     * Pressing the L key will move the cow left.
     * Pressing the R key will move the cow right.
     * Pressing the C key will return the cow to the center.
     * Pressing the Q key will exit the program.
     */

    private class PressHandler implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            KeyCode keyPressed = event.getCode();

            switch (keyPressed) {
                case LEFT:
                    _cowPane.setTranslateX(-150);
                    _location = 150.0;
                    break;
                case RIGHT:
                    _cowPane.setTranslateX(150);
                    _location = 450.0;
                    break;
                case UP:
                    _cowPane.setTranslateX(0);
                    _location = 300.0;
                    break;
                case ESCAPE:
                    Platform.exit();
                    break;
            }
            event.consume();
        }
    }

    //This method returns the current x position of the center of the cow.
    public double getXLoc() {
        return _location;
    }

    //This method creates the cow head and adds it to the cowPane.
    public void makeCowHead() {
        Circle head = new Circle(Constants.COW_HEAD_POS_X, Constants.COW_HEAD_POS_Y, Constants.COW_HEAD_RAD);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);
        head.setStrokeWidth(Constants.STROKE_WIDTH);
        _cowPane.getChildren().add(head);
    }

    //This method creates the cow eyes and adds it to the cowPane.
    public void makeCowEyes() {
        Ellipse eye1 = new Ellipse(Constants.COW_EYE1_POS_X, Constants.COW_EYE_POS_Y, Constants.COW_EYE_RAD_X, Constants.COW_EYE_RAD_Y);
        eye1.setFill(Color.BLACK);
        Ellipse eye2 = new Ellipse(Constants.COW_EYE2_POS_X, Constants.COW_EYE_POS_Y, Constants.COW_EYE_RAD_X, Constants.COW_EYE_RAD_Y);
        eye2.setFill(Color.BLACK);
        _cowPane.getChildren().addAll(eye1, eye2);
    }

    //This method creates the cow nose and adds it to the cowPane.
    public void makeCowNose() {
        Ellipse nose = new Ellipse(Constants.COW_NOSE_POS_X, Constants.COW_NOSE_POS_Y, Constants.COW_NOSE_RAD_X, Constants.COW_NOSE_RAD_Y);
        nose.setFill(Color.WHITE);
        nose.setStroke(Color.BLACK);
        nose.setStrokeWidth(Constants.STROKE_WIDTH);

        Ellipse nostril1 = new Ellipse(Constants.COW_NOSTRIL1_POS_X, Constants.COW_NOSTRIL_POS_Y, Constants.COW_NOSTRIL_RAD_X, Constants.COW_NOSTRIL_RAD_Y);
        nostril1.setFill(Color.WHITE);
        nostril1.setStroke(Color.BLACK);
        nostril1.setStrokeWidth(Constants.STROKE_WIDTH - 0.5);

        Ellipse nostril2 = new Ellipse(Constants.COW_NOSTRIL2_POS_X, Constants.COW_NOSTRIL_POS_Y, Constants.COW_NOSTRIL_RAD_X, Constants.COW_NOSTRIL_RAD_Y);
        nostril2.setFill(Color.WHITE);
        nostril2.setStroke(Color.BLACK);
        nostril2.setStrokeWidth(Constants.STROKE_WIDTH - 0.5);

        _cowPane.getChildren().addAll(nose, nostril1, nostril2);
    }

    //This method creates the cow body and adds it to the cowPane.
    public void makeCowBody() {
        _body = new Circle(Constants.COW_BODY_POS_X, Constants.COW_BODY_POS_Y, Constants.COW_BODY_RAD);
        _body.setFill(Color.WHITE);
        _body.setStroke(Color.BLACK);
        _body.setStrokeWidth(Constants.STROKE_WIDTH);

        Ellipse leftArm = new Ellipse(Constants.COW_LEFT_ARM_POS_X, Constants.COW_ARM_POS_Y, Constants.COW_ARM_RAD_X, Constants.COW_ARM_RAD_Y);
        leftArm.setFill(Color.WHITE);
        leftArm.setStroke(Color.BLACK);
        leftArm.setStrokeWidth(Constants.STROKE_WIDTH);

        Ellipse rightArm = new Ellipse(Constants.COW_RIGHT_ARM_POS_X, Constants.COW_ARM_POS_Y, Constants.COW_ARM_RAD_X, Constants.COW_ARM_RAD_Y);
        rightArm.setFill(Color.WHITE);
        rightArm.setStroke(Color.BLACK);
        rightArm.setStrokeWidth(Constants.STROKE_WIDTH);

        Rectangle leg = new Rectangle(Constants.COW_LEG_POS_X, Constants.COW_LEG_POS_Y, Constants.COW_LEG_WIDTH, Constants.COW_LEG_HEIGHT);
        leg.setFill(Color.WHITE);
        leg.setStroke(Color.BLACK);
        leg.setStrokeWidth(Constants.STROKE_WIDTH);

        _cowPane.getChildren().addAll(leg, _body, leftArm, rightArm);

    }

    //This method creates the cow ears and adds it to the cowPane.
    public void makeCowEars() {
        Ellipse leftEar = new Ellipse(Constants.COW_LEFT_EAR_POS_X, Constants.COW_EAR_POS_Y, Constants.COW_EAR_RAD_X, Constants.COW_EAR_RAD_Y);
        leftEar.setFill(Color.WHITE);
        leftEar.setStroke(Color.BLACK);
        leftEar.setStrokeWidth(Constants.STROKE_WIDTH);

        Ellipse rightEar = new Ellipse(Constants.COW_RIGHT_EAR_POS_X, Constants.COW_EAR_POS_Y, Constants.COW_EAR_RAD_X, Constants.COW_EAR_RAD_Y);
        rightEar.setFill(Color.WHITE);
        rightEar.setStroke(Color.BLACK);
        rightEar.setStrokeWidth(Constants.STROKE_WIDTH);

        _cowPane.getChildren().addAll(leftEar, rightEar);
    }

    //This method creates the cow horns and adds it to the cowPane.
    public void makeCowHorns() {
        Polygon leftHorn = new Polygon();
        leftHorn.getPoints().addAll(new Double[]{Constants.COW_LEFT_HORN_PT1_POS_X, Constants.COW_HORN_PT1_POS_Y, Constants.COW_LEFT_HORN_PT2_POS_X, Constants.COW_HORN_PT2_POS_Y, Constants.COW_LEFT_HORN_PT3_POS_X, Constants.COW_HORN_PT3_POS_Y});
        leftHorn.setFill(Color.WHITE);
        leftHorn.setStroke(Color.BLACK);
        leftHorn.setStrokeWidth(Constants.STROKE_WIDTH);

        Polygon rightHorn = new Polygon();
        rightHorn.getPoints().addAll(new Double[]{Constants.COW_RIGHT_HORN_PT1_POS_X, Constants.COW_HORN_PT1_POS_Y, Constants.COW_RIGHT_HORN_PT2_POS_X, Constants.COW_HORN_PT2_POS_Y, Constants.COW_RIGHT_HORN_PT3_POS_X, Constants.COW_HORN_PT3_POS_Y});
        rightHorn.setFill(Color.WHITE);
        rightHorn.setStroke(Color.BLACK);
        rightHorn.setStrokeWidth(Constants.STROKE_WIDTH);

        _cowPane.getChildren().addAll(leftHorn, rightHorn);
    }

    //This method returns a black spot.
    public Circle makeSpots(int x, int y, int radius) {
        return new Circle(Constants.COW_BODY_POS_X + x, Constants.COW_BODY_POS_Y + y, Constants.SPOT_RAD + radius, Color.BLACK);
    }

    //This method creates the cow's black hooves and adds it to the cowPane.
    public void makeHooves() {
        Rectangle leftLegHoove = new Rectangle(Constants.LEFT_LEG_HOOVE_POS_X, Constants.LEG_HOOVE_POS_Y, Constants.LEG_HOOVE_WIDTH, Constants.LEG_HOOVE_HEIGHT);
        leftLegHoove.setFill(Color.BLACK);

        Rectangle rightLegHoove = new Rectangle(Constants.RIGHT_LEG_HOOVE_POS_X, Constants.LEG_HOOVE_POS_Y, Constants.LEG_HOOVE_WIDTH, Constants.LEG_HOOVE_HEIGHT);
        rightLegHoove.setFill(Color.BLACK);

        Ellipse leftArmHoove = new Ellipse(Constants.LEFT_ARM_HOOVE_POS_X, Constants.ARM_HOOVE_POS_Y, Constants.ARM_HOOVE_RAD_X, Constants.ARM_HOOVE_RAD_Y);
        leftArmHoove.setFill(Color.BLACK);

        Ellipse rightArmHoove = new Ellipse(Constants.RIGHT_ARM_HOOVE_POS_X, Constants.ARM_HOOVE_POS_Y, Constants.ARM_HOOVE_RAD_X, Constants.ARM_HOOVE_RAD_Y);
        rightArmHoove.setFill(Color.BLACK);

        _cowPane.getChildren().addAll(leftLegHoove, rightLegHoove, leftArmHoove, rightArmHoove);
    }
}
