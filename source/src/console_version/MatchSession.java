package console_version;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    // player attributes
    int selectedRowByPlayer;
    int selectedColumnByPlayer;
    // as default, player one has "X" symbol as playable character
    char selectedSymbolByPlayerOne = 'X';
    // as default, player one has "U" symbol as playable character
    char selectedSymbolBySecondPlayer = 'W';

    // record and games rules
    Map<String, Integer> playerOneMovements = new HashMap<>();
    Map<String, Integer> playerTwoMovements = new HashMap<>();

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

    private boolean thereIsVictory(char[][] board) {
        return false;
    }

    private char[][] initializeTurns() {
        // instantiate board session
        char[][] sessionBoard = board.getBoard();
        // selecting char
        char selectedChar;

        // initialize records
        Map<String, Integer> historyOne = playerOneMovements;
        Map<String, Integer> historyTwO = playerTwoMovements;
        // each iterative step represents a single turn

        for (int i = 0; i < TURNS + 1; i++) {
            // initialize turn by requesting user's input
            // selecting character based on even or odd number?
            if (i % 2 == 0) {
                selectedChar = selectedSymbolByPlayerOne;
            } else {selectedChar = selectedSymbolBySecondPlayer;}

            try {
                // actual user input
                System.out.println("Enter position for selected row: ");
                selectedRowByPlayer = Integer.parseInt(reader.next());
                System.out.println("Enter position for selected column: ");
                selectedColumnByPlayer = Integer.parseInt(reader.next());
                // notify user
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Drawing over board according to player input...");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Selected row: " + selectedRowByPlayer + ", " + "Selected column: " + selectedColumnByPlayer);

                // check if exists a previous turn with that symbol
                if ((historyOne.containsKey("row_position_" + selectedRowByPlayer) && historyOne.containsKey("column_position_" + selectedColumnByPlayer)) ||
                        (historyTwO.containsKey(("row_position_" + selectedRowByPlayer)) && historyTwO.containsKey("column_position_" + selectedColumnByPlayer)))
                {
                    System.out.println("You can't play in a previous occupied position!");
                    break;
                }

                // not allow users to draw over the same place or over one place that is already occupied
                // player one history movements
                if (i % 2 == 0) {
                    historyOne.put("row_position_" + selectedRowByPlayer, selectedRowByPlayer);
                    historyOne.put("column_position_" + selectedColumnByPlayer, selectedColumnByPlayer);
                } else {
                    historyTwO.put("row_position_" + selectedRowByPlayer, selectedRowByPlayer);
                    historyTwO.put("column_position_" + selectedColumnByPlayer, selectedColumnByPlayer);
                }


                sessionBoard = board.drawOverBoard(selectedRowByPlayer, selectedColumnByPlayer, selectedChar);

                // after register board in this turn, check if there's victory
                boolean thereIsWin = thereIsVictory(sessionBoard);
                if (thereIsWin) {
                    System.out.println("You have won!");
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println("Final state of the board: ");
                    System.out.println(Arrays.deepToString(sessionBoard));
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
        char[][] finalBoard = initializeTurns();

        return Arrays.deepToString(finalBoard);
    }
}
