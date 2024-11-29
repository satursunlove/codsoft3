import java.util.Random;
import java.util.Scanner;

public class NUMBERGAME {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Guessing Game!");

        while (playAgain) {
            System.out.println("\n--- New Round ---");
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between 1 and 100. You have 10 attempts!");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.printf("Attempt %d/%d: Enter your guess: ", attempts + 1, maxAttempts);
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();
            String playAgainInput = scanner.nextLine().trim().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }
}
