package tetris;

import javafx.scene.paint.Color;

/**
 * This is the Piece class.
 */

public class Piece {
    private Square[] _pieceSquares;
    private int[][] _coords;
    private Square[][] _board;
    private boolean _pieceRotate;

    /**
     * This is the Piece's constructor.
     * It takes in the 2D board array as a parameter so that it can add the piece's squares to the board.
     * @param board
     *
     * An array is made to encompass the piece's configuration of four squares.
     * A new piece is also made.
     */

    public Piece(Square[][] board) {
        _board = board;
        _pieceSquares = new Square[4];

        this.generatePiece();
    }

    // This method creates four squares and arranges them into a randomized configuration.

    public void generatePiece() {
        for (int i = 0; i < 4; i++) {
            _pieceSquares[i] = new Square();
        }
        this.arrangePiece();
    }

    /**
     * This method arranges the piece into a randomized configuration of four squares.
     * Each configuration has an array of four coordinates for each square and a different color for each piece.
     * Also the o shaped piece is set so that it can not rotate.
     */

    public void arrangePiece() {
        int rand_int = (int) (Math.random() * 10);
        switch (rand_int) {
            case 0:
                _coords = Constants.L_PIECE_COORDS;
                for (Square square : _pieceSquares) {
                    square.setColor(Color.web("92ceba"));
                    _pieceRotate = true;
                }
                break;
            case 1:
                _coords = Constants.O_PIECE_COORDS;
                for (Square square : _pieceSquares) {
                    square.setColor(Color.web("469f77"));
                    _pieceRotate = false;
                }
                break;
            case 2:
                _coords = Constants.UPSTAIRS_PIECE_COORDS;
                for (Square square : _pieceSquares) {
                    square.setColor(Color.web("ec9592"));
                    _pieceRotate = true;
                }
                break;
            case 3: case 4:
                _coords = Constants.DOWNSTAIRS_PIECE_COORDS;
                for (Square square : _pieceSquares) {
                    square.setColor(Color.web("bad8da"));
                    _pieceRotate = true;
                }
                break;
            case 5:
                _coords = Constants.I_PIECE_COORDS;
                for (Square square : _pieceSquares) {
                    square.setColor(Color.web("ebe776"));
                    _pieceRotate = true;
                }
                break;
            case 6: case 7:
                _coords = Constants.T_PIECE_COORDS;
                for (Square square : _pieceSquares) {
                    square.setColor(Color.web("b69ce0"));
                    _pieceRotate = true;
                }
                break;
            case 8: case 9:
                _coords = Constants.BOOT_PIECE_COORDS;
                for (Square square : _pieceSquares) {
                    square.setColor(Color.web("e96f6e"));
                    _pieceRotate = true;
                }
                break;
            default:
                break;
        }
        for (Square square : _pieceSquares) {
            square.getSquare().setStroke(Color.BLACK);
            square.getSquare().setStrokeWidth(Constants.STROKE);
        }

        for (int i = 0; i < 4; i++) {
            _pieceSquares[i].setXLoc(_coords[i][0] + 4*Constants.SQUARE_WIDTH);
            _pieceSquares[i].setYLoc(_coords[i][1] + Constants.SQUARE_WIDTH);
        }
    }

    // This method returns a boolean based on the switch that generates a randomized piece.

    public boolean checkPieceRotation() {
        return _pieceRotate;
    }

    // This method moves the piece down by an index as long as whatever is below it is null.

    public void fall() {
        while (canMove(0, 1) == true) {
            movePieceY(1);
        }
    }

    // This method adds the piece's square to the board array.

    public void addPieceToBoard() {
        for (int i = 0; i < 4; i++) {
            int boardX = (int) _pieceSquares[i].getXLoc()/Constants.SQUARE_WIDTH;
            int boardY = (int) _pieceSquares[i].getYLoc()/Constants.SQUARE_WIDTH;
            _board[boardY][boardX] = _pieceSquares[i];
        }
    }

    // This helper method changes the color of all the squares in a piece.

