package com.company.GUI;

import com.company.Utils.LineEnums;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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
        } else if (line == LineEnums.Line2 && wordleView.getTextFieldsArray().get(9).getText().length() >= 1) {
            wordleView.setCurrentLine(LineEnums.Line3);
        } else if (line == LineEnums.Line3 && wordleView.getTextFieldsArray().get(14).getText().length() >= 1) {
            wordleView.setCurrentLine(LineEnums.Line4);
        } else if (line == LineEnums.Line4 && wordleView.getTextFieldsArray().get(19).getText().length() >= 1) {
            wordleView.setCurrentLine(LineEnums.Line5);
        } else if (line == LineEnums.Line5 && wordleView.getTextFieldsArray().get(24).getText().length() >= 1) {
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

    public void fillTextFields(ActionEvent a, KeyEvent k){
        if (wordleView.getCurrentLine() == LineEnums.Line1) {
            if (wordleView.getTextFieldsArray().get(0).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(0).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(0).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(0).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(1).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(1).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(1).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(1).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(2).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(2).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(2).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(3).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(3).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(3).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(3).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(4).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(4).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(4).setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }
        //line2
        if (wordleView.getCurrentLine() == LineEnums.Line2) {
            if (wordleView.getTextFieldsArray().get(5).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(5).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(5).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(5).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(6).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(6).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(6).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(6).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(7).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(7).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(7).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(7).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(8).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(8).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(8).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(8).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(9).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(9).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(9).setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }

        //line3
        if (wordleView.getCurrentLine() == LineEnums.Line3) {
            if (wordleView.getTextFieldsArray().get(10).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(10).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(10).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(10).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(11).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(11).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(11).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(11).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(12).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(12).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(12).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(12).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(13).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(13).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(13).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(13).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(14).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(14).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(14).setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }

        //line4
        if (wordleView.getCurrentLine() == LineEnums.Line4) {
            if (wordleView.getTextFieldsArray().get(15).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(15).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(15).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(15).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(16).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(16).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(16).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(16).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(17).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(17).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(17).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(17).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(18).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(18).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(18).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(18).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(19).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(19).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(19).setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }

        //line5
        if (wordleView.getCurrentLine() == LineEnums.Line5) {
            if (wordleView.getTextFieldsArray().get(20).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(20).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(20).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(20).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(21).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(21).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(21).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(21).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(22).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(22).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(22).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(22).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(23).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(23).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(23).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(23).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(24).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(24).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(24).setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }

        //line6
        if (wordleView.getCurrentLine() == LineEnums.Line6) {
            if (wordleView.getTextFieldsArray().get(25).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(25).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(25).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(25).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(26).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(26).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(26).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(26).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(27).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(27).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(27).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(27).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(28).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(28).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(28).setBorder(BorderFactory.createLineBorder(Color.black));
            } else if (wordleView.getTextFieldsArray().get(28).getText().length() >= 1 &&
                    wordleView.getTextFieldsArray().get(29).getText().length() < 1) {
                wordleView.getTextFieldsArray().get(29).setText(String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()));
                wordleView.getTextFieldsArray().get(29).setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }
    }

}
