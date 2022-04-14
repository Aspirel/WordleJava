package com.company.GUI;

import com.company.Utils.LinesEnum;
import com.company.Utils.TextFieldsEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordleModel extends Observable {
    private boolean noWordFlag;
    private boolean displayWordFlag;
    private boolean randomWordFlag;
    private String targetWord;
    private LinesEnum currentLine;
    private String[][] letters;
    private Color[][] backgroundColors;
    private Color[][] borderColors;
    private HashMap<Integer, Color> buttonColors;
    private ArrayList<String> allWords;
    private ArrayList<String> allTargetWords;

    public WordleModel() {
        init();
    }

    private void init() {
        noWordFlag = false;
        displayWordFlag = false;
        randomWordFlag = false;
        targetWord = null;
        currentLine = LinesEnum.Line1;
        letters = new String[6][5];
        backgroundColors = new Color[6][5];
        borderColors = new Color[6][5];
        buttonColors = new HashMap<>();
        allWords = new ArrayList<>();
        allTargetWords = new ArrayList<>();

        setCurrentLine(LinesEnum.Line1);

        try {
            Scanner scanner = new Scanner(new File("src/com/company/Resources/common.txt"));
            Scanner scanner2 = new Scanner(new File("src/com/company/Resources/words.txt"));
            while (scanner.hasNextLine()) {
                allTargetWords.add(scanner.nextLine());
            }
            scanner.close();
            while (scanner2.hasNextLine()) {
                allWords.add(scanner2.nextLine());
            }
            scanner2.close();
        } catch (FileNotFoundException e) {
            System.out.printf("File not found %s", e);
        }
        assert !allTargetWords.isEmpty();
        Random random = new Random();

        //If the flag for random words is enabled, it gets a random one, otherwise, gets a fixed word(first one).
        //How to choose the fixed word was not specified in the course work, only that it must be fixed, therefore
        //the first of the list is the one.
        targetWord = randomWordFlag ? allTargetWords.get(random.nextInt(allTargetWords.size())) :
        allTargetWords.get(0);
        System.out.println(targetWord); //DELETE THIS AFTER
    }

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
        assert !allWords.isEmpty();
        if (allWords.contains(word.toLowerCase()) || allTargetWords.contains(word.toLowerCase())) {
            if (targetWord.equals(word.toLowerCase())) {
                for (int i = 0; i < 5; i++) {
                    backgroundColors[currentLine.ordinal()][i] = Color.green;
                    borderColors[currentLine.ordinal()][i] = Color.green;
                    paintButton(i, Color.green, buttonsList);
                }
                setCurrentLine(LinesEnum.Over);
            } else {
                for (int i = 0; i < 5; i++) {
                    if (letters[currentLine.ordinal()][i].equals(String.valueOf(targetWord.charAt(i)))) {
                        backgroundColors[currentLine.ordinal()][i] = Color.green;
                        borderColors[currentLine.ordinal()][i] = Color.green;
                        paintButton(i, Color.green, buttonsList);
                    } else if (!letters[currentLine.ordinal()][i].equals(String.valueOf(targetWord.charAt(i))) &&
                            targetWord.contains(String.valueOf(word.charAt(i)).toLowerCase())) {
                        backgroundColors[currentLine.ordinal()][i] = Color.yellow;
                        borderColors[currentLine.ordinal()][i] = Color.yellow;
                        paintButton(i, Color.yellow, buttonsList);
                    } else {
                        backgroundColors[currentLine.ordinal()][i] = Color.gray;
                        borderColors[currentLine.ordinal()][i] = Color.gray;
                        paintButton(i, Color.gray, buttonsList);
                    }
                }
                setCurrentLine(nextLine);
            }
        } else {
            noWordFlag = true;
            setChanged();
            notifyObservers(noWordFlag);
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

    private void paintButton(int index, Color color, ArrayList<JButton> buttonsList) {
        for (int i = 0; i < buttonsList.size(); i++) {
            if (buttonsList.get(i).getText().toLowerCase().equals(letters[currentLine.ordinal()][index])) {
                buttonColors.put(i, color);
            }
        }
    }

    public void startOver() {
        init();
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

    public boolean noWordFlag() {
        return noWordFlag;
    }

}
