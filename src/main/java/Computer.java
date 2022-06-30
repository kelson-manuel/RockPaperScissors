/* Requirements
1. Generate a number
2. Select a selection
3. Keep track of computer score

 */

import java.util.Random;

public class Computer {
    int score;

    String[] choices = {"rock", "paper", "scissors"};

    //computer selection
    public String select() {
        System.out.println("--------  Computer's turn  -------- ");
        Random rand = new Random();
        int randomSelection = rand.nextInt(3);
        return choices[randomSelection];
    }

    //increment score
    public void win() {
        this.score++;
    }
    public int getScore() {
        return this.score;
    }
    //decrement score
}



