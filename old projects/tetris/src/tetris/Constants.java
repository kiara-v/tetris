package tetris;

/**
 * This is my Constants class
 */

public class Constants {

    // size of app
    public static final int SCENE_WIDTH = 12 * 30;
    public static final int SCENE_HEIGHT = 23 * 30;

    // size of 2D board array
    public static final int BOARD_ROWS = 22;
    public static final int BOARD_COLUMNS = 12;

    // width of each square
    public static final int SQUARE_WIDTH = 30;

    // stroke width of border of each square
    public static final int STROKE = 4;

    // speed of timeline in seconds
    public static final double DURATION = 0.4;

    // coordinates for squares in each tetris piece
    public static final int[][] I_PIECE_COORDS = { {0+SQUARE_WIDTH, 0}, {0+SQUARE_WIDTH, SQUARE_WIDTH}, {0+SQUARE_WIDTH, 2*SQUARE_WIDTH}, {0+SQUARE_WIDTH, 3*SQUARE_WIDTH} };
    public static final int[][] T_PIECE_COORDS = { {0+SQUARE_WIDTH,0}, {SQUARE_WIDTH+SQUARE_WIDTH, 0}, {2*SQUARE_WIDTH+SQUARE_WIDTH, 0}, {SQUARE_WIDTH+SQUARE_WIDTH, SQUARE_WIDTH}};
    public static final int[][] L_PIECE_COORDS = { {0+SQUARE_WIDTH,0}, {0+SQUARE_WIDTH,SQUARE_WIDTH}, {0+SQUARE_WIDTH,2*SQUARE_WIDTH}, {SQUARE_WIDTH+SQUARE_WIDTH,2*SQUARE_WIDTH} };
    public static final int[][] BOOT_PIECE_COORDS = { {0+SQUARE_WIDTH,2*SQUARE_WIDTH}, {SQUARE_WIDTH+SQUARE_WIDTH,0}, {SQUARE_WIDTH+SQUARE_WIDTH,SQUARE_WIDTH}, {SQUARE_WIDTH+SQUARE_WIDTH,2*SQUARE_WIDTH} };
    public static final int[][] O_PIECE_COORDS = { {0+SQUARE_WIDTH,0}, {0+SQUARE_WIDTH, SQUARE_WIDTH}, {SQUARE_WIDTH+SQUARE_WIDTH,0}, {SQUARE_WIDTH+SQUARE_WIDTH,SQUARE_WIDTH} };
    public static final int[][] DOWNSTAIRS_PIECE_COORDS = { {0+SQUARE_WIDTH,0}, {SQUARE_WIDTH+SQUARE_WIDTH,SQUARE_WIDTH}, {SQUARE_WIDTH+SQUARE_WIDTH,0}, {2*SQUARE_WIDTH+SQUARE_WIDTH,SQUARE_WIDTH} };
    public static final int[][] UPSTAIRS_PIECE_COORDS = { {0+SQUARE_WIDTH,SQUARE_WIDTH}, {SQUARE_WIDTH+SQUARE_WIDTH,0}, {SQUARE_WIDTH+SQUARE_WIDTH,SQUARE_WIDTH}, {2*SQUARE_WIDTH+SQUARE_WIDTH,0} };
}
