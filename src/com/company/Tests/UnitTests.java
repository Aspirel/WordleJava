package com.company.Tests;

import com.company.GUI.WordleController;
import com.company.GUI.WordleModel;
import com.company.GUI.WordleView;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class UnitTests {


    @Test
    void testAddingDeletingLetter() {
        //create somehow action listeners and make it add a letter, then print out array of letters with
        //System.out.println(Arrays.deepToString(wordleModel.getLetters()));
            WordleModel wordleModel = new WordleModel();
            wordleModel.deleteLetter();
    }

    @Test
    void testLetters() {
        WordleModel wordleModel = new WordleModel();
        System.out.println(Arrays.deepToString(wordleModel.getLetters()));
    }

}
