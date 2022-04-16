package com.company.CLI;

import com.company.GUI.WordleModel;

import java.util.Scanner;

public class WordleCLI {
    public static void main(String[] args) {
        WordleModel wordleModel = new WordleModel();
        int numberOfTries = 6;

        String availableLetters = "qwertyuiopasdfghjklzxcvbnm";
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Letters available - %s\n", availableLetters);
        System.out.printf("You have %d tries left.\n", numberOfTries);
        System.out.print("Guess: ");
        String guess = scanner.nextLine();
        System.out.println("Congratulations! You've Won!");
        System.out.println("Play again? Yes - No");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("yes")) {
            wordleModel.startOver();
        } else {
            System.exit(0);
        }
    }
}
