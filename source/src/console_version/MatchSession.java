package console_version;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
* this class establish the game session
* allows players to draw a symbol over the board (once per turn)
* determines if there's a winner
* */
public class MatchSession {
    // each node on the grid represents a single turn, at maximum, there is 9 turns
    private final int TURNS = 9;
    // for UI
    String gameTagPlayerOne;
    String gameTagPlayerTwo;
    // player attributes
    int selectedRowByPlayerOne;
    int selectedColumnByPlayerOne;
    int selectedRowBySecondPlayer;
    int selectedColumnBySecondPlayer;
    // as default, player one has "X" symbol as playable character
    char selectedSymbolByPlayerOne = 'X';
    // as default, player one has "U" symbol as playable character
    char selectedSymbolBySecondPlayer = 'U';

    // instantiate Scanner
    Scanner  reader = new Scanner(System.in);
    // initialize board
    BoardConsole board = new BoardConsole();

    // rules statement
    private void gameRules() throws InterruptedException {
        // rules:
        try {
            System.out.println("Rules of the game:");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("Each player has to to enter the desired position for both row and column. ");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("For example --> '2', '2' would be the center of the grid.");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private char[][] singleTurn() {

        // instantiate board session
        char[][] sessionBoard = board.getBoard();
        // selecting char
        char selectedChar;
        // each iterative step represents a single turn
        for (int i = 0; i <= TURNS; i++) {
            // initialize turn by requesting user's input
            // selecting character based on even or odd number?
            if (i % 2 == 0) {
                selectedChar = selectedSymbolByPlayerOne;
            } else {selectedChar = selectedSymbolBySecondPlayer;}
            try {
                // actual user input
                System.out.println("Enter position for selected row: ");
                selectedRowByPlayerOne = Integer.parseInt(reader.next());
                System.out.println("Enter position for selected column: ");
                selectedColumnByPlayerOne = Integer.parseInt(reader.next());
                // notify user
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Drawing over board according to player input...");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Selected row: " + selectedRowByPlayerOne + ", " + "Selected column: " + selectedColumnByPlayerOne);

                sessionBoard = board.drawOverBoard(selectedRowByPlayerOne, selectedColumnByPlayerOne, selectedChar);

                if (sessionBoard[0][0] == sessionBoard[1][0] && sessionBoard[0][0] == sessionBoard[2][0]) {
                    System.out.println("Player " + selectedChar + " has won the game!");
                    break;
                }

                // SHOWING RESULT
                System.out.println("BOARD STATE AFTER YOUR MOVE: ");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(Arrays.deepToString(sessionBoard));
            } catch (RuntimeException | InterruptedException e) {
                // find a better solution when improve phase comes in
                System.out.println("at the moment, we cannot process your input. Sorry, initialize the game again.");
                System.exit(0);
            }
        }

        return sessionBoard;
    }


    public String startGameSession() throws InterruptedException {

        // starting the game
        System.out.println("Initializing game session...");

        // call game rules
        gameRules();

        // initialize turn for player one and return modified board after end of current turn
        char[][] finalBoard = singleTurn();

        return Arrays.deepToString(finalBoard);
    }
}
