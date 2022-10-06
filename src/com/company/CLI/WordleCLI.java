package com.company.CLI;

import com.company.GUI.WordleModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordleCLI {

    public static class WordleCLIDisplay {

        WordleCLIDisplay() {
            play();
        }

        private void play() {
            WordleModel wordleModel = new WordleModel();

            //If the array has a letter on 1st column and row, that means the display word flag is enabled,
            //and it was added to the array in the model. There is no need to have a getter for the flag.
            //Target word is already public to display a game over message, therefore can be used here as well.
            //There is also no information on what to do after displaying it, so it just displays with no game play.
            if (wordleModel.getLetters()[0][0] != null) {
                System.out.println(wordleModel.getTargetWord());
            } else {
                ArrayList<String> availableLetters = new ArrayList<>(Arrays.asList("Q", "W", "E", "R", "T", "Y", "U",
                        "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"));
                ArrayList<String> correctLetters = new ArrayList<>(Arrays.asList("-", "-", "-", "-", "-"));
                ArrayList<String> existingLetters = new ArrayList<>();
                ArrayList<String> nonExistingLetters = new ArrayList<>();
                int numberOfTries = 6;
                String guess;

                //while a correct word isn't found or the game is over due to being lost
                while (!wordleModel.getVictory() || !wordleModel.getGameOver()) {
                    System.out.printf("Usable letters: %s\n", availableLetters);
                    System.out.printf("Correctly positioned letters: %s\n", correctLetters.toString().replace(",", ""));
                    System.out.printf("Letters present in the word: %s\n", existingLetters);
                    System.out.printf("Letters not in the word: %s\n", nonExistingLetters);
                    System.out.printf("You have %d tries left.\n\n", numberOfTries);

                    //since only 5 letter words are accepted, this controls it in a loop and there is no need
                    //to have a not enough and too many letters checks.
                    Scanner scanner = new Scanner(System.in);
                    do {
                        System.out.print("5 letter word guess: ");
                        guess = scanner.nextLine();
                    } while (guess.length() != 5);

                    for (int i = 0; i < guess.length(); i++) {
                        wordleModel.addLetter(String.valueOf(guess.charAt(i)));
                    }

                    //checks the word
                    wordleModel.processWord();

                    if (wordleModel.getVictory()) {
                        playAgain(wordleModel, "Congratulations! You've Won!");
                    } else if (wordleModel.getGameOver()) {
                        playAgain(wordleModel, "Game Over! The word was \"" + wordleModel.getTargetWord() + "\"");
                    } else if (wordleModel.getNoWordFound()) {
                        System.out.println("\n--- Not in word list. ---\n");
                        //resets the row to empty. Row is being monitored in the model.
                        for (int i = 0; i < 5; i++) {
                            wordleModel.deleteLetter();
                        }
                        numberOfTries += 1;
                    } else {
                        //This represents the colouring of the letters by adding them to specific lists.
                        String[][] letters = wordleModel.getLetters();
                        Color[][] backgroundColors = wordleModel.getBackgroundColors();
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (backgroundColors[i][j] != null) {
                                    if (backgroundColors[i][j].equals(Color.green)) {
                                        correctLetters.set(j, letters[i][j]);
                                    } else if (backgroundColors[i][j].equals(Color.yellow)) {
                                        if (!existingLetters.contains(letters[i][j])) {
                                            existingLetters.add(letters[i][j]);
                                        }
                                    } else {
                                        if (!nonExistingLetters.contains(letters[i][j])) {
                                            nonExistingLetters.add(letters[i][j]);
                                        }
                                        /* This also removes the letters that are not part of the guess word from
                                         * the all available letters list, similar to the graying out of letters on
                                         * the digital keyboard.
                                         */
                                        availableLetters.remove(String.valueOf(letters[i][j]));
                                    }
                                }
                            }
                        }
                    }
                    numberOfTries -= 1;
                }
            }
        }

        /**
         * Function that displays a message of the previous outcome of the game and asks the user if he wants to
         * play again.
         *
         * @param wordleModel the model
         * @param message     Displays the outcome of the previous attempt to the user.
         */
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
    }

    public static void main(String[] args) {
        new WordleCLIDisplay();
    }
}