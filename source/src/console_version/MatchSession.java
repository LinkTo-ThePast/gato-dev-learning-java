package console_version;

/*
* this class establish the game session
* allows players to draw a symbol over the board (once per turn)
* determines if there's a winner
* */
public class MatchSession {
    int turns;
    String gameTagPlayerOne;
    String gameTagPlayerTwo;

    // initialize board
    BoardConsole board = new BoardConsole();

    public String singleTurn(int selectedRow, int selectedColumn, char playableChar) {
        return board.drawOverBoard(selectedRow, selectedColumn, playableChar);
    }
}
