package com.company.GUI;

import com.company.Utils.Enums;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;

public class WordleModel extends Observable {

    private Enums.LinesEnum currentLine = Enums.LinesEnum.Line1;
    private LineBorder borderColor;
    private Color backgroundColor;
    private String letter;

    public void processWord(ArrayList<JTextField> arrayList, WordleView wordleView) {
        switch (currentLine) {
            case Line1 -> {
                if (arrayList.get(4).getText().length() >= 1) {
                    wordCheck(0, 4, wordleView);
                    setCurrentLine(Enums.LinesEnum.Line2);
                }
            }
            case Line2 -> {
                if (arrayList.get(9).getText().length() >= 1) {
                    wordCheck(5, 9, wordleView);
                    setCurrentLine(Enums.LinesEnum.Line3);
                }
            }
            case Line3 -> {
                if (arrayList.get(14).getText().length() >= 1) {
                    wordCheck(10, 14, wordleView);
                    setCurrentLine(Enums.LinesEnum.Line4);
                }
            }
            case Line4 -> {
                if (arrayList.get(19).getText().length() >= 1) {
                    wordCheck(15, 19, wordleView);
                    setCurrentLine(Enums.LinesEnum.Line5);
                }
            }
            case Line5 -> {
                if (arrayList.get(24).getText().length() >= 1) {
                    wordCheck(20, 24, wordleView);
                    setCurrentLine(Enums.LinesEnum.Line6);
                }
            }
            case Line6 -> {
                if (arrayList.get(29).getText().length() >= 1) {
                    wordCheck(25, 29, wordleView);
                    setCurrentLine(Enums.LinesEnum.Over);
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
                if (arrayList.get(0).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 0);
                } else if (arrayList.get(0).getText().length() >= 1 &&
                        arrayList.get(1).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 1);
                } else if (arrayList.get(1).getText().length() >= 1 &&
                        arrayList.get(2).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 2);
                } else if (arrayList.get(2).getText().length() >= 1 &&
                        arrayList.get(3).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 3);
                } else if (arrayList.get(3).getText().length() >= 1 &&
                        arrayList.get(4).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 4);
                }
            }
            case Line2 -> {
                if (arrayList.get(5).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 5);
                } else if (arrayList.get(5).getText().length() >= 1 &&
                        arrayList.get(6).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 6);
                } else if (arrayList.get(6).getText().length() >= 1 &&
                        arrayList.get(7).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 7);
                } else if (arrayList.get(7).getText().length() >= 1 &&
                        arrayList.get(8).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 8);
                } else if (arrayList.get(8).getText().length() >= 1 &&
                        arrayList.get(9).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 9);
                }
            }
            case Line3 -> {
                if (arrayList.get(10).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 10);
                } else if (arrayList.get(10).getText().length() >= 1 &&
                        arrayList.get(11).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 11);
                } else if (arrayList.get(11).getText().length() >= 1 &&
                        arrayList.get(12).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 12);
                } else if (arrayList.get(12).getText().length() >= 1 &&
                        arrayList.get(13).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 13);
                } else if (arrayList.get(13).getText().length() >= 1 &&
                        arrayList.get(14).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 14);
                }
            }
            case Line4 -> {
                if (arrayList.get(15).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 15);
                } else if (arrayList.get(15).getText().length() >= 1 &&
                        arrayList.get(16).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 16);
                } else if (arrayList.get(16).getText().length() >= 1 &&
                        arrayList.get(17).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 17);
                } else if (arrayList.get(17).getText().length() >= 1 &&
                        arrayList.get(18).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 18);
                } else if (arrayList.get(18).getText().length() >= 1 &&
                        arrayList.get(19).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 19);
                }
            }
            case Line5 -> {
                if (arrayList.get(20).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 20);
                } else if (arrayList.get(20).getText().length() >= 1 &&
                        arrayList.get(21).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 21);
                } else if (arrayList.get(21).getText().length() >= 1 &&
                        arrayList.get(22).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 22);
                } else if (arrayList.get(22).getText().length() >= 1 &&
                        arrayList.get(23).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 23);
                } else if (arrayList.get(23).getText().length() >= 1 &&
                        arrayList.get(24).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 24);
                }
            }
            case Line6 -> {
                if (arrayList.get(25).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 25);
                } else if (arrayList.get(25).getText().length() >= 1 &&
                        arrayList.get(26).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 26);
                } else if (arrayList.get(26).getText().length() >= 1 &&
                        arrayList.get(27).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 27);
                } else if (arrayList.get(27).getText().length() >= 1 &&
                        arrayList.get(28).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 28);
                } else if (arrayList.get(28).getText().length() >= 1 &&
                        arrayList.get(29).getText().length() < 1) {
                    processLetter(new LineBorder(Color.black),
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar()), 29);
                }
            }
        }
    }

    public void deleteLetter(ArrayList<JTextField> arrayList) {
        switch (currentLine) {
            case Line1 -> {
                if (arrayList.get(4).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 4);
                } else if (arrayList.get(4).getText().length() == 0 &&
                        arrayList.get(3).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 3);
                } else if (arrayList.get(3).getText().length() == 0 &&
                        arrayList.get(2).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 2);
                } else if (arrayList.get(2).getText().length() == 0 &&
                        arrayList.get(1).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 1);
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 0);
                }
            }
            case Line2 -> {
                if (arrayList.get(9).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 9);
                } else if (arrayList.get(9).getText().length() == 0 &&
                        arrayList.get(8).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 8);
                } else if (arrayList.get(8).getText().length() == 0 &&
                        arrayList.get(7).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 7);
                } else if (arrayList.get(7).getText().length() == 0 &&
                        arrayList.get(6).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 6);
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 5);
                }
            }
            case Line3 -> {
                if (arrayList.get(14).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 14);
                } else if (arrayList.get(14).getText().length() == 0 &&
                        arrayList.get(13).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 13);
                } else if (arrayList.get(13).getText().length() == 0 &&
                        arrayList.get(12).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 12);
                } else if (arrayList.get(12).getText().length() == 0 &&
                        arrayList.get(11).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 11);
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 10);
                }
            }
            case Line4 -> {
                if (arrayList.get(19).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 19);
                } else if (arrayList.get(19).getText().length() == 0 &&
                        arrayList.get(18).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 18);
                } else if (arrayList.get(18).getText().length() == 0 &&
                        arrayList.get(17).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 17);
                } else if (arrayList.get(17).getText().length() == 0 &&
                        arrayList.get(16).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 16);
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 15);
                }
            }
            case Line5 -> {
                if (arrayList.get(24).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 24);
                } else if (arrayList.get(24).getText().length() == 0 &&
                        arrayList.get(23).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 23);
                } else if (arrayList.get(23).getText().length() == 0 &&
                        arrayList.get(22).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 22);
                } else if (arrayList.get(22).getText().length() == 0 &&
                        arrayList.get(21).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 21);
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 20);
                }
            }
            case Line6 -> {
                if (arrayList.get(29).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 29);
                } else if (arrayList.get(29).getText().length() == 0 &&
                        arrayList.get(28).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 28);
                } else if (arrayList.get(28).getText().length() == 0 &&
                        arrayList.get(27).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 27);
                } else if (arrayList.get(27).getText().length() == 0 &&
                        arrayList.get(26).getText().length() >= 1) {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 26);
                } else {
                    processLetter(new LineBorder(Color.decode("#edeff1"), 2),
                            null, 25);
                }
            }
        }
    }

    private void setCurrentLine(Enums.LinesEnum currentLine) {
        setChanged();
        notifyObservers(currentLine);
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
