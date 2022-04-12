package com.company.GUI;

import com.company.Utils.LinesEnum;
import com.company.Utils.TextFieldsEnum;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;

public class WordleModel extends Observable {

    private LinesEnum currentLine = LinesEnum.Line1;
    private LineBorder borderColor;
    private Color backgroundColor;
    private String letter;

    public void processWord(ArrayList<JTextField> arrayList, WordleView wordleView) {
        switch (currentLine) {
            case Line1 -> {
                if (arrayList.get(TextFieldsEnum.word5Line1.ordinal()).getText().length() >= 1) {
                    wordCheck(TextFieldsEnum.word1Line1.ordinal(), TextFieldsEnum.word5Line1.ordinal(), wordleView);
                    setCurrentLine(LinesEnum.Line2);
                }
            }
            case Line2 -> {
                if (arrayList.get(TextFieldsEnum.word5Line2.ordinal()).getText().length() >= 1) {
                    wordCheck(TextFieldsEnum.word1Line2.ordinal(), TextFieldsEnum.word5Line2.ordinal(), wordleView);
                    setCurrentLine(LinesEnum.Line3);
                }
            }
            case Line3 -> {
                if (arrayList.get(TextFieldsEnum.word5Line3.ordinal()).getText().length() >= 1) {
                    wordCheck(TextFieldsEnum.word1Line3.ordinal(), TextFieldsEnum.word5Line3.ordinal(), wordleView);
                    setCurrentLine(LinesEnum.Line4);
                }
            }
            case Line4 -> {
                if (arrayList.get(TextFieldsEnum.word5Line4.ordinal()).getText().length() >= 1) {
                    wordCheck(TextFieldsEnum.word1Line4.ordinal(), TextFieldsEnum.word5Line4.ordinal(), wordleView);
                    setCurrentLine(LinesEnum.Line5);
                }
            }
            case Line5 -> {
                if (arrayList.get(TextFieldsEnum.word5Line5.ordinal()).getText().length() >= 1) {
                    wordCheck(TextFieldsEnum.word1Line5.ordinal(), TextFieldsEnum.word5Line5.ordinal(), wordleView);
                    setCurrentLine(LinesEnum.Line6);
                }
            }
            case Line6 -> {
                if (arrayList.get(TextFieldsEnum.word5Line6.ordinal()).getText().length() >= 1) {
                    wordCheck(TextFieldsEnum.word1Line6.ordinal(), TextFieldsEnum.word5Line6.ordinal(), wordleView);
                    setCurrentLine(LinesEnum.Over);
                }
            }
        }
    }

    private void wordCheck(int firstIndex, int lastIndex, WordleView wordleView) {
        String test = "hello";
        StringBuilder word = new StringBuilder();
        for (int i = firstIndex; i <= lastIndex; i++) {
            if (test.contains(wordleView.getTextFieldsArray().get(i).getText().toLowerCase())) {
                wordleView.getTextFieldsArray().get(i).setBackground(Color.YELLOW);
                wordleView.getTextFieldsArray().get(i).setBorder(new LineBorder(Color.YELLOW));
//                setBackgroundColor(Color.YELLOW);
//                setBorderColor(new LineBorder(Color.YELLOW));
//                setChanged();
//                notifyObservers();
            } else {
                wordleView.getTextFieldsArray().get(i).setBackground(Color.GRAY);
                wordleView.getTextFieldsArray().get(i).setBorder(new LineBorder(Color.GRAY));
//                setBackgroundColor(Color.GRAY);
//                setBorderColor(new LineBorder(Color.GRAY));
//                setChanged();
//                notifyObservers();
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

    private void processLetter(LineBorder lineBorder, String string, int index) {
        borderColor = lineBorder;
        letter = string;
        setChanged();
        notifyObservers(index);
    }

    public void addLetter(ArrayList<JTextField> arrayList, ActionEvent a, KeyEvent k) {
        switch (currentLine) {
            case Line1 -> {
                if (arrayList.get(TextFieldsEnum.word1Line1.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word1Line1.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word1Line1.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line1.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word2Line1.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word2Line1.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line1.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word3Line1.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line1.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line1.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word4Line1.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line1.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line1.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word5Line1.ordinal());
                }
            }
            case Line2 -> {
                if (arrayList.get(TextFieldsEnum.word1Line2.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word1Line2.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word1Line2.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line2.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word2Line2.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word2Line2.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line2.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word3Line2.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line2.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line2.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word4Line2.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line2.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line2.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word5Line2.ordinal());
                }
            }
            case Line3 -> {
                if (arrayList.get(TextFieldsEnum.word1Line3.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word1Line3.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word1Line3.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line3.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word2Line3.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word2Line3.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line3.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word3Line3.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line3.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line3.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word4Line3.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line3.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line3.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word5Line3.ordinal());
                }
            }
            case Line4 -> {
                if (arrayList.get(TextFieldsEnum.word1Line4.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word1Line4.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word1Line4.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line4.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word2Line4.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word2Line4.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line4.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word3Line4.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line4.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line4.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word4Line4.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line4.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line4.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word5Line4.ordinal());
                }
            }
            case Line5 -> {
                if (arrayList.get(TextFieldsEnum.word1Line5.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word1Line5.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word1Line5.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line5.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word2Line5.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word2Line5.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line5.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word3Line5.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line5.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line5.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word4Line5.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line5.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line5.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word5Line5.ordinal());
                }
            }
            case Line6 -> {
                if (arrayList.get(TextFieldsEnum.word1Line6.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word1Line6.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word1Line6.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line6.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word2Line6.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word2Line6.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line6.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word3Line6.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line6.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line6.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word4Line6.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line6.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line6.ordinal()).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()),
                            TextFieldsEnum.word5Line6.ordinal());
                }
            }
        }
    }

    public void deleteLetter(ArrayList<JTextField> arrayList) {
        switch (currentLine) {
            case Line1 -> {
                if (arrayList.get(TextFieldsEnum.word5Line1.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word5Line1.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word5Line1.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line1.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word4Line1.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line1.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line1.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word3Line1.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line1.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line1.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word2Line1.ordinal());
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word1Line1.ordinal());
                }
            }
            case Line2 -> {
                if (arrayList.get(TextFieldsEnum.word5Line2.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word5Line2.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word5Line2.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line2.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word4Line2.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line2.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line2.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word3Line2.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line2.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line2.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word2Line2.ordinal());
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word1Line2.ordinal());
                }
            }
            case Line3 -> {
                if (arrayList.get(TextFieldsEnum.word5Line3.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word5Line3.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word5Line3.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line3.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word4Line3.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line3.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line3.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word3Line3.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line3.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line3.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word2Line3.ordinal());
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word1Line3.ordinal());
                }
            }
            case Line4 -> {
                if (arrayList.get(TextFieldsEnum.word5Line4.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word5Line4.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word5Line4.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line4.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word4Line4.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line4.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line4.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word3Line4.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line4.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line4.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word2Line4.ordinal());
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word1Line4.ordinal());
                }
            }
            case Line5 -> {
                if (arrayList.get(TextFieldsEnum.word5Line5.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word5Line5.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word5Line5.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line5.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word4Line5.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line5.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line5.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word3Line5.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line5.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line5.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word2Line5.ordinal());
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word1Line5.ordinal());
                }
            }
            case Line6 -> {
                if (arrayList.get(TextFieldsEnum.word5Line6.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word5Line6.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word5Line6.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line6.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word4Line6.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word4Line6.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line6.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word3Line6.ordinal());
                } else if (arrayList.get(TextFieldsEnum.word3Line6.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line6.ordinal()).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word2Line6.ordinal());
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, TextFieldsEnum.word1Line6.ordinal());
                }
            }
        }
    }

    private void setCurrentLine(LinesEnum line) {
        currentLine = line;
        setChanged();
        notifyObservers(line);
    }

    public LineBorder getBorderColor() {
        return borderColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public String getLetter() {
        return letter;
    }

}
