package console_version;

import java.util.Arrays;

public class BoardConsole {

    // interface 1: CREATE AND INITIALIZE board console / attributes
    // how board does actually look like:
    // [ [ X, X, X ] , --> 3 rows and 3 columns
    //   [ X, X, X ] , --> second array
    //   [ X, X, X ] , ---> third array
    //              ]

    // ALLOCATE memory for 9 characters
    private char[][] board = { {Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE},
            {Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE},
            {Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE} }; // hold up 3 elements per sub-array?


    // interface 1: get a copy that we can modify
    public char[][] getBoard() {
        return board.clone();
    }

    // interface 2. draw a new symbol in the board
    public String drawOverBoard(int selectedRow, int selectedColum, char playableChar) {
        // initialize play session board
        char[][] board = getBoard();

        // avoid negative integers or greater than the current domain
        boolean isNegative = selectedColum < 0 || selectedRow < 0;
        boolean isGreater = selectedColum > board.length || selectedRow > board.length;
        // zero index selection
        if (isGreater || isNegative) {
            return "Out of bounds! Please, play again, and select a number between or equal to 1 and 3.";
        }
        // we assured correct user's input
        selectedRow -= 1;
        selectedColum -= 1;
        // draw over board with specified positions [x: row, y: column]
        board[selectedRow][selectedColum] = playableChar;

        // return modified board
        return Arrays.deepToString(board);
    }

}
