package com.company.CLI;

import com.company.GUI.WordleModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordleCLI {
    private static int numberOfTries = 6;
    private static String guess = null;

    private static void userInput() {

    }

    private static void playAgain(WordleModel wordleModel, String message){
        System.out.println(message);
        System.out.print("Play again? Yes - No\n");
        String answer = new Scanner(System.in).nextLine().toLowerCase();
        if (answer.equals("yes")) {
            wordleModel.startOver();
            play();
        } else {
            System.exit(0);
        }
    }

    private static void play() {
        WordleModel wordleModel = new WordleModel();
        String availableLetters = "qwertyuiopasdfghjklzxcvbnm";
        ArrayList<String> correctLetters = new ArrayList<>();
        ArrayList<String> existingLetters = new ArrayList<>();
        ArrayList<String> nonExistingLetters = new ArrayList<>();

        while (!wordleModel.getVictory() || !wordleModel.getGameOver()) {
            System.out.printf("Letters available - %s\n", availableLetters);
            System.out.printf("Correctly guessed letters: %s\n", correctLetters);
            System.out.printf("Guessed letters in the word: %s\n", existingLetters);
            System.out.printf("Guessed letters not in the word: %s\n", nonExistingLetters);
            System.out.printf("You have %d tries left.\n\n", numberOfTries);

            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("5 letter word guess: ");
                guess = scanner.nextLine();
            } while (guess.length() != 5);

            for (int i = 0; i < guess.length(); i++) {
                wordleModel.addLetter(String.valueOf(guess.charAt(i)));
            }

            wordleModel.processWord();
        }
        if (wordleModel.getVictory()) {
            playAgain(wordleModel, "Congratulations! You've Won!");
        } else if (wordleModel.getGameOver()) {
            playAgain(wordleModel, "The word was \"" + wordleModel.getTargetWord() + "\"");
        } else if (wordleModel.getNoWordFlagFound()) {
            System.out.print("Not in word list.");
        }

        System.out.println(Arrays.deepToString(wordleModel.getBackgroundColors()));
        System.out.println(Arrays.deepToString(wordleModel.getLetters()));



    }

    public static void main(String[] args) {
        play();
    }
}
