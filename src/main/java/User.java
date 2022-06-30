/*
Methods:
- setName to set name for user
- getName to get user name
- getScore to get user score
- select(selection) for user to input their selection
 */

import java.util.Locale;
import java.util.Scanner;

public class User {
    String name;
    int score = 0;
    Scanner scanner = new Scanner(System.in);
//    public User(String name) {
//        this.name = name;
//    }

    //set name of user
    public void setName() {
        System.out.println("Please input a name");
        name = scanner.nextLine();
        System.out.println(name + " has been added!");
    }

    public String getName() {
        return this.name;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }
    // prompt user selection
    public String select() {
        System.out.println("--------  "+name + " turn. Enter selection  -------- ");
        String selection;
        //convert any capitals to lowercase for comparison
        while (true) {
            selection = scanner.nextLine().toLowerCase();
            if (validateInput(selection)) {
                break;
            }
            System.out.println("uh oh wrong inputm try again!");
        }
        return selection;

    }

    public boolean validateInput(String selection) {
        String[] choices = {"rock", "paper", "scissors"};
        for (String choice : choices) {
            if (selection.equals(choice)) {
                return true;
            }
        }
        return false;
    }

    //increment score
    public void win() {
        this.score++;
    }

    //decrement score
    public void lose() {
        this.score--;
    }


}


