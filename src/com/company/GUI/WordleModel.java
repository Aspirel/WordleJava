package com.company.GUI;

import com.company.Utils.LineEnums;

public class WordleModel {
    private final WordleView wordleView;
    private boolean currectWord;

    public WordleModel(WordleView wordleView) {
        this.wordleView = wordleView;
    }

    public void checkLine() {
        LineEnums line = wordleView.getCurrentLine();
        if (line == LineEnums.Line1 && wordleView.getWord5Line1().getText().length() >= 1) {
            wordleView.enableLineOne(false);
            wordleView.enableLineTwo(true);
            wordleView.setCurrentLine(LineEnums.Line2);
            wordleView.getWord5Line1().transferFocus();
        } else if (line == LineEnums.Line2 && wordleView.getWord5Line2().getText().length() >= 1) {
            wordleView.enableLineTwo(false);
            wordleView.enableLineThree(true);
            wordleView.setCurrentLine(LineEnums.Line3);
            wordleView.getWord5Line2().transferFocus();
        } else if (line == LineEnums.Line3 && wordleView.getWord5Line3().getText().length() >= 1) {
            wordleView.enableLineThree(false);
            wordleView.enableLineFour(true);
            wordleView.setCurrentLine(LineEnums.Line4);
            wordleView.getWord5Line3().transferFocus();
        } else if (line == LineEnums.Line4 && wordleView.getWord5Line4().getText().length() >= 1) {
            wordleView.enableLineFour(false);
            wordleView.enableLineFive(true);
            wordleView.setCurrentLine(LineEnums.Line5);
            wordleView.getWord5Line4().transferFocus();
        } else if (line == LineEnums.Line5 && wordleView.getWord5Line5().getText().length() >= 1) {
            wordleView.enableLineFive(false);
            wordleView.enableLineSix(true);
            wordleView.setCurrentLine(LineEnums.Line6);
            wordleView.getWord5Line5().transferFocus();
        }
    }

    public void checkWord(String word1, String word2) {
        currectWord = word1.equals(word2);
    }

    public boolean getCorrectWord() {
        return currectWord;
    }
}
