package com.company.GUI;

import com.company.Utils.LinesEnum;
import com.company.Utils.TextFieldsEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class WordleModel extends Observable {

    private LinesEnum currentLine = LinesEnum.Line1;
    private String[][] letters = new String[6][5];
    private Color[][] backgroundColors = new Color[6][5];
    private Color[][] borderColors = new Color[6][5];
    private HashMap<Integer, Color> buttonColors =  new HashMap<>();

    public void processWord(ArrayList<JTextField> jTextFields, ArrayList<JButton> jButtons) {
        StringBuilder word = new StringBuilder("");
        switch (currentLine) {
            case Line1 -> {
                if (jTextFields.get(TextFieldsEnum.word5Line1.ordinal()).getText().length() >= 1) {
                    for (int i = 0; i <= TextFieldsEnum.word5Line1.ordinal(); i++) {
                        word.append(jTextFields.get(i).getText());
                    }
                    wordCheck(String.valueOf(word), LinesEnum.Line2, jButtons);
                }
            }
            case Line2 -> {
                if (jTextFields.get(TextFieldsEnum.word5Line2.ordinal()).getText().length() >= 1) {
                    for (int i = TextFieldsEnum.word1Line2.ordinal(); i <= TextFieldsEnum.word5Line2.ordinal(); i++) {
                        word.append(jTextFields.get(i).getText());
                    }
                    wordCheck(String.valueOf(word), LinesEnum.Line3, jButtons);
                }
            }
            case Line3 -> {
                if (jTextFields.get(TextFieldsEnum.word5Line3.ordinal()).getText().length() >= 1) {
                    for (int i = TextFieldsEnum.word1Line3.ordinal(); i <= TextFieldsEnum.word5Line3.ordinal(); i++) {
                        word.append(jTextFields.get(i).getText());
                    }
                    wordCheck(String.valueOf(word), LinesEnum.Line4, jButtons);
                }
            }
            case Line4 -> {
                if (jTextFields.get(TextFieldsEnum.word5Line4.ordinal()).getText().length() >= 1) {
                    for (int i = TextFieldsEnum.word1Line4.ordinal(); i <= TextFieldsEnum.word5Line4.ordinal(); i++) {
                        word.append(jTextFields.get(i).getText());
                    }
                    wordCheck(String.valueOf(word), LinesEnum.Line5, jButtons);
                }
            }
            case Line5 -> {
                if (jTextFields.get(TextFieldsEnum.word5Line5.ordinal()).getText().length() >= 1) {
                    for (int i = TextFieldsEnum.word1Line5.ordinal(); i <= TextFieldsEnum.word5Line5.ordinal(); i++) {
                        word.append(jTextFields.get(i).getText());
                    }
                    wordCheck(String.valueOf(word), LinesEnum.Line6, jButtons);
                }
            }
            case Line6 -> {
                if (jTextFields.get(TextFieldsEnum.word5Line6.ordinal()).getText().length() >= 1) {
                    for (int i = TextFieldsEnum.word1Line6.ordinal(); i <= TextFieldsEnum.word5Line6.ordinal(); i++) {
                        word.append(jTextFields.get(i).getText());
                    }
                    wordCheck(String.valueOf(word), LinesEnum.Over, jButtons);
                }
            }
        }
    }

    private void wordCheck(String word, LinesEnum nextLine, ArrayList<JButton> buttonsList) {
        String test = "hello";

        if (test.equals(word.toLowerCase())) {
            for (int i = 0; i < 5; i++) {
                backgroundColors[currentLine.ordinal()][i] = Color.green;
                borderColors[currentLine.ordinal()][i] = Color.green;
                paintButton(i, Color.green, buttonsList);
            }
            setCurrentLine(LinesEnum.Over);
        } else {
            for (int i = 0; i < 5; i++) {
                    if (letters[currentLine.ordinal()][i].equals(String.valueOf(test.charAt(i)))){
                        backgroundColors[currentLine.ordinal()][i] = Color.green;
                        borderColors[currentLine.ordinal()][i] = Color.green;
                        paintButton(i, Color.green, buttonsList);
                    } else if(!letters[currentLine.ordinal()][i].equals(String.valueOf(test.charAt(i))) &&
                            test.contains(String.valueOf(word.charAt(i)).toLowerCase())) {
                        backgroundColors[currentLine.ordinal()][i] = Color.yellow;
                        borderColors[currentLine.ordinal()][i] = Color.yellow;
                        paintButton(i, Color.yellow, buttonsList);
                    }else {
                        backgroundColors[currentLine.ordinal()][i] = Color.gray;
                        borderColors[currentLine.ordinal()][i] = Color.gray;
                        paintButton(i, Color.gray, buttonsList);
                    }
            }
            setCurrentLine(nextLine);
        }

    }

    public void addLetter(ArrayList<JTextField> arrayList, ActionEvent a, KeyEvent k) {
        switch (currentLine) {
            case Line1 -> {
                if (arrayList.get(TextFieldsEnum.word1Line1.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line1.ordinal()][0] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line1.ordinal()][0] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word1Line1.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line1.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line1.ordinal()][1] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line1.ordinal()][1] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word2Line1.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line1.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line1.ordinal()][2] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line1.ordinal()][2] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word3Line1.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line1.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line1.ordinal()][3] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line1.ordinal()][3] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word4Line1.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line1.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line1.ordinal()][4] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line1.ordinal()][4] = Color.black;
                }
                setChanged();
                notifyObservers();
            }
            case Line2 -> {
                if (arrayList.get(TextFieldsEnum.word1Line2.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line2.ordinal()][0] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line2.ordinal()][0] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word1Line2.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line2.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line2.ordinal()][1] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line2.ordinal()][1] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word2Line2.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line2.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line2.ordinal()][2] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line2.ordinal()][2] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word3Line2.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line2.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line2.ordinal()][3] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line2.ordinal()][3] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word4Line2.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line2.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line2.ordinal()][4] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line2.ordinal()][4] = Color.black;
                }
                setChanged();
                notifyObservers();
            }
            case Line3 -> {
                if (arrayList.get(TextFieldsEnum.word1Line3.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line3.ordinal()][0] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line3.ordinal()][0] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word1Line3.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line3.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line3.ordinal()][1] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line3.ordinal()][1] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word2Line3.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line3.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line3.ordinal()][2] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line3.ordinal()][2] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word3Line3.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line3.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line3.ordinal()][3] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line3.ordinal()][3] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word4Line3.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line3.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line3.ordinal()][4] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line3.ordinal()][4] = Color.black;
                }
                setChanged();
                notifyObservers();
            }
            case Line4 -> {
                if (arrayList.get(TextFieldsEnum.word1Line4.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line4.ordinal()][0] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line4.ordinal()][0] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word1Line4.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line4.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line4.ordinal()][1] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line4.ordinal()][1] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word2Line4.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line4.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line4.ordinal()][2] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line4.ordinal()][2] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word3Line4.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line4.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line4.ordinal()][3] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line4.ordinal()][3] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word4Line4.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line4.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line4.ordinal()][4] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line4.ordinal()][4] = Color.black;
                }
                setChanged();
                notifyObservers();
            }
            case Line5 -> {
                if (arrayList.get(TextFieldsEnum.word1Line5.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line5.ordinal()][0] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line5.ordinal()][0] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word1Line5.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line5.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line5.ordinal()][1] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line5.ordinal()][1] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word2Line5.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line5.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line5.ordinal()][2] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line5.ordinal()][2] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word3Line5.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line5.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line5.ordinal()][3] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line5.ordinal()][3] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word4Line5.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line5.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line5.ordinal()][4] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line5.ordinal()][4] = Color.black;
                }
                setChanged();
                notifyObservers();
            }
            case Line6 -> {
                if (arrayList.get(TextFieldsEnum.word1Line6.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line6.ordinal()][0] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line6.ordinal()][0] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word1Line6.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word2Line6.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line6.ordinal()][1] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line6.ordinal()][1] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word2Line6.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word3Line6.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line6.ordinal()][2] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line6.ordinal()][2] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word3Line6.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word4Line6.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line6.ordinal()][3] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line6.ordinal()][3] = Color.black;
                } else if (arrayList.get(TextFieldsEnum.word4Line6.ordinal()).getText().length() >= 1 &&
                        arrayList.get(TextFieldsEnum.word5Line6.ordinal()).getText().length() < 1) {
                    letters[LinesEnum.Line6.ordinal()][4] =
                            String.valueOf(a != null ? a.getActionCommand() : k.getKeyChar());
                    borderColors[LinesEnum.Line6.ordinal()][4] = Color.black;
                }
                setChanged();
                notifyObservers();
            }
        }
    }

    public void deleteLetter(ArrayList<JTextField> arrayList) {
        switch (currentLine) {
            case Line1 -> {
                if (arrayList.get(TextFieldsEnum.word5Line1.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line1.ordinal()][4] = null;
                    borderColors[LinesEnum.Line1.ordinal()][4] = null;
                } else if (arrayList.get(TextFieldsEnum.word5Line1.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line1.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line1.ordinal()][3] = null;
                    borderColors[LinesEnum.Line1.ordinal()][3] = null;
                } else if (arrayList.get(TextFieldsEnum.word4Line1.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line1.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line1.ordinal()][2] = null;
                    borderColors[LinesEnum.Line1.ordinal()][2] = null;
                } else if (arrayList.get(TextFieldsEnum.word3Line1.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line1.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line1.ordinal()][1] = null;
                    borderColors[LinesEnum.Line1.ordinal()][1] = null;
                } else {
                    letters[LinesEnum.Line1.ordinal()][0] = null;
                    borderColors[LinesEnum.Line1.ordinal()][0] = null;
                }
                setChanged();
                notifyObservers();
            }
            case Line2 -> {
                if (arrayList.get(TextFieldsEnum.word5Line2.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line2.ordinal()][4] = null;
                    borderColors[LinesEnum.Line2.ordinal()][4] = null;
                } else if (arrayList.get(TextFieldsEnum.word5Line2.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line2.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line2.ordinal()][3] = null;
                    borderColors[LinesEnum.Line2.ordinal()][3] = null;
                } else if (arrayList.get(TextFieldsEnum.word4Line2.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line2.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line2.ordinal()][2] = null;
                    borderColors[LinesEnum.Line2.ordinal()][2] = null;
                } else if (arrayList.get(TextFieldsEnum.word3Line2.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line2.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line2.ordinal()][1] = null;
                    borderColors[LinesEnum.Line2.ordinal()][1] = null;
                } else {
                    letters[LinesEnum.Line2.ordinal()][0] = null;
                    borderColors[LinesEnum.Line2.ordinal()][0] = null;
                }
                setChanged();
                notifyObservers();
            }
            case Line3 -> {
                if (arrayList.get(TextFieldsEnum.word5Line3.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line3.ordinal()][4] = null;
                    borderColors[LinesEnum.Line3.ordinal()][4] = null;
                } else if (arrayList.get(TextFieldsEnum.word5Line3.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line3.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line3.ordinal()][3] = null;
                    borderColors[LinesEnum.Line3.ordinal()][3] = null;
                } else if (arrayList.get(TextFieldsEnum.word4Line3.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line3.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line3.ordinal()][2] = null;
                    borderColors[LinesEnum.Line3.ordinal()][2] = null;
                } else if (arrayList.get(TextFieldsEnum.word3Line3.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line3.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line3.ordinal()][1] = null;
                    borderColors[LinesEnum.Line3.ordinal()][1] = null;
                } else {
                    letters[LinesEnum.Line3.ordinal()][0] = null;
                    borderColors[LinesEnum.Line3.ordinal()][0] = null;
                }
                setChanged();
                notifyObservers();
            }
            case Line4 -> {
                if (arrayList.get(TextFieldsEnum.word5Line4.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line4.ordinal()][4] = null;
                    borderColors[LinesEnum.Line4.ordinal()][4] = null;
                } else if (arrayList.get(TextFieldsEnum.word5Line4.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line4.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line4.ordinal()][3] = null;
                    borderColors[LinesEnum.Line4.ordinal()][3] = null;
                } else if (arrayList.get(TextFieldsEnum.word4Line4.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line4.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line4.ordinal()][2] = null;
                    borderColors[LinesEnum.Line4.ordinal()][2] = null;
                } else if (arrayList.get(TextFieldsEnum.word3Line4.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line4.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line4.ordinal()][1] = null;
                    borderColors[LinesEnum.Line4.ordinal()][1] = null;
                } else {
                    letters[LinesEnum.Line4.ordinal()][0] = null;
                    borderColors[LinesEnum.Line4.ordinal()][0] = null;
                }
                setChanged();
                notifyObservers();
            }
            case Line5 -> {
                if (arrayList.get(TextFieldsEnum.word5Line5.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line5.ordinal()][4] = null;
                    borderColors[LinesEnum.Line5.ordinal()][4] = null;
                } else if (arrayList.get(TextFieldsEnum.word5Line5.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line5.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line5.ordinal()][3] = null;
                    borderColors[LinesEnum.Line5.ordinal()][3] = null;
                } else if (arrayList.get(TextFieldsEnum.word4Line5.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line5.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line5.ordinal()][2] = null;
                    borderColors[LinesEnum.Line5.ordinal()][2] = null;
                } else if (arrayList.get(TextFieldsEnum.word3Line5.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line5.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line5.ordinal()][1] = null;
                    borderColors[LinesEnum.Line5.ordinal()][1] = null;
                } else {
                    letters[LinesEnum.Line5.ordinal()][0] = null;
                    borderColors[LinesEnum.Line5.ordinal()][0] = null;
                }
                setChanged();
                notifyObservers();
            }
            case Line6 -> {
                if (arrayList.get(TextFieldsEnum.word5Line6.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line6.ordinal()][4] = null;
                    borderColors[LinesEnum.Line6.ordinal()][4] = null;
                } else if (arrayList.get(TextFieldsEnum.word5Line6.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word4Line6.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line6.ordinal()][3] = null;
                    borderColors[LinesEnum.Line6.ordinal()][3] = null;
                } else if (arrayList.get(TextFieldsEnum.word4Line6.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word3Line6.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line6.ordinal()][2] = null;
                    borderColors[LinesEnum.Line6.ordinal()][2] = null;
                } else if (arrayList.get(TextFieldsEnum.word3Line6.ordinal()).getText().length() == 0 &&
                        arrayList.get(TextFieldsEnum.word2Line6.ordinal()).getText().length() >= 1) {
                    letters[LinesEnum.Line6.ordinal()][1] = null;
                    borderColors[LinesEnum.Line6.ordinal()][1] = null;
                } else {
                    letters[LinesEnum.Line6.ordinal()][0] = null;
                    borderColors[LinesEnum.Line6.ordinal()][0] = null;
                }
                setChanged();
                notifyObservers();
            }
        }
    }

    private void paintButton(int index, Color color, ArrayList<JButton> buttonsList){
        for(int i=0; i < buttonsList.size(); i++ ){
            if(buttonsList.get(i).getText().toLowerCase().equals(letters[currentLine.ordinal()][index])){
                buttonColors.put(i, color);
            }
        }
    }

    public void startOver() {
        letters = new String[6][5];
        backgroundColors = new Color[6][5];
        borderColors = new Color[6][5];
        buttonColors.forEach((i,b)-> buttonColors.put(i, null));
        setCurrentLine(LinesEnum.Line1);
        setChanged();
        notifyObservers();
    }

    private void setCurrentLine(LinesEnum line) {
        currentLine = line;
        setChanged();
        notifyObservers(line);
    }

    public String[][] getLetters() {
        return letters;
    }

    public Color[][] getBackgroundColors() {
        return backgroundColors;
    }

    public Color[][] getBorderColors() {
        return borderColors;
    }

    public HashMap<Integer, Color> getButtonColors() {
        return buttonColors;
    }

}