    public void setColor(Color color) {
        for (Square square : _pieceSquares) {
            square.setColor(color);
        }
    }

    // This helper method change's the piece's x-value by changing all of the piece's squares x-values.

    public void movePieceX(int x) {
        if (canMove(x, 0)) {
            for (int i = 0; i < 4; i++) {
                _pieceSquares[i].setXLoc(_pieceSquares[i].getXLoc() + x * Constants.SQUARE_WIDTH);
            }
        }
    }

    // This method change's the piece's y-value by changing all of the piece's squares y-values.

    public void movePieceY(int y) {
        for (int i = 0; i < 4; i++) {
            _pieceSquares[i].setYLoc(_pieceSquares[i].getYLoc() + y * Constants.SQUARE_WIDTH);
        }
    }

    /**
     * This method rotates the piece counterclockwise.
     * It checks if the piece is allowed to rotate based on its configuration and then instantiates a canRotate boolean to true.
     * If any of the piece's squares aren't allowed to rotate, then it sets the boolean to false.
     * If all squares are allowed to rotate, then the piece rotates counterclockwise.
     */

    public void rotate() {
        if (checkPieceRotation()) {
            boolean canRotate = true;
            for (int i = 0; i < 4; i++) {
                int centerOfRotationX = (int) _pieceSquares[0].getXLoc();
                int centerOfRotationY = (int) _pieceSquares[0].getYLoc();

                int oldXLocation = (int) _pieceSquares[i].getXLoc();
                int oldYLocation = (int) _pieceSquares[i].getYLoc();

                int newXLoc = centerOfRotationX + -1 * centerOfRotationY + oldYLocation;
                int newYLoc = centerOfRotationY + centerOfRotationX + -1 * oldXLocation;

                if (!isValidLocation(newXLoc, newYLoc)) {
                    canRotate = false;
                }
            }
            if (canRotate) {
                for (int i = 0; i < 4; i++) {
                    int centerOfRotationX = (int) _pieceSquares[0].getXLoc();
                    int centerOfRotationY = (int) _pieceSquares[0].getYLoc();

                    int oldXLocation = (int) _pieceSquares[i].getXLoc();
                    int oldYLocation = (int) _pieceSquares[i].getYLoc();

                    int newXLoc = centerOfRotationX + -1 * centerOfRotationY + oldYLocation;
                    int newYLoc = centerOfRotationY + centerOfRotationX + -1 * oldXLocation;
                    _pieceSquares[i].setXLoc(newXLoc);
                    _pieceSquares[i].setYLoc(newYLoc);
                }
            }
            canRotate = true;
        }
    }

    // This method returns a boolean and checks if a square were to rotate, if it's potential position is null.

    public boolean isValidLocation(int x, int y) {
        int squareXIndex = x / Constants.SQUARE_WIDTH;
        int squareYIndex = y / Constants.SQUARE_WIDTH;
        if (!(squareXIndex >= 1 && squareXIndex < Constants.BOARD_COLUMNS - 1
                && squareYIndex >= 1 && squareYIndex < Constants.BOARD_ROWS - 1)) {
            return false;
        }
        if (!(_board[squareYIndex][squareXIndex] == null)) {
            return false;
        }
        return true;
    }

    // This method returns a boolean and checks if a square were to move, if it's potential position is null.

    public boolean canMove(int moveX, int moveY) {
        for (int i = 0; i < 4; i++) {
            double newY = _pieceSquares[i].getYLoc() + moveY*Constants.SQUARE_WIDTH;
            double newX = _pieceSquares[i].getXLoc() + moveX*Constants.SQUARE_WIDTH;
            int row = (int) (newY/Constants.SQUARE_WIDTH);
            int col = (int) (newX/Constants.SQUARE_WIDTH);
            if (_board[row][col] != null) {
                return false;
            }
        }
        return true;
    }

    // This method returns the array of squares in the piece.

    public Square[] getPieceSquares() {
        return _pieceSquares;
    }
}
