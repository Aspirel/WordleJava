package com.company.CLI;

import com.company.GUI.WordleModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class WordleCLIDisplays implements Observer {
    private final WordleModel wordleModel;
    private final String availableLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private final ArrayList<String> correctLetters = new ArrayList<>();
    private final ArrayList<String> existingLetters = new ArrayList<>();
    private final ArrayList<String> nonExistingLetters = new ArrayList<>();
    private int numberOfTries = 6;

    WordleCLIDisplays(WordleModel wordleModel) {
        this.wordleModel = wordleModel;
//        play();
    }

    public void play() {
        String guess;
        System.out.println(wordleModel.getTargetWord());

        while (!wordleModel.getVictory() || !wordleModel.getGameOver()) {
            System.out.printf("Available letters: %s\n", availableLetters);
            System.out.printf("Correctly positioned letters: %s\n", correctLetters);
            System.out.printf("Correctly guessed letters: %s\n", existingLetters);
            System.out.printf("Letters not in the word: %s\n", nonExistingLetters);
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
            numberOfTries -= 1;
        }
    }

    private void playAgain(WordleModel wordleModel, String message) {
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

    @Override
    public void update(Observable o, Object arg) {
        if (wordleModel.getVictory()) {
            playAgain(wordleModel, "Congratulations! You've Won!");
        } else if (wordleModel.getGameOver()) {
            playAgain(wordleModel, "Game Over! The word was \"" + wordleModel.getTargetWord() + "\"");
        } else if (wordleModel.getNoWordFlagFound()) {
            System.out.println("\n--- Not in word list. ---\n");
            //resets the row to empty. Row is being monitored in the model.
            for (int i = 0; i < 5; i++) {
                wordleModel.deleteLetter();
            }
            numberOfTries += 1;
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
        }
    }
}
