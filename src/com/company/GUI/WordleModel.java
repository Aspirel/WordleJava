package com.company.GUI;

public class WordleModel {
    private boolean correctWord;

    public void checkWord(String word1, String word2){
        correctWord = word1.equals(word2);
    }

    public boolean getCorrectWord(){
        return correctWord;
    }
}
