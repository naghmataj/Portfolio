import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int MIN_RANGE = 1;
        final int MAX_RANGE = 100;
        final int MAX_ATTEMPTS = 7; // Limiting the number of attempts
        int totalRounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Guess the Number game!");

        boolean playAgain = true;
        while (playAgain) {
            totalRounds++;
            int numberToGuess = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + totalRounds + ":");
            System.out.println("Guess the number between " + MIN_RANGE + " and " + MAX_RANGE + ".");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            totalAttempts += attempts;

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame over! You played " + totalRounds + " rounds with an average of " + ((double) totalAttempts / totalRounds) + " attempts per round.");

        scanner.close();
    }
}