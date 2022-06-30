/* Plan
1. Play game up to 3 initially (or specified amount)
2. Define counter and loop over until counter equals specfied amount
2. Call a method on user to get them to pick, then a method for comp to randomly select
3. Check winning conditions.

Important:
- Explain rules at start
- Save user and comp selection in separate list?
- If draw then the game should replay the round, counter must not move up so maybe use if(!draw)
- Possibly
- Use exception handling for when user puts a selection to avoid incorrect choices?
 */


import java.util.List;
import java.util.ArrayList;

public class Game {
    int round = 0;
    int maxRound;
    User user;
    Computer computer;
    List<Score> outcomeList = new ArrayList<>();

    public Game(int maxRound, User user, Computer computer) {
        this.maxRound = maxRound;
        this.user = user;
        this.computer = computer;
    }

    //explain rules
    private void rulesExplanation() {
        System.out.println();
        System.out.println("Rules:");
        System.out.println("------------------------------");
        System.out.println("Please input only \"rock\", \"paper\" or \"scissors\"");
        System.out.println("Anything else will be ignored");
        System.out.println("------------------------------");
        System.out.println();
    }

    public void playGame() {
        while (round <= maxRound) {
            if ( round == 0) {
                user.setName();
                rulesExplanation();
                round++;
            }

            System.out.println("Round " + round + " start");
            System.out.println();


            String userSelection = user.select();
            String compSelection = computer.select();

            while (userSelection.equals(compSelection)) {
                System.out.println("Draw, please try again");
                userSelection = user.select();
                compSelection = computer.select();
            }

            //user win condition
            if (
                    (userSelection.equals("rock") && compSelection.equals("scissors")) ||
                    (userSelection.equals("paper") && compSelection.equals("rock")) ||
                    (userSelection.equals("scissors") && compSelection.equals("paper"))

            ){
                System.out.println( user.getName() + " win! " + userSelection + " beats " + compSelection);
                user.win();
                roundOutcome();
            }

            //computer selection
            if (
                    (userSelection.equals("rock") && compSelection.equals("paper"))||
                    (userSelection.equals("paper") && compSelection.equals("scissors"))||
                    (userSelection.equals("scissors") && compSelection.equals("rock"))
            ){
                System.out.println( "You lose! " + compSelection + " beats " + userSelection);
                computer.win();
                roundOutcome();
            }
            Score roundOutcome = new Score(round, user.getName(), userSelection,  compSelection);
            addScoreList(roundOutcome);
            round++;

        }


        if (user.score == computer.score) {
            System.out.println("Uhhh its a draw. What are the odds?");
        } else if (user.score > computer.score) {
            System.out.println();
            System.out.println(user.getName() + " Wins! Congratulations.");
        } else {
            System.out.println("You lost. You may have won some battles but you've lost the war :(");
        }

      printOutcome();
    }

    //Add list of scores for round
    public void addScoreList(Score listOfScore) {
        outcomeList.add(listOfScore);
    }

    //Outcome table for all users
    public void printOutcome() {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s", "Round", user.getName(), "Computer");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(Score outcome : outcomeList){
            System.out.format("%10s %20s %20s",
                   outcome.getRound() , outcome.getUserSelection(), outcome.getCompSelection());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
        //Total point score
        System.out.printf("%10s %20s %20s", "Total Score", user.getScore(), computer.getScore());
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
    }

    //round outcome
        public void roundOutcome() {
        System.out.println("-----------------------------------------------------------------------------");
        //Total point score
        System.out.printf("%10s %20s  %20s",
                "Round Score", "User: " + user.getScore(), "Computer: " + computer.getScore());
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        }
}
