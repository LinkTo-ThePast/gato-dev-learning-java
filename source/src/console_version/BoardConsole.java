package console_version;
import java.util.Arrays;

/**
 * Represents the actual "gato" (tic-tac-toe) board
 * Theory concept applied: encapsulate board state and enforces controlled access
 * through accessor and mutators methods (studied concept from book: data hiding)
*/
public class BoardConsole {

    // BOARD IS AN ARRAY OF ARRAYS: 2D array, with 3 rows and 3 columns:
    private static final int BOARD_SIZE = 3;

    // Internal board state: data hiding -> protect internal state from outside classes
    private char board[][];

    /**
     * constructor: Initializes board with positional reference characters
     * Note: positions are labeled from 'a' through 'i' for display purposes.
     */
    public BoardConsole() {
        this.board = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };
    }

    // --> fix: modifying shallow copy
    public char[][] getBoard() {
        char[][] boardCopy = new char[BOARD_SIZE][];
        for (int i = 0; i < BOARD_SIZE; i++) {
            boardCopy[i] = board[i].clone();
        }
        return boardCopy;
    }


    // interface 2. draw a new symbol in the board
    // this is a mutator method

    /**
     *
     * @param selectedRow: row index selected by player [from 1 to 3]
     * @param selectedColum: column index selected by player [from 1 to 3]
     * @param playableChar: character that is going to be drawn -> 'X' or 'O'
     * @throws IllegalArgumentException if position is out bonds
     */
    public void drawOverBoard(int selectedRow, int selectedColum, char playableChar) {

        // avoid negative integers or greater than the current domain
        boolean isNegative = selectedColum <= 0 || selectedRow <= 0;
        boolean isGreater = selectedColum > board.length || selectedRow > board.length;
        // zero index selection
        if (isGreater || isNegative) {
            throw new IllegalArgumentException("Position selected must be between 1 and " + BOARD_SIZE +
                    ". " + "Selected position: " + "Row -> " + selectedRow + " / Column ->  " + selectedColum);
        }
        // we assured correct user's input
        selectedRow -= 1;
        selectedColum -= 1;
        // draw over board with specified positions [x: row, y: column]

        this.board[selectedRow][selectedColum] = playableChar;

    }

}
