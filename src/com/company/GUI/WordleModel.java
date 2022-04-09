package com.company.GUI;

import com.company.Utils.LineEnums;

import javax.swing.border.LineBorder;
import java.awt.*;

public class WordleModel {
    private final WordleView wordleView;

    public WordleModel(WordleView wordleView) {
        this.wordleView = wordleView;
    }

    public void deleteLetter() {
        LineEnums line = wordleView.getCurrentLine();
        if (line == LineEnums.Line1) {

        }
    }

    public void checkWord() {
        LineEnums line = wordleView.getCurrentLine();
        if (line == LineEnums.Line1 && wordleView.getTextFieldsArray().get(4).getText().length() >= 1) {
            colorBlocks(line, false);
            wordleView.setCurrentLine(LineEnums.Line2);
        } else if (line == LineEnums.Line2 && wordleView.getWord5Line2().getText().length() >= 1) {
            wordleView.setCurrentLine(LineEnums.Line3);
        } else if (line == LineEnums.Line3 && wordleView.getWord5Line3().getText().length() >= 1) {
            wordleView.setCurrentLine(LineEnums.Line4);
        } else if (line == LineEnums.Line4 && wordleView.getWord5Line4().getText().length() >= 1) {
            wordleView.setCurrentLine(LineEnums.Line5);
        } else if (line == LineEnums.Line5 && wordleView.getWord5Line5().getText().length() >= 1) {
            wordleView.setCurrentLine(LineEnums.Line6);
        }
    }

    public void colorBlocks(LineEnums line, boolean restart) {
        if (line == LineEnums.Line1) {
            wordleView.getTextFieldsArray().get(0).setBackground(restart ? Color.white : Color.GRAY);
            wordleView.getTextFieldsArray().get(0).setBorder(new LineBorder(restart ? null : Color.GRAY));
            wordleView.getTextFieldsArray().get(1).setBackground(restart ? Color.white : Color.GRAY);
            wordleView.getTextFieldsArray().get(1).setBorder(new LineBorder(restart ? null : Color.GRAY));
            wordleView.getTextFieldsArray().get(2).setBackground(restart ? Color.white : Color.GRAY);
            wordleView.getTextFieldsArray().get(2).setBorder(new LineBorder(restart ? null : Color.GRAY));
            wordleView.getTextFieldsArray().get(3).setBackground(restart ? Color.white : Color.GRAY);
            wordleView.getTextFieldsArray().get(3).setBorder(new LineBorder(restart ? null : Color.GRAY));
            wordleView.getTextFieldsArray().get(4).setBackground(restart ? Color.white : Color.GRAY);
            wordleView.getTextFieldsArray().get(4).setBorder(new LineBorder(restart ? null : Color.GRAY));
        }
    }

}
