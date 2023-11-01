import java.util.Random;
import java.util.Scanner;

public class number_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number within the specified range.");
                    continue;
                }

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    correctGuess = true;
                    score++;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                attempts++;
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Your score: " + score + " | Play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

