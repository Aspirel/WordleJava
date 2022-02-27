package com.company.GUI;

public class WordleGUI {
    public static void main(String[] args) {
        WordleView wordleView = new WordleView();
        WordleModel wordleModel = new WordleModel(wordleView);
        WordleController wordleController = new WordleController(wordleModel, wordleView);
        wordleView.setVisible(true);
    }
}
