
public class Score {
    String userSelection;
    String compSelection;
    String gameOutcome;
    String username;
    int round;


    public Score(int round, String username, String userSelection, String compSelection) {
        this.round = round;
        this.username = username;
        this.userSelection = userSelection;
        this.compSelection = compSelection;
    }

    public int getRound() {
        return this.round;
    }

    public String getUserSelection(){
        return this.userSelection;
    }
    public String getCompSelection(){
        return this.compSelection;
    }

}
