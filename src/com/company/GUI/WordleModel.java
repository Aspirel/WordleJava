package com.company.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordleModel extends Observable {
    private boolean noWordFoundFlag;
    private boolean displayWordFlag;
    private boolean randomWordFlag;
    private boolean gameOver;
    private boolean notEnoughLetters;
    private String targetWord;
    private String[][] letters;
    private Color[][] backgroundColors;
    private Color[][] borderColors;
    private HashMap<String, Color> buttonColors;
    private ArrayList<String> allWords;
    private ArrayList<String> allTargetWords;
    private int row;
    private int col;

    public WordleModel() {
        init();
    }

    private void init() {
        gameOver = false;
        notEnoughLetters = false;
        noWordFoundFlag = false; //word does not exist in the list of words
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
        assert !allTargetWords.isEmpty();
        Random random = new Random();

        //If the flag for random words is enabled, it gets a random one, otherwise, gets a fixed word(first one).
        //How to choose the fixed word was not specified on the course work, only that it must be fixed, therefore
        //the first of the list is chosen.
        targetWord = randomWordFlag ? allTargetWords.get(random.nextInt(allTargetWords.size())) :
                allTargetWords.get(0);

        //Displays the word immediately if this flag is enabled.
        if (displayWordFlag) {
            for (int i = 0; i < targetWord.length(); i++) {
                letters[row][i] = String.valueOf(targetWord.charAt(i));
            }
            setChanged();
            notifyObservers();
        }
    }

    //This method checks if the typed word exists in the lists, if the letters are at the correct locations
    //and colors everything accordingly.
    public void processWord() {
        String message = null;
        if (!gameOver) {
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                if (letters[row][i] != null) {
                    word.append(letters[row][i].toLowerCase());
                }
            }

            if (word.length() < 5) {
                //Additional flag to display a message if the word does not have enough letters.
                notEnoughLetters = true;
            } else if (!allWords.contains(String.valueOf(word)) && !allTargetWords.contains(String.valueOf(word))) {
                //If the word doesn't exist, the view is notified and a message is displayed to the user.
                //Following the requirements. However, we could simply directly send a boolean or string
                //to the observer as an arg, without any flag in the model.
                noWordFoundFlag = true;
            } else {
                assert !word.isEmpty();
                assert !allWords.isEmpty();
                //if the typed word exists in the words lists
                //if it equals the target word, its game over immediately
                if (targetWord.equals(String.valueOf(word))) {
                    for (int i = 0; i < word.length(); i++) {
                        backgroundColors[row][i] = Color.green;
                        borderColors[row][i] = Color.green;
                        buttonColors.put(String.valueOf(word.charAt(i)), Color.green);
                        gameOver = true;
                    }
                    //Passes the message as an argument to the observer.
                    message = "Congratulations! You've Won!";
                } else {
                    for (int i = 0; i < word.length(); i++) {
                        //checks typed word char by char
                        String s = String.valueOf(word.charAt(i)).toLowerCase();
                        //if it is the same char as the target word and is at the right index,
                        //paints everything green. If it's in the word but not right position yellow,
                        //and gray if not in the word at all.
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
                //Increases the row by one to go to second line and resets the column to 0 for the text
                //field to be the 1st one on the row.
                row++;
                col = 0;
            }
        }

        //After the word checks and colouring, if the last text box of the last row is full,
        //it means the game is over either way. It informs the user the game is over and displays the target word.
        if (letters[5][4] != null) {
            gameOver = true;
            message = "The word was \"" + targetWord + "\"";
        }

        setChanged();
        notifyObservers(message);
        noWordFoundFlag = false;
        notEnoughLetters = false;
    }

    //Method that adds the typed letter to the text boxes. With a 2d array, I simply add the letter
    //column by column and row once the columns are full. It checks the game is not over and the row
    //is not full, adds the letter to column and increases it by 1. Since when a column text is deleted
    //the col is decrease by 1, when we try to increase again we check if the current index text is null,
    //and it will never be. Therefore, we have the col + 1 portion checking for that.
    public void addLetter(ActionEvent a, KeyEvent k) {
        if (!gameOver && letters[row][4] == null) {
            if (letters[row][col] == null) {
                letters[row][col] = String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()).toUpperCase();
                borderColors[row][col] = Color.black;
                if (col < 4) col++;
            } else if (letters[row][col + 1] == null) {
                letters[row][col + 1] = String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()).toUpperCase();
                borderColors[row][col + 1] = Color.black;
                if (col < 4) col++;
            }
        }
        setChanged();
        notifyObservers();
    }

    //This delete method is an exact replica of the addLetter method, but backwards.
    public void deleteLetter() {
        if (!gameOver && letters[row][0] != null) {
            if (letters[row][col] != null) {
                letters[row][col] = null;
                borderColors[row][col] = null;
                if (col - 1 >= 0) col--;
            } else if (letters[row][col - 1] != null) {
                letters[row][col - 1] = null;
                borderColors[row][col - 1] = null;
                col--;
            }
        }
        setChanged();
        notifyObservers();
    }

    //Restarts the board by running the init method and resetting everything.
    public void startOver() {
        if (row > 0) init();
        setChanged();
        notifyObservers();
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

    public boolean getNoWordFlagFound() {
        return noWordFoundFlag;
    }

    public boolean getNotEnoughLetters() {
        return notEnoughLetters;
    }
}