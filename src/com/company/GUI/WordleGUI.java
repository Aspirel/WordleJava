package com.company.GUI;

public class WordleGUI {
    public static void main(String[] args) {
        WordleModel wordleModel = new WordleModel();
        WordleView wordleView = new WordleView(wordleModel);
        wordleModel.addObserver(wordleView);
        WordleController wordleController = new WordleController(wordleModel, wordleView);
        wordleView.setVisible(true);
    }
}
