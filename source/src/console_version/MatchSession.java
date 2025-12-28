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
    String gameTagPlayerOne;
    String gameTagPlayerTwo;

    // instantiate Scanner
    Scanner  reader = new Scanner(System.in);
    // initialize board
    BoardConsole board = new BoardConsole();

    public String singleTurn(int selectedRow, int selectedColumn, char playableChar) {
        return board.drawOverBoard(selectedRow, selectedColumn, playableChar);
    }

    // execute more than once and keep track of board state
    public String startGameSession() throws InterruptedException {

        // initialize series of turns
        System.out.println("Initializing game session...");

        // rules:
        try {
            System.out.println("Rules of the game:");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("Each player has to to enter the desired position for both row and column. ");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("Enter the positions separated by a comma.");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("For example: '2,3' ");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // turn one?
        System.out.println("Enter position for selected row: ");
        System.out.println();
        int n = reader.nextInt();
        System.out.println("Player one has selected row position at: " + n);
        return "Player one has selected row" + n;

    }
}
