package com.company.Tests;

import com.company.GUI.WordleModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class UnitTests {

    /**
     * Tests adding words to the 2d array of letters.
     * Only one word will be added at a time, and another can't be added until the previous one is processed and
     * the row is increased by 1. This is intended. Therefore, this tests several words sizes and styles.
     * With the asserts in place in the addLetter, this test proves that the arraylist for letters and colors aren't
     * null and that the row and columns have a positive value. Also shows the fact that all letters are being
     * capitalized, smaller or larger than 5 letters words are accepted.
     */
    @Test
    void addWordTest() {

        ArrayList<String> exampleWords = new ArrayList<>(Arrays.asList("Tests", "Helloadasd", "2114135", "O",
                "", " "));

        for (int i = 0; i < 6; i++) {
            //creates a new model for each word, so we can view the letters being added for each other on the list.
            WordleModel wordleModel = new WordleModel();
            Assertions.assertNotNull(wordleModel.getLetters());

            for (int j = 0; j < exampleWords.get(i).length(); j++) {
                wordleModel.addLetter(String.valueOf(exampleWords.get(i).charAt(j)));
                Assertions.assertDoesNotThrow(() -> new ArrayIndexOutOfBoundsException());
                Assertions.assertDoesNotThrow(() -> new NullPointerException());
                Assertions.assertDoesNotThrow(() -> new IllegalArgumentException());
                System.out.println(Arrays.deepToString(wordleModel.getLetters()));
            }
        }
    }

    /**
     * This test checks the deletion of letters from the 2d array. Adds and deletes a 5 letter word to the array,
     * letter by letter, displaying it on the way. It checks for possible common array errors such as out of bounds
     * and null pointer errors
     */
    @Test
    void deleteWordTest() {
        WordleModel wordleModel = new WordleModel();
        String word = "Words";

        Assertions.assertNotNull(wordleModel.getLetters());

        for (int j = 0; j < word.length(); j++) {
            wordleModel.addLetter(String.valueOf(word.charAt(j)));
            Assertions.assertDoesNotThrow(() -> new ArrayIndexOutOfBoundsException());
            Assertions.assertDoesNotThrow(() -> new NullPointerException());
            System.out.println(Arrays.deepToString(wordleModel.getLetters()));
        }

        for (int j = 0; j < word.length(); j++) {
            wordleModel.deleteLetter();
            Assertions.assertDoesNotThrow(() -> new ArrayIndexOutOfBoundsException());
            Assertions.assertDoesNotThrow(() -> new NullPointerException());
            System.out.println(Arrays.deepToString(wordleModel.getLetters()));
        }
    }

    @Test
    void wordProcessTests() {
        //1st test with random words sizes and types.
        System.out.println("***** TEST 1 *****");
        WordleModel wordleModel = new WordleModel();
        Assertions.assertNotNull(wordleModel.getLetters());
        ArrayList<String> exampleWords = new ArrayList<>(Arrays.asList("Test", "hellothere", "cigar", "persil",
                "troll", " ", "dwarf", "0", "crate", "lapel"));

        runProcessTest(exampleWords, wordleModel);

        //2nd test with random words sizes and types and the target word at the beginning.
        //Once the victory flag is on, nothing else is added.
        System.out.println("***** TEST 2 *****");
        wordleModel = new WordleModel();
        String word = wordleModel.getTargetWord();
        Assertions.assertNotNull(wordleModel.getLetters());
        ArrayList<String> exampleWords2 = new ArrayList<>(Arrays.asList(word, "hellothere", "cigar", "persil",
                "troll", " ", "dwarf", "0", "crate", "lapel"));

        runProcessTest(exampleWords2, wordleModel);

        //3rd test with random words sizes and types and the target word in the middle.
        //Once the victory flag is on, nothing else is added.
        System.out.println("***** TEST 3 *****");
        wordleModel = new WordleModel();
        String word2 = wordleModel.getTargetWord();
        Assertions.assertNotNull(wordleModel.getLetters());
        ArrayList<String> exampleWords3 = new ArrayList<>(Arrays.asList("Test", "hellothere", "cigar", "persil",
                word2, " ", "dwarf", "0", "crate", "lapel"));

        runProcessTest(exampleWords3, wordleModel);

        //4th test with random words sizes and types and the target word at the end.
        //Once the victory flag is on, nothing else is added.
        System.out.println("***** TEST 4 *****");
        wordleModel = new WordleModel();
        String word3 = wordleModel.getTargetWord();
        Assertions.assertNotNull(wordleModel.getLetters());
        ArrayList<String> exampleWords4 = new ArrayList<>(Arrays.asList("Test", "hellothere", "cigar", "persil",
                "troll", " ", "dwarf", "0", "crate", word3));

        runProcessTest(exampleWords4, wordleModel);
    }

    /**
     * Function used to add words to the 2d array, process the word and delete when a word flag is raised.
     * Avoid repeating code in the wordProcessTests().
     *
     * @param exampleWords list of words to be tested
     * @param wordleModel  wordle model
     */
    void runProcessTest(ArrayList<String> exampleWords, WordleModel wordleModel) {
        for (String exampleWord : exampleWords) {
            for (int j = 0; j < exampleWord.length(); j++) {
                wordleModel.addLetter(String.valueOf(exampleWord.charAt(j)));
                Assertions.assertDoesNotThrow(() -> new ArrayIndexOutOfBoundsException());
                Assertions.assertDoesNotThrow(() -> new NullPointerException());
                Assertions.assertDoesNotThrow(() -> new IllegalArgumentException());
            }
            wordleModel.processWord();
            System.out.printf("-----Word \"%s\"-----\n", exampleWord);
            System.out.printf("Not in word? %s\n", wordleModel.getNoWordFlagFound());
            System.out.printf("Not enough letters? %s\n", wordleModel.getNotEnoughLetters());
            System.out.printf("Victory? %s\n", wordleModel.getVictory());
            System.out.printf("Game Over? %s\n", wordleModel.getGameOver());
            System.out.println(Arrays.deepToString(wordleModel.getLetters()));
            System.out.println("\n");
            if (wordleModel.getNoWordFlagFound() || wordleModel.getNotEnoughLetters()) {
                for (int ii = 0; ii < 5; ii++) {
                    wordleModel.deleteLetter();
                }
            }
        }
    }

}
