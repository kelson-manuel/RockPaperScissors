/*
App file should call game, Game calls computer and user
    - If game is over maybe print a table score as Sarita suggested?
    -
 */
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        User user1 = new User();
        Computer comp1 = new Computer();
        System.out.println("Welcome to the game of rock paper scissors");
        System.out.println("How many rounds do you want to play?");
        Scanner scanner = new Scanner(System.in);

        int numRounds = scanner.nextInt();
        Game game1 = new Game(numRounds,user1, comp1);

        game1.playGame();
    }
}
