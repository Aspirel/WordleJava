package com.company.CLI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class WordleCLIModel {
    private boolean noWordFoundFlag;
    private boolean displayWordFlag;
    private boolean randomWordFlag;
    private boolean gameOver;
    private boolean notEnoughLetters;
    private String targetWord;
    private ArrayList<String> allWords;
    private ArrayList<String> allTargetWords;

    public WordleCLIModel(){
        init();
    }

    private void init() {
        gameOver = false;
        notEnoughLetters = false;
        noWordFoundFlag = false; //word does not exist in the list of words
        displayWordFlag = true; //enable to display the target word immediately in the console.
        randomWordFlag = true; //enable to pick random target words. Disable to always pick a fixed one.
        targetWord = null;
        allWords = new ArrayList<>();
        allTargetWords = new ArrayList<>();

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
            System.out.println(targetWord);
        }
    }

    //This method checks if the typed word exists in the lists and if the letters are at the correct locations.
    //Game is over is all letters are correct
    public void processWord() {

    }

    public void addLetter() {
        Scanner scanner = new Scanner(System.in);

    }

    public void deleteLetter() {

    }

    //Restarts the board by running the init method and resetting everything.
    public void startOver() {
        init();
    }

}
