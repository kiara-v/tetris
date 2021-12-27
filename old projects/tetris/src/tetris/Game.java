package tetris;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * This is the Game class, where most of our game's logic is placed.
 */

public class Game {
    private Pane _boardPane;
    private Square[][] _board;
    private Piece _testPiece;
    private Timeline _timeline;
    private Label _label;

    /**
     * This is the Game's constructor.
     * It takes in parameters so that the game knows about the board pane and label, to be edited in certain cases.
     * @param boardPane
     * @param label
     *
     * The board pane is set on on the KeyHandler so that the piece can move.
     * The board is called on to be made, the timeline is setup, and a new piece is generated.
     */

    public Game(Pane boardPane, Label label) {
        _boardPane = boardPane;
        _label = label;
        _boardPane.setOnKeyPressed(new KeyHandler());
        _boardPane.setFocusTraversable(true);
        _boardPane.requestFocus();

        this.makeBoard();
        this.setupTimeline();
        this.generatePiece();
    }

    /**
     * This method created the 2D board array of squares.
     * For each column and row, the square of that board is null.
     * A border for the array is created with squares so that the piece has a guide for staying within the screen.
     */

    public void makeBoard() {
        _board = new Square[Constants.BOARD_ROWS][Constants.BOARD_COLUMNS];

        for (int row = 0; row < Constants.BOARD_ROWS; row++) {
            for (int col = 0; col < Constants.BOARD_COLUMNS; col++) {
                _board[row][col] = null;

                if (row == 0 || row == Constants.BOARD_ROWS - 1 || col == 0 || col == Constants.BOARD_COLUMNS - 1) {
                    Square square = new Square();
                    _board[row][col] = square;
                    square.setXLoc(col * Constants.SQUARE_WIDTH);
                    square.setYLoc(row * Constants.SQUARE_WIDTH);
                    square.getSquare().setFill(Color.DARKGREY);
                    square.getSquare().setStroke(Color.BLACK);
                    square.getSquare().setStrokeWidth(Constants.STROKE);
                    _boardPane.getChildren().add(square.getSquare());
                }
            }
        }
    }

    // This method generates a new piece and adds it to the board pane.

    public void generatePiece() {
        _testPiece = new Piece(_board);
        for (Square square : _testPiece.getPieceSquares()) {
            _boardPane.getChildren().add(square.getSquare());
        }
    }

    /**
     * This is the private KeyHandler class.
     * It has a switch so that: whenever the left key is pressed, the newest piece generated moves left one index;
     * whenever the right key is pressed, the newest piece generated moves right one index;
     * whenever the down key is pressed, the newest piece generated moves down one index;
     * whenever the up key is pressed, the newest piece generated turns counterclockwise once;
     * whenever p is pressed, the game pauses and unpauses.
     */

    private class KeyHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            KeyCode key = event.getCode();
            switch (key) {
                case LEFT:
                    if (_timeline.getCurrentRate() != 0) {
                        _testPiece.movePieceX(-1);
                        _label.setText("slide to the left");
                        _label.setTranslateX(135);
                        _label.setTextFill(Color.WHITE);
                    }
                    break;
                case RIGHT:
                    if (_timeline.getCurrentRate() != 0) {
                        _testPiece.movePieceX(1);
                        _label.setText("slide to the right");
                        _label.setTranslateX(135);
                        _label.setTextFill(Color.WHITE);
                    }
                    break;
                case DOWN:
                    if (_timeline.getCurrentRate() != 0) {
                        if (_testPiece.canMove(0, 1)) {
                            _testPiece.movePieceY(1);
                            _label.setText("i bet you're the type to go down stairs two steps at a time");
                            _label.setTranslateX(35);
                            _label.setTextFill(Color.WHITE);
                        }
                    }
                    break;
                case UP:
                    if (_timeline.getCurrentRate() != 0) {
                        _testPiece.rotate();
                        _label.setText("cartwheel");
                        _label.setTranslateX(150);
                        _label.setTextFill(Color.WHITE);
                    }
                    break;
                case SPACE:
                    if (_timeline.getCurrentRate() != 0) {
                        _testPiece.fall();
                        _label.setText("*screams*");
                        _label.setTranslateX(150);
                        _label.setTextFill(Color.WHITE);
                    }
                    break;
                case P:
                    if (_timeline.getCurrentRate() != 0) {
                        _timeline.pause();
                        _label.setText("you are paused my dude");
                        _label.setTranslateX(115);
                        _label.setTextFill(Color.WHITE);
                        _boardPane.setOpacity(0.6);
                    } else {
                        _timeline.play();
                        _label.setText("");
                        _boardPane.setOpacity(1);
                    }
                    break;
                default:
                    break;
            }
            event.consume();
        }
    }

    // This method sets up the timeline in order for the game to run.

    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION), new TimeHandler());
        _timeline = new Timeline(kf);
        _timeline.setCycleCount(Animation.INDEFINITE);
        _timeline.play();
    }

    /**
     * This is the private TimeHandler class.
     *
     * If the piece can no longer move, the piece's squares are added to the board array and a new piece is generated.
     * Otherwise, the piece moves down one index.
     * Lines are also checked to see if they are full and should be cleared.
     * The game also checks if the game is over.
     */

    private class TimeHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (_testPiece.canMove(0,1) == false) {
                _testPiece.addPieceToBoard();
                generatePiece();
            } else {
                _testPiece.movePieceY(1);
                _label.setText("");
            }
            clearLines();
            gameOver();
        }
    }

    /**
     * This method checks if a roll is full. It takes in a row as a parameter so that it can one row at a time in the
     * clearLines method.
     * @param row
     * @return
     *
     * A counter for how many squares are filled in the row is instantiated.
     * Each column of the row is looked at and if the square at that index is not null, the counter increases.
     * If the counter reaches the total number of columns in the board, the method returns true, meaning the row is full.
     * Otherwise, the method returns false.
     */

    public boolean rowIsFull(int row) {
        int rowCount = 0;
        for (int col = 0; col < Constants.BOARD_COLUMNS; col++) {
            if (_board[row][col] != null) {
                rowCount++;
            }
        }
        if (rowCount >= Constants.BOARD_COLUMNS) {
            return true;
        }
        return false;
    }

    /**
     * This method deletes full rows and moves the above rows down.
     * Each row inside the border is looked at and if the row is full, each column of the row is looked at and the
     * square at each column of the full row is deleted graphically and logically.
     * Then the rows from the once full row to the top of the board moves down a row and the positions of the moving
     * squares are updated in the array.
     */

    public void clearLines() {
        for (int row = 1; row < Constants.BOARD_ROWS-1; row++) {
            if (rowIsFull(row)) {
                for (int col = 1; col < Constants.BOARD_COLUMNS-1; col++) {
                    _boardPane.getChildren().remove(_board[row][col].getSquare());
                    _board[row][col] = null;
                }
                for (int i = row; i > 1; i--) {
                    for (int j = 1; j < Constants.BOARD_COLUMNS-1; j++) {
                        if (_board[i-1][j] != null) {
                            _board[i-1][j].setYLoc(_board[i-1][j].getYLoc() + Constants.SQUARE_WIDTH);

                            Square squareToMove = _board[i-1][j];
                            _board[i-1][j] = null;
                            _board[i][j] = squareToMove;
                        }
                    }
                }
            }
        }
    }

    /**
     * This method ends the game if any piece at the top row of the board is filled or if the newest generated piece
     * can not move.
     *
     * The timeline stops, a game over label is displayed and the opacity of the game decreases.
     */

    public void gameOver() {
        for (int col = 1; col < Constants.BOARD_COLUMNS-1; col++) {
            if (_board[1][col] != null || !_testPiece.canMove(0,0)) {
                _timeline.stop();
                _label.setText("game over loser");
                _label.setTranslateY(Constants.SCENE_HEIGHT/2);
                _label.setTranslateX(135);
                _label.setTextFill(Color.HOTPINK);
                _label.setScaleX(3.0);
                _label.setScaleY(3.0);
                _boardPane.setOpacity(0.2);
            }
        }
    }
}
