package randomNumberGameconsole;

import java.util.*;

public class RandomNumberGamecon {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // initialize the data
        int random = (int) (Math.random() * 100) + 1;
        boolean guess = false;
        int attempt = 1;
        System.out.println("-------------NUMBER GAME---------------");
        System.out.println("Rules");
        System.out.println("--> Guess the Number between 1 and 100" + "\n--> You have 5 attempts");

        while (!guess && attempt <= 10) { 
            System.out.print("Attempt " + attempt + ": "); 
            // user guesses
            int userguess = sc.nextInt();
            if (userguess == random) {
                guess = true;
            } else {
                attempt++;
                if (userguess > random) {
                    System.out.println("The number you guessed is too High"); 
                } else {
                    System.out.println("The number you guessed is too Low"); 
                }
            }
        }
        int calculate_score = attempt*10;
        if (guess) {
            System.out.println("Congratulations! You guessed correctly! The number was " + random+" and your score is "+calculate_score);
        } else {
            System.out.println("Sorry, your attempts are finished. The correct answer was " + random);
        }
    }

}
