package console_version;

import java.util.Arrays;

public class BoardConsole {
    // initialize board console / attributes
    private char[][] board = {{Character.MIN_VALUE,Character.MIN_VALUE, Character.MIN_VALUE},
            {Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE},
            {Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE}
    };

    // behaviours / methods
    public String getBoard(char[][] board) {
        return Arrays.deepToString(board);
    }

    // columns/rows
    public int getBoardLength() {
        return board.length;
    }

    public void printBoard() {
        System.out.println(getBoard(board));
    }


}
