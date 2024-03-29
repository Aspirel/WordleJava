package com.company.GUI;

import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordleModel extends Observable {
    private boolean checkWordFoundFlag, gameOver, victory, notEnoughLetters, noWordFound,
            displayWordFlag, randomWordFlag;
    private String targetWord;
    private String[][] letters;
    private Color[][] backgroundColors, borderColors;
    private HashMap<String, Color> buttonColors;
    private ArrayList<String> allWords, allTargetWords;
    private int row, col;

    public WordleModel() {
        init();
    }

    private void init() {
        gameOver = false;
        victory = false;
        notEnoughLetters = false;
        noWordFound = false;
        checkWordFoundFlag = true; //allows or not words that are not on the list
        displayWordFlag = false; //enable to display the target word immediately in the GUI
        randomWordFlag = true; //enable to pick random target words. Disable to always pick a fixed one.
        targetWord = null;
        letters = new String[6][5];
        backgroundColors = new Color[6][5];
        borderColors = new Color[6][5];
        buttonColors = new HashMap<>();
        allWords = new ArrayList<>();
        allTargetWords = new ArrayList<>();
        row = 0;
        col = 0;

        //Reads both text files with all the words.
        try {
            Scanner scanner = new Scanner(new File("src/com/company/Resources/common.txt"));
            Scanner scanner2 = new Scanner(new File("src/com/company/Resources/words.txt"));
            while (scanner.hasNextLine()) {
                allTargetWords.add(scanner.nextLine());
            }
            scanner.close();
            while (scanner2.hasNextLine()) {
                allWords.add(scanner2.nextLine());
            }
            scanner2.close();
        } catch (FileNotFoundException e) {
            System.out.printf("File not found %s", e);
        }

        Assertions.assertFalse(allTargetWords.isEmpty());

        /*
         * If the flag for random words is enabled, it gets a random one, otherwise, gets a fixed word(first one).
         * How to choose the fixed word was not specified on the course work, only that it must be fixed, therefore
         * the first of the list is chosen.
         */
        Random random = new Random();
        targetWord = randomWordFlag ? allTargetWords.get(random.nextInt(allTargetWords.size())) :
                allTargetWords.get(0);

        Assertions.assertFalse(targetWord.isEmpty());
        //Displays the word immediately if this flag is enabled. There is no information on how to display it
        //or what should happen after displaying, so it simply displays the word on the GUI with no
        //actual gameplay.
        if (displayWordFlag) {
            for (int i = 0; i < targetWord.length(); i++) {
                letters[row][i] = String.valueOf(targetWord.charAt(i));
            }
            setChanged();
            notifyObservers();
        }
    }

    /**
     * This method checks if the typed word exists in the lists, if the letters are at the correct locations
     * and colors everything accordingly.
     */
    public void processWord() {
        if (!gameOver && !victory) {
            StringBuilder word = new StringBuilder();

            for (int i = 0; i < 5; i++) {
                if (letters[row][i] != null) {
                    word.append(letters[row][i].toLowerCase());
                }
            }

            Assertions.assertNotNull(word);
            Assertions.assertFalse(allWords.isEmpty());
            Assertions.assertFalse(targetWord.isEmpty());
            Assertions.assertFalse(allTargetWords.isEmpty());
            Assertions.assertTrue(row >= 0);
            Assertions.assertTrue(col >= 0);

            if (word.length() < 5) {
                //Additional flag to display a message if the word does not have enough letters.
                notEnoughLetters = true;
            } else if (checkWordFoundFlag && (!allWords.contains(String.valueOf(word)) &&
                    !allTargetWords.contains(String.valueOf(word)))) {
                //If the word doesn't exist, the view is notified and a message is displayed to the user.
                noWordFound = true;
            } else {
                //If it equals the target word, its game over immediately
                if (targetWord.equals(String.valueOf(word))) {
                    for (int i = 0; i < word.length(); i++) {
                        backgroundColors[row][i] = Color.green;
                        borderColors[row][i] = Color.green;
                        buttonColors.put(String.valueOf(word.charAt(i)), Color.green);
                    }
                    victory = true;
                } else {
                    for (int i = 0; i < word.length(); i++) {
                        //checks typed word char by char
                        String s = String.valueOf(word.charAt(i)).toLowerCase();
                        /* If it is the same char as the target word and is at the right index,
                         * paints everything green. If it's in the word but not right position yellow,
                         * and gray if not in the word at all.
                         */
                        if (s.equals(String.valueOf(targetWord.charAt(i)))) {
                            backgroundColors[row][i] = Color.green;
                            borderColors[row][i] = Color.green;
                            buttonColors.put(s, Color.green);
                        } else if (!s.equals(String.valueOf(targetWord.charAt(i))) &&
                                targetWord.contains(s)) {
                            backgroundColors[row][i] = Color.yellow;
                            borderColors[row][i] = Color.yellow;
                            if (!buttonColors.containsKey(s) || (buttonColors.containsKey(s) &&
                                    !buttonColors.get(s).equals(Color.green))) {
                                buttonColors.put(s, Color.yellow);
                            }
                        } else {
                            backgroundColors[row][i] = Color.gray;
                            borderColors[row][i] = Color.gray;
                            buttonColors.put(s, Color.gray);
                        }
                    }
                }
                /*Increases the row by one to go to second line and resets the column to 0 for the text
                 *field to be the 1st one on the row.
                 */
                row++;
                col = 0;

                /*After the word checks and colouring, if the last text box of the last row is full,
                 *it means the game is over. It informs the user the game is over and displays the target word.
                 */
                if (letters[5][4] != null & !victory) {
                    gameOver = true;
                }
            }
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Method that adds the typed letter to the text boxes. With a 2d array, I simply add the letter
     * column by column, and row once the columns are full. It checks the game is not over and the row
     * is not full, adds the letter to column and increases it by 1. Since when a column content is deleted
     * the col index is decrease by 1, when we try to add again we check if the target index text is null,
     * and it will never be. Therefore, we have the col + 1 portion checking for that.
     */
    public void addLetter(String character) {
        /* These flags reset here and in the deleteLetter().
         * Could have been called at the end of process word, but since the CLI is not being notified directly,
         * it must be reset everytime a new word is added or deleted.
         */
        noWordFound = false;
        notEnoughLetters = false;

        Assertions.assertTrue(row >= 0);
        Assertions.assertTrue(col >= 0);

        if (!gameOver && !victory && letters[row][4] == null) {
            if (letters[row][col] == null) {
                letters[row][col] = character.toUpperCase();
                borderColors[row][col] = Color.black;
                if (col < 4) col++;
            } else if (letters[row][col + 1] == null) {
                letters[row][col + 1] = character.toUpperCase();
                borderColors[row][col + 1] = Color.black;
                if (col < 4) col++;
            }
            setChanged();
            notifyObservers();
        }
    }

    /**
     * This delete method is an exact replica of the addLetter method, but backwards.
     */
    public void deleteLetter() {
        noWordFound = false;
        notEnoughLetters = false;

        Assertions.assertTrue(row >= 0);
        Assertions.assertTrue(col >= 0);

        if (!gameOver && !victory && letters[row][0] != null) {
            if (letters[row][col] != null) {
                letters[row][col] = null;
                borderColors[row][col] = null;
                if (col - 1 >= 0) col--;
            } else if (letters[row][col - 1] != null) {
                letters[row][col - 1] = null;
                borderColors[row][col - 1] = null;
                col--;
            }
            setChanged();
            notifyObservers();
        }
    }

    /**
     * Restarts the board by running the init method and resetting everything, once the row is > 1 (after 1st guess).
     */
    public void startOver() {
        Assertions.assertTrue(row >= 0);
        if (row > 0) {
            init();
            setChanged();
            notifyObservers();
        }
    }

    public String[][] getLetters() {
        return letters;
    }

    public Color[][] getBackgroundColors() {
        return backgroundColors;
    }

    public Color[][] getBorderColors() {
        return borderColors;
    }

    public HashMap<String, Color> getButtonColors() {
        return buttonColors;
    }

    public boolean getNoWordFound() {
        return noWordFound;
    }

    public boolean getNotEnoughLetters() {
        return notEnoughLetters;
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public boolean getVictory() {
        return victory;
    }

    //Target words has a getter simply to display a message to the user informing him of what the
    //wanted word was when the game is over (loss). Otherwise, could be private.
    public String getTargetWord() {
        return targetWord;
    }
}