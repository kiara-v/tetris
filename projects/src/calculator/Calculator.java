package calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Calculator {
    private Pane _root;
    private Rectangle _screen;
    private Label _result;

    private CircleButton _n0;
    private CircleButton _n1;
    private CircleButton _n2;
    private CircleButton _n3;
    private CircleButton _n4;
    private CircleButton _n5;
    private CircleButton _n6;
    private CircleButton _n7;
    private CircleButton _n8;
    private CircleButton _n9;

    private CircleButton _divideB;
    private CircleButton _multiplyB;
    private CircleButton _addB;
    private CircleButton _minusB;
    private CircleButton _decimalB;
    private CircleButton _equalB;
    private CircleButton _sqrtB;
    private CircleButton _cB;

    private Boolean _addBool = false;
    private Boolean _subBool = false;
    private Boolean _divBool = false;
    private Boolean _mulBool = false;
    private double TEMP;
    private double SolveTEMP;
    private String display = "";

    public Calculator() {
        _root = new Pane();
        BackgroundFill fill = new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(fill);
        _root.setBackground(background);


        GridPane pane = new GridPane();
        pane.setMinSize(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        pane.setPadding(new Insets(Constants.PADDING, Constants.PADDING, Constants.PADDING, Constants.PADDING));
        pane.setVgap(Constants.GAP);
        pane.setHgap(Constants.GAP);
        pane.setAlignment(Pos.TOP_CENTER);
        _root.getChildren().add(pane);

        _screen = new Rectangle(250, 75, Color.LIGHTGREY);
        _screen.setStroke(Color.DARKGREY);
        _screen.setStrokeWidth(0.7);
        _screen.setArcWidth(30);
        _screen.setArcHeight(20);
        _root.getChildren().add(_screen);
        _screen.setTranslateX(25);
        _screen.setTranslateY(50);

        _result = new Label("");
        _result.setScaleX(2);
        _result.setScaleY(2);
        _result.setTranslateX(78);
        _result.setTranslateY(85);
        _result.setPadding(new Insets(0, 2*Constants.PADDING, 0, Constants.PADDING));

        Label title = new Label("math!");
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 50);
        title.setFont(font);
        title.setTextFill(Color.WHITE);
        _root.getChildren().addAll(title, _result);
        title.setTranslateX(35);
        title.setTranslateY(5);

        setButtons(pane);
    }

    private void setButtons(GridPane pane) {
        CircleButton quitB = new CircleButton(pane, "quit", 0, 0);
        quitB.setOnAction(new QuitHandler());

        CircleButton idkB = new CircleButton(pane, "( ͡° ͜ʖ ͡°)", 2, 0);
        idkB.setOnAction(new ColorHandler());

        _cB = new CircleButton(pane, "c", 3, 0);

        _n0 = new CircleButton(pane, "0", 0, 4);
        _n1 = new CircleButton(pane, "1", 0, 3);
        _n2 = new CircleButton(pane, "2", 1, 3);
        _n3 = new CircleButton(pane, "3", 2, 3);
        _n4 = new CircleButton(pane, "4", 0, 2);
        _n5 = new CircleButton(pane, "5", 1, 2);
        _n6 = new CircleButton(pane, "6", 2, 2);
        _n7 = new CircleButton(pane, "7", 0, 1);
        _n8 = new CircleButton(pane, "8", 1, 1);
        _n9 = new CircleButton(pane, "9", 2, 1);
        _decimalB = new CircleButton(pane, ".", 1, 4);

        _addB = new CircleButton(pane, "+", 3, 4);
        _minusB = new CircleButton(pane, "-", 3, 3);
        _multiplyB = new CircleButton(pane, "x", 3, 2);
        _divideB = new CircleButton(pane, "÷", 3, 1);
        _equalB = new CircleButton(pane, "=", 2, 4);
        _sqrtB = new CircleButton(pane, "√", 1, 0);

        _n1.setOnAction(new ListenToOne());
        _n2.setOnAction(new ListenToTwo());
        _n3.setOnAction(new ListenToThree());
        _n4.setOnAction(new ListenToFour());
        _n5.setOnAction(new ListenToFive());
        _n6.setOnAction(new ListenToSix());
        _n7.setOnAction(new ListenToSeven());
        _n8.setOnAction(new ListenToEight());
        _n9.setOnAction(new ListenToNine());
        _n0.setOnAction(new ListenToZero());

        _addB.setOnAction(new ListenToAdd());
        _minusB.setOnAction(new ListenToSubtract());
        _multiplyB.setOnAction(new ListenToMultiply());
        _divideB.setOnAction(new ListenToDivide());
        _equalB.setOnAction(new ListenToSolve());
        _cB.setOnAction(new ListenToClear());
        _sqrtB.setOnAction(new ListenToSqrt());
        _decimalB.setOnAction(new ListenToDecimal());
    }

    class ListenToClear implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            //display = jtfResult.getText();
            _result.setText("");
            _addBool = false;
            _subBool = false;
            _mulBool = false;
            _divBool = false;

            TEMP = 0;
            SolveTEMP = 0;
        }
    }

    class ListenToOne implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + "1");
        }
    }

    class ListenToTwo implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + "2");
        }
    }

    class ListenToThree implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + "3");
        }
    }

    class ListenToFour implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + "4");
        }
    }

    class ListenToFive implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + "5");
        }
    }

    class ListenToSix implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + "6");
        }
    }

    class ListenToSeven implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + "7");
        }
    }

    class ListenToEight implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + "8");
        }
    }

    class ListenToNine implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + "9");
        }
    }

    class ListenToZero implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + "0");
        }
    }

    class ListenToAdd implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            TEMP = Double.parseDouble(_result.getText());
            _result.setText("");
            _addBool = true;
        }
    }

    class ListenToSubtract implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            TEMP = Double.parseDouble(_result.getText());
            _result.setText("");
            _subBool = true;
        }
    }

    class ListenToMultiply implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            TEMP = Double.parseDouble(_result.getText());
            _result.setText("");
            _mulBool = true;
        }
    }

    class ListenToDivide implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            TEMP = Double.parseDouble(_result.getText());
            _result.setText("");
            _divBool = true;
        }
    }

    class ListenToSolve implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            SolveTEMP = Double.parseDouble(_result.getText());
            if (_addBool == true)
                SolveTEMP = SolveTEMP + TEMP;
            else if (_subBool == true)
                SolveTEMP = SolveTEMP - TEMP;
            else if (_mulBool == true)
                SolveTEMP = SolveTEMP * TEMP;
            else if (_divBool == true)
                SolveTEMP = SolveTEMP / TEMP;
            _result.setText(Double.toString(SolveTEMP));

            _addBool = false;
            _subBool = false;
            _mulBool = false;
            _divBool = false;
        }
    }

    public Pane getRoot() {
        return _root;
    }

    private class QuitHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
            event.consume();
        }
    }

    private class ColorHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            int red = (int) (Math.random()*256);
            int green = (int) (Math.random()*256);
            int blue  = (int) (Math.random()*256);
            Color customColor = Color.rgb(red,green,blue);

            BackgroundFill fill = new BackgroundFill(customColor, CornerRadii.EMPTY, Insets.EMPTY);
            Background background = new Background(fill);
            _root.setBackground(background);
        }
    }

    private class ListenToSqrt implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            TEMP = Double.parseDouble(_result.getText());
            SolveTEMP = Math.sqrt(TEMP);
            _result.setText(Double.toString(SolveTEMP));
        }
    }

    private class ListenToDecimal implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            display = _result.getText();
            _result.setText(display + ".");
        }
    }
}

