package com.company.CLI;

import com.company.GUI.WordleModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleCLI {
    private static void play() {
        WordleModel wordleModel = new WordleModel();
        ArrayList<String> correctLetters = new ArrayList<>();
        ArrayList<String> existingLetters = new ArrayList<>();
        ArrayList<String> nonExistingLetters = new ArrayList<>();
        int numberOfTries = 6;
        String guess;
        System.out.println(wordleModel.getTargetWord());

        while (!wordleModel.getVictory() || !wordleModel.getGameOver()) {
            System.out.printf("Correctly positioned letters: %s\n", correctLetters);
            System.out.printf("Correctly guessed letters: %s\n", existingLetters);
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
            if (wordleModel.getVictory()) {
                playAgain(wordleModel, "Congratulations! You've Won!");
            } else if (wordleModel.getGameOver()) {
                playAgain(wordleModel, "Game Over! The word was \"" + wordleModel.getTargetWord() + "\"");
            } else if (wordleModel.getNoWordFlagFound()) {
                System.out.println("Not in word list.");
            } else {
                String[][] letters = wordleModel.getLetters();
                Color[][] backgroundColors = wordleModel.getBackgroundColors();
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (backgroundColors[i][j] != null) {
                            if (backgroundColors[i][j].equals(Color.green)) {
                                if (!correctLetters.contains(letters[i][j])) {
                                    correctLetters.add(letters[i][j]);
                                }
                            } else if (backgroundColors[i][j].equals(Color.yellow)) {
                                if (!existingLetters.contains(letters[i][j])) {
                                    existingLetters.add(letters[i][j]);
                                }
                            } else {
                                if (!nonExistingLetters.contains(letters[i][j])) {
                                    nonExistingLetters.add(letters[i][j]);
                                }
                            }
                        }
                    }
                }
                numberOfTries -= 1;
            }
        }
    }

    private static void playAgain(WordleModel wordleModel, String message) {
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

    public static void main(String[] args) {
        play();
    }
}
