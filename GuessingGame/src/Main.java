import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int min = 1;
        int max = 20;
        int cpuRandom = (int)Math.floor(Math.random() * (max-min + 1) + min);

        String player;
        byte guess;
        byte count = 1;

        String playAgain = "";

        System.out.println("Hello! What is your name?");
        player = scan.next();

        System.out.println(
            "Well, " + player + " I am thinking of a number between 1 and 20. \n" +
            "You have 6 tries to get it right. Take a guess."
        );

        try {
            do {
                System.out.print("Guess " + count + ": ");
                guess = scan.nextByte();
                if (guess > 0 && guess < 21) {
                    if (guess == cpuRandom) {
                        System.out.println(
                                "Good job, " + player + "! You guessed my number in " + count + " guesses! \n" +
                                "Would you like to play again? (y or n)"
                        );
                        count = 1;
                        playAgain = scan.next();
                        if (playAgain.equalsIgnoreCase("n"))
                            break;
                    } else if (guess < cpuRandom) {
                        System.out.println("Your guess is too low.\n Guess again.");
                        count++;
                    } else if (guess > cpuRandom) {
                        count++;
                        System.out.println("Your guess is too high.\n Guess again.");
                    }
                    if (count > 6) {
                        System.out.println("Sorry, you lose! Play again? (y or n)");
                        count = 1;
                        playAgain = scan.next();
                        if (playAgain.equalsIgnoreCase("n"))
                            break;
                    }
                } else {
                    System.out.println("Number must be between 1 and 20.");
                }
            } while (playAgain.equalsIgnoreCase("y") || guess != cpuRandom);
        } catch (Exception e) {
            System.out.println("Must enter a number between 1 and 20.");
        }
    }
}
