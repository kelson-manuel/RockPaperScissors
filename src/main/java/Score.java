import java.util.List;
public class Score {
    int userScore;
    int compScore;
    String gameOutcome;
    String username;
    int round;


    public Score(int round, String username, int userScore, int compScore) {
        this.round = round;
        this.username = username;
        this.userScore = userScore;
        this.compScore = compScore;
    }

}
