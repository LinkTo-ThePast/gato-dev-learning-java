package console_version;

/**
 * Returns a copy of a board console.
 * The board console is the actual structure where the match takes place.
 */
public class BoardConsole {
    // ATTRIBUTES
    private final int BOARD_SIZE = 3;

    // DEFINE board structure as an array of arrays: an array containing 3 arrays
    private final char[][] board;

    // CONSTRUCTOR
    public BoardConsole() {
        this.board = new char[][] {
                {'X', 'X', 'X'},
                {'X', 'X', 'X'},
                {'X', 'X', 'X'}
        };
    }

    // get a copy so internal state does not get modified

    /**
     * Deep copy of the board
     * @return a playable board to initialize a game session
     */
    public static char[][] getBoard() {
        char[][] boardCopy = new char[BOARD_SIZE][];
        for (int i = 0; i < BOARD_SIZE; i++) {
            boardCopy[i] = board[i];
        }
        return boardCopy;
    }

    /**
     *
     * @param row: selected row by user
     * @param column: selected colum by user
     * @param playerSymbol: 'X' or 'O' according to what user has been selected.
     * @throws IllegalArgumentException: if row or column is out of bounds (value must be between 1 and 3)
     */
    public void drawOverBoard(int row, int column, char playerSymbol) {
        if ((row < 1 || row > BOARD_SIZE) || (column < 1 || column > BOARD_SIZE)) {
            throw new IllegalArgumentException("Both column and row must be values between 1 and 3. Please, introduce a valid number.");
        }

        this.board[row - 1][column - 1] = playerSymbol;
    }


}