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

    public void processWord() {
        LineEnums line = wordleView.getCurrentLine();
        switch (line) {
            case Line1 -> {
                if (wordleView.getTextFieldsArray().get(4).getText().length() >= 1) {
                    wordCheck(0, 4);
                    wordleView.setCurrentLine(LineEnums.Line2);
                }
            }
            case Line2 -> {
                if (wordleView.getTextFieldsArray().get(9).getText().length() >= 1) {
                    wordCheck(5,9);
                    wordleView.setCurrentLine(LineEnums.Line3);
                }
            }
            case Line3 -> {
                if (wordleView.getTextFieldsArray().get(14).getText().length() >= 1) {
                    wordCheck(10, 14);
                    wordleView.setCurrentLine(LineEnums.Line4);
                }
            }
            case Line4 -> {
                if (wordleView.getTextFieldsArray().get(19).getText().length() >= 1) {
                    wordCheck(15, 19);
                    wordleView.setCurrentLine(LineEnums.Line5);
                }
            }
            case Line5 -> {
                if (wordleView.getTextFieldsArray().get(24).getText().length() >= 1) {
                    wordCheck(20, 24);
                    wordleView.setCurrentLine(LineEnums.Line6);
                }
            }
            case Line6 -> {
                if (wordleView.getTextFieldsArray().get(29).getText().length() >= 1) {
                    wordCheck(25, 29);
                    wordleView.setCurrentLine(LineEnums.Over);
                }
            }
        }
    }

    private void wordCheck(int firstIndex, int lastIndex) {
        String test = "hello";
        StringBuilder word = new StringBuilder();
        for (int i = firstIndex; i <= lastIndex; i++) {
            if(test.contains(wordleView.getTextFieldsArray().get(i).getText().toLowerCase())){
                wordleView.getTextFieldsArray().get(i).setBackground(Color.YELLOW);
                wordleView.getTextFieldsArray().get(i).setBorder(new LineBorder(Color.YELLOW));
            }else {
                wordleView.getTextFieldsArray().get(i).setBackground(Color.GRAY);
                wordleView.getTextFieldsArray().get(i).setBorder(new LineBorder(Color.GRAY));
            }
            int j = i;
            wordleView.getButtonsArray().forEach(button -> {
                if (button.getText().equals(wordleView.getTextFieldsArray().get(j).getText())) {
                    if (test.contains(button.getText().toLowerCase())) {
                        button.setBackground(Color.YELLOW);
                    } else {
                        button.setBackground(Color.GRAY);
                    }
                }
            });
        }
    }

    public void addLetter(ActionEvent a, KeyEvent k) {
        LineEnums line = wordleView.getCurrentLine();
        switch (line) {
            case Line1 -> {
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
            case Line2 -> {
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
            case Line3 -> {
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
            case Line4 -> {
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
            case Line5 -> {
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
            case Line6 -> {
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

    public void deleteLetter() {
        LineEnums line = wordleView.getCurrentLine();
        switch (line) {
            case Line1 -> {
                if (wordleView.getTextFieldsArray().get(4).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(4).setText(null);
                    wordleView.getTextFieldsArray().get(4).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(4).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(3).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(3).setText(null);
                    wordleView.getTextFieldsArray().get(3).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(3).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(2).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(2).setText(null);
                    wordleView.getTextFieldsArray().get(2).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(2).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(1).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(1).setText(null);
                    wordleView.getTextFieldsArray().get(1).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else {
                    wordleView.getTextFieldsArray().get(0).setText(null);
                    wordleView.getTextFieldsArray().get(0).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                }
            }
            case Line2 -> {
                if (wordleView.getTextFieldsArray().get(9).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(9).setText(null);
                    wordleView.getTextFieldsArray().get(9).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(9).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(8).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(8).setText(null);
                    wordleView.getTextFieldsArray().get(8).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(8).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(7).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(7).setText(null);
                    wordleView.getTextFieldsArray().get(7).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(7).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(6).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(6).setText(null);
                    wordleView.getTextFieldsArray().get(6).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else {
                    wordleView.getTextFieldsArray().get(5).setText(null);
                    wordleView.getTextFieldsArray().get(5).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                }
            }
            case Line3 -> {
                if (wordleView.getTextFieldsArray().get(14).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(14).setText(null);
                    wordleView.getTextFieldsArray().get(14).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(14).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(13).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(13).setText(null);
                    wordleView.getTextFieldsArray().get(13).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(13).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(12).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(12).setText(null);
                    wordleView.getTextFieldsArray().get(12).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(12).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(11).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(11).setText(null);
                    wordleView.getTextFieldsArray().get(11).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else {
                    wordleView.getTextFieldsArray().get(10).setText(null);
                    wordleView.getTextFieldsArray().get(10).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                }
            }
            case Line4 -> {
                if (wordleView.getTextFieldsArray().get(19).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(19).setText(null);
                    wordleView.getTextFieldsArray().get(19).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(19).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(18).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(18).setText(null);
                    wordleView.getTextFieldsArray().get(18).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(18).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(17).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(17).setText(null);
                    wordleView.getTextFieldsArray().get(17).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(17).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(16).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(16).setText(null);
                    wordleView.getTextFieldsArray().get(16).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else {
                    wordleView.getTextFieldsArray().get(15).setText(null);
                    wordleView.getTextFieldsArray().get(15).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                }
            }
            case Line5 -> {
                if (wordleView.getTextFieldsArray().get(24).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(24).setText(null);
                    wordleView.getTextFieldsArray().get(24).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(24).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(23).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(23).setText(null);
                    wordleView.getTextFieldsArray().get(23).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(23).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(22).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(22).setText(null);
                    wordleView.getTextFieldsArray().get(22).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(22).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(21).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(21).setText(null);
                    wordleView.getTextFieldsArray().get(21).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else {
                    wordleView.getTextFieldsArray().get(20).setText(null);
                    wordleView.getTextFieldsArray().get(20).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                }
            }
            case Line6 -> {
                if (wordleView.getTextFieldsArray().get(29).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(29).setText(null);
                    wordleView.getTextFieldsArray().get(29).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(29).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(28).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(28).setText(null);
                    wordleView.getTextFieldsArray().get(28).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(28).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(27).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(27).setText(null);
                    wordleView.getTextFieldsArray().get(27).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else if (wordleView.getTextFieldsArray().get(27).getText().length() == 0 &&
                        wordleView.getTextFieldsArray().get(26).getText().length() >= 1) {
                    wordleView.getTextFieldsArray().get(26).setText(null);
                    wordleView.getTextFieldsArray().get(26).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                } else {
                    wordleView.getTextFieldsArray().get(25).setText(null);
                    wordleView.getTextFieldsArray().get(25).setBorder(new LineBorder(Color.decode("#edeff1"), 2));
                }
            }
        }
    }

}
