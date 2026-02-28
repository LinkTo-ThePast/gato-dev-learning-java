package console_version;

import java.util.Arrays;

/**
 * Represents the actual "gato" (tic tac toe) board
 * Theory concept applied: encapsulate board state and enforces controlled access
 * through accessor and mutators methods (studied concept from book: data hiding)
*/
public class BoardConsole {

    // interface 1: CREATE AND INITIALIZE board console / attributes
    // how board does actually look like:
    // [ [ X, X, X ] , --> 3 rows and 3 columns
    //   [ X, X, X ] , --> second array
    //   [ X, X, X ] , ---> third array
    //              ]

    // ALLOCATE memory for 9 characters
    private char[][] board = { {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'} }; // hold up 3 elements per sub-array?

    // DATA HIDING CONCEPT
    // interface 1: get a copy that we can modify
    // this is an accessor method

    // --> fix: modifying shallow copy
    public char[][] getBoard() {
        return board.clone();
    }


    // interface 2. draw a new symbol in the board
    // this is a mutator method
    public char[][] drawOverBoard(int selectedRow, int selectedColum, char playableChar) {
        // initialize play session board
        // this creates a local variable, so then this method is acting like a pure function rather than modifying current state
        char[][] board = getBoard();

        // avoid negative integers or greater than the current domain
        boolean isNegative = selectedColum < 0 || selectedRow < 0;
        boolean isGreater = selectedColum > board.length || selectedRow > board.length;
        // zero index selection
        if (isGreater || isNegative) {
            return board;
        }
        // we assured correct user's input
        selectedRow -= 1;
        selectedColum -= 1;
        // draw over board with specified positions [x: row, y: column]
        board[selectedRow][selectedColum] = playableChar;

        // return modified board
        return board;
    }

}
