/*
App file should call game, Game calls computer and user
    - If game is over maybe print a table score as Sarita suggested?
    -
 */

public class App {
    public static void main(String[] args) {
        User user1 = new User();
        Computer comp1 = new Computer();
        Game game1 = new Game(4,user1, comp1);

        game1.playGame();
    }
}
