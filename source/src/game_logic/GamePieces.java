package game_logic;
/*
*  Class for declare playable pieces by the players
*  currently only two choices: cat and a coffee
* */
public class GamePieces {

    public String pieceName;
    public String pieceFigure;

    public GamePieces(String pieceName, String pieceFigure) {
        pieceName = pieceName;
        pieceFigure = pieceFigure;
    }

    public void setPieceInBoard(String pieceName) {
        System.out.println("You have put on the board the following piece: " + pieceName );
    }

    public void removePieceInBoard(String pieceName) {
        System.out.println("You have removed of the board the following piece: " + pieceName);
    }
}
