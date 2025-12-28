package console_version;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
* this class establish the game session
* allows players to draw a symbol over the board (once per turn)
* determines if there's a winner
* */
public class MatchSession {

    int turns;
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

    private String singleTurn() {
        // initialize turn by requesting user's input
        try {
            System.out.println("Enter position for selected row: ");
            selectedRowByPlayerOne = Integer.parseInt(reader.next());
            System.out.println("Enter position for selected column: ");
            selectedColumnByPlayerOne = Integer.parseInt(reader.next());
        } catch (NumberFormatException e) {
            // find a better solution when improve phase comes in
            System.out.println("at the moment, we cannot process your input. Sorry, initialize the game again.");
            System.exit(0);
        }
        return board.drawOverBoard(selectedRowByPlayerOne, selectedColumnByPlayerOne, selectedSymbolByPlayerOne);
    }


    public String startGameSession() throws InterruptedException {

        // starting the game
        System.out.println("Initializing game session...");

        // call game rules
        gameRules();

        // initialize turn for player one and return modified board after end of current turn
        String modifiedBoard = singleTurn();

        // finish one turn as an example
        try {
            // notify user
            System.out.println("Drawing over board based on selected positions by the user. ");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("Row: " + selectedRowByPlayerOne + ", " + "Column: " + selectedColumnByPlayerOne);

            // showing result after actual turn
            System.out.println("BOARD AFTER YOUR MOVE: ");
            System.out.println(modifiedBoard);
            return  modifiedBoard;

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
