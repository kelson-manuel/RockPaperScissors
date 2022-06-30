/* Plan
1. Play game up to 5 (or specified amount)
2. Call a method on user to get them to pick, then a computer randomises it
3. Possible counter integer for rounds?

Important suggestions
-  Explain rules
- Define winning condition methods
- Save user and comp selection in separate list?
- If draw then the game should replay the round, counter must not move up so maybe use if(!draw)
- Possibly
- Use exception handling for when user puts a selection to avoid incorrect choices?
 */


import java.util.Objects;
import java.util.ArrayList;

public class Game {
    int round = 0;
    int maxRound = 0;
    User user;
    Computer computer;

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


            String userSelection = user.select();
            String compSelection = computer.select();

            if (userSelection.equals(compSelection)) {
                System.out.println("Draw, please try again");
                userSelection = user.select();
                compSelection = computer.select();
            }

            //user win condition
            if ((userSelection.equals("rock") && compSelection.equals("scissors")) ||
                    (userSelection.equals("paper") && compSelection.equals("rock")) ||
                    (userSelection.equals("scissors") && compSelection.equals("paper"))

            ){
                System.out.println( user.getName() + " win! " + userSelection + " beats " + compSelection);
                user.win();
            }

            //computer selection
            if ( (userSelection.equals("rock") && compSelection.equals("paper"))||
                    (userSelection.equals("paper") && compSelection.equals("scissors"))||
                    (userSelection.equals("scissors") && compSelection.equals("rock"))
            ){
                System.out.println( "You lose! " + compSelection + " beats " + userSelection);
                computer.win();
            }

            round++;
        }

        public




    }




}
