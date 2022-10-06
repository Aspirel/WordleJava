package com.company.GUI;

public class WordleGUI {
    public static void main(String[] args) {
        WordleModel wordleModel = new WordleModel();
        WordleView wordleView = new WordleView(wordleModel);
        wordleModel.addObserver(wordleView);
        new WordleController(wordleModel, wordleView);
    }
}
