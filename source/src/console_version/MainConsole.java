package console_version;

/*
 Main simple console version
* */
public class MainConsole {

    public static void main(String[] args) throws InterruptedException {
        // instantiate from MatchSession
        MatchSession match = new MatchSession();

        //System.1out.println(match.singleTurn(3,2,'X'));
        match.startGameSession();
    }

}
