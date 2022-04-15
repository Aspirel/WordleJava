package com.company.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordleModel extends Observable {
    private boolean noWordFlag;
    private boolean displayWordFlag;
    private boolean randomWordFlag;
    private boolean gameOver;
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
        noWordFlag = false; //word does not exist in the list of words
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
        //How to choose the fixed word was not specified in the course work, only that it must be fixed, therefore
        //the first of the list is the one.
        targetWord = randomWordFlag ? allTargetWords.get(random.nextInt(allTargetWords.size())) :
                allTargetWords.get(0);

        if (displayWordFlag) {
            for (int i = 0; i < targetWord.length(); i++) {
                letters[row][i] = String.valueOf(targetWord.charAt(i));
            }
            setChanged();
            notifyObservers();
        }
        System.out.println(targetWord); //DELETE THIS AFTER
    }

    public void processWord() {
        if (!gameOver) {
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                if (letters[row][i] != null) {
                    word.append(letters[row][i].toLowerCase());
                }
            }

            assert !word.isEmpty();
            assert !allWords.isEmpty();
            if (allWords.contains(String.valueOf(word)) || allTargetWords.contains(String.valueOf(word))) {
                if (targetWord.equals(String.valueOf(word))) {
                    for (int i = 0; i < word.length(); i++) {
                        backgroundColors[row][i] = Color.green;
                        borderColors[row][i] = Color.green;
                        buttonColors.put(String.valueOf(word.charAt(i)), Color.green);
                        gameOver = true;
                    }
                } else {
                    for (int i = 0; i < 5; i++) {
                        String s = String.valueOf(word.charAt(i)).toLowerCase();
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
                setChanged();
                notifyObservers();
                row++;
                col = 0;
            } else {
                noWordFlag = true;
                setChanged();
                notifyObservers(noWordFlag);
            }
        }
    }

    public void addLetter(ActionEvent a, KeyEvent k) {
        if (!gameOver && letters[row][4] == null) {
            if (letters[row][col] == null) {
                letters[row][col] = String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                borderColors[row][col] = Color.black;
                if (col < 4) col++;
            } else if (letters[row][col + 1] == null) {
                letters[row][col + 1] = String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                borderColors[row][col + 1] = Color.black;
                if (col < 4) col++;
            }
        }
        setChanged();
        notifyObservers();
    }

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

    public void startOver() {
        init();
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
}