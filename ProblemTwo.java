import java.util.Random;
import java.util.Scanner;

public class ProblemTwo {
    public static void main(String[] args) {
        // Array of words for the Hangman game
        String[] words = {
            "apple", "banana", "chocolate", "elephant", "giraffe",
            "computer", "programming", "hangman", "keyboard", "monitor",
            "ocean", "mountain", "sunshine", "rainbow", "penguin",
            "music", "guitar", "piano", "violin", "trumpet",
            "coffee", "tea", "juice", "sandwich", "pizza",
            "library", "bookstore", "university", "school", "classroom",
            "basketball", "football", "soccer", "baseball", "tennis",
            "doctor", "nurse", "patient", "hospital", "medicine",
            "butterfly", "flower", "breeze", "butter", "honey",
            "vacation", "adventure", "exploration", "journey", "discovery",
            "fireworks", "celebration", "party", "cake", "candle",
            "camera", "photograph", "memory", "album", "picture",
            "dog", "cat", "rabbit", "hamster", "goldfish",
            "star", "planet", "galaxy", "universe", "telescope",
            "painting", "canvas", "brush", "palette", "art",
            "rain", "thunderstorm", "lightning", "cloud", "umbrella",
            "ballet", "dance", "performance", "stage", "costume",
            "clock", "watch", "time", "hour", "minute",
            "wallet", "money", "coin", "banknote", "cash",
            "friendship", "laughter", "happiness", "smile", "kindness",
            "bridge", "river", "stream", "waterfall", "island",
            "breeze", "whisper", "gentle", "calm", "serene"
        };

        Random random = new Random(); // Initialize a random number generator
        int index = random.nextInt(words.length); // Generate a random index to select a word from the array
        String randomWord = words[index];
        StringBuilder userString = new StringBuilder("*".repeat(randomWord.length())); // Create a StringBuilder to represent the user's progress with asterisks
        Scanner input = new Scanner(System.in);
        int attempts = 10;  // Set the number of attempts

        System.out.println("Welcome to Hangman!");
        while (attempts > 0 && !userString.toString().equals(randomWord)) {
            System.out.println("Current word: " + userString); // Display the current state of the word with asterisks
            System.out.printf("Attempts left: %d\n", attempts);  // Display the remaining attempts
            System.out.print("Enter a letter: ");
            String userInput = input.next().toLowerCase(); // Read user input and convert it to lowercase

            if (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {  // Check if the input is a single letter
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guessedLetter = userInput.charAt(0);  // Get the guessed letter
            boolean found = false;

            for (int i = 0; i < randomWord.length(); i++) {  // Loop through the letters in the random word
                // Check if the guessed letter matches a letter in the word and if the corresponding position in the user's progress is an asterisk
                if (randomWord.charAt(i) == guessedLetter && userString.charAt(i) == '*') {
                    userString.setCharAt(i, guessedLetter);
                    found = true;
                }
            }

            if (!found) { // If the guessed letter was not found in the word, decrement the attempts
                System.out.println("Incorrect guess.");
                attempts--;
            }
        }

        if (userString.toString().equals(randomWord)) { // Check if the user has guessed the word or ran out of attempts
            System.out.println("Congratulations! You guessed the word: " + randomWord);
        } else {
            System.out.println("Out of attempts. The word was: " + randomWord);
        }

        input.close(); // Close the input scanner
    }
}
