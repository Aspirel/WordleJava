package com.company.GUI;

import com.company.Utils.LinesEnum;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WordleView extends JFrame implements Observer {
    private final ImageIcon delIcon = new ImageIcon("src/com/company/Resources/delete.png");
    private final ArrayList<JTextField> textFieldsArray = new ArrayList<>() {
        {
            add(new JTextField("word1Line1"));
            add(new JTextField("word2Line1"));
            add(new JTextField("word3Line1"));
            add(new JTextField("word4Line1"));
            add(new JTextField("word5Line1"));
            add(new JTextField("word1Line2"));
            add(new JTextField("word2Line2"));
            add(new JTextField("word3Line2"));
            add(new JTextField("word4Line2"));
            add(new JTextField("word5Line2"));
            add(new JTextField("word1Line3"));
            add(new JTextField("word2Line3"));
            add(new JTextField("word3Line3"));
            add(new JTextField("word4Line3"));
            add(new JTextField("word5Line3"));
            add(new JTextField("word1Line4"));
            add(new JTextField("word2Line4"));
            add(new JTextField("word3Line4"));
            add(new JTextField("word4Line4"));
            add(new JTextField("word5Line4"));
            add(new JTextField("word1Line5"));
            add(new JTextField("word2Line5"));
            add(new JTextField("word3Line5"));
            add(new JTextField("word4Line5"));
            add(new JTextField("word5Line5"));
            add(new JTextField("word1Line6"));
            add(new JTextField("word2Line6"));
            add(new JTextField("word3Line6"));
            add(new JTextField("word4Line6"));
            add(new JTextField("word5Line6"));
        }
    };

    private final ArrayList<JButton> buttonsArray = new ArrayList<>() {
        {
            add(new JButton("Q"));
            add(new JButton("W"));
            add(new JButton("E"));
            add(new JButton("R"));
            add(new JButton("T"));
            add(new JButton("Y"));
            add(new JButton("U"));
            add(new JButton("I"));
            add(new JButton("O"));
            add(new JButton("P"));
            add(new JButton("A"));
            add(new JButton("S"));
            add(new JButton("D"));
            add(new JButton("F"));
            add(new JButton("G"));
            add(new JButton("H"));
            add(new JButton("J"));
            add(new JButton("K"));
            add(new JButton("L"));
            add(new JButton("ENTER"));
            add(new JButton("Z"));
            add(new JButton("X"));
            add(new JButton("C"));
            add(new JButton("V"));
            add(new JButton("B"));
            add(new JButton("N"));
            add(new JButton("M"));
            add(new JButton("DEL"));
        }
    };

    private final JPanel worldlePanel = new JPanel();
    private final JButton startOverButton = new JButton("Start Over");
    private LinesEnum currentLine = LinesEnum.Line1;
    private final WordleModel wordleModel;

    public WordleView(WordleModel wordleModel) {
        this.wordleModel = wordleModel;
        this.setTitle("Wordle");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(worldlePanel);
        //ensures the frame does not have any default layout disrupting the panels settings
        this.setLayout(null);
        //centers the window (java 1.4 and newer)
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        worldlePanel.setBackground(Color.white);

        this.keyboardSetup();
        this.textFieldsSetup();

        //This ensures the window with the text fields gets the focus as soon as it is opened.
        //With this listener, the user doesn't have to click the window or the text field to start typing.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                worldlePanel.requestFocus();
            }
        });
    }

    public void physicalKeyboardListener(KeyListener keyListener) {
        worldlePanel.addKeyListener(keyListener);
    }

    public void digitalKeyboardListener(ActionListener actionListener) {
        //Adds an action listener to every button in the array
        startOverButton.addActionListener(actionListener);
        buttonsArray.forEach(button -> button.addActionListener(actionListener));
    }

    private void textFieldsSetup() {
        JPanel textFieldsPanel = new JPanel();
        JPanel gridPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        buttonPanel.setBounds(0, 0, 800, 30);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBackground(Color.white);
        startOverButton.setBackground(Color.decode("#edeff1"));
        buttonPanel.add(startOverButton);
        worldlePanel.add(buttonPanel);

        textFieldsArray.forEach(field -> {
            field.setFont(new Font("SansSerif", Font.BOLD, 30));
            field.setPreferredSize(new Dimension(70, 70));
            field.setDocument(new UpperCaseTextFilter()); //converts any input into uppercase
            field.setEditable(false);
            field.setEnabled(false);
            field.setBorder(new LineBorder(Color.decode("#edeff1"), 2));
            field.setBackground(Color.white);
            field.setDisabledTextColor(Color.black);
            field.setHorizontalAlignment(JTextField.CENTER);
            textFieldsPanel.add(field);
        });

        gridPanel.setBounds(0, 50, 800, 515);
        gridPanel.setBackground(Color.white);
        textFieldsPanel.setLayout(new GridLayout(6, 5, 5, 5));
        textFieldsPanel.setBackground(Color.white);
        gridPanel.add(textFieldsPanel);
        worldlePanel.add(gridPanel);
    }

    private void keyboardSetup() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 530, 800, 320);
        bottomPanel.setBackground(Color.white);
        JPanel keyboardPanelLine1 = new JPanel();
        keyboardPanelLine1.setBackground(Color.white);
        keyboardPanelLine1.setLayout(new FlowLayout(FlowLayout.CENTER, 9, 2));
        JPanel keyboardPanelLine2 = new JPanel();
        keyboardPanelLine2.setBackground(Color.white);
        keyboardPanelLine2.setLayout(new FlowLayout(FlowLayout.CENTER, 9, 2));
        JPanel keyboardPanelLine3 = new JPanel();
        keyboardPanelLine3.setBackground(Color.white);
        keyboardPanelLine3.setLayout(new FlowLayout(FlowLayout.CENTER, 9, 2));

        int i = 1;
        for (JButton button : buttonsArray) {
            button.setFont(new Font("SansSerif", Font.BOLD, 13));
            button.setBorderPainted(false);
            button.setBackground(Color.decode("#edeff1"));

            if (button.getText().equals("ENTER")) {
                button.setPreferredSize(new Dimension(90, 55));
            } else if (button.getText().equals("DEL")) {
                //unfortunately there is no good way to hide a button's text, so I set it empty instead.
                //This is specific isolated case because I want an icon instead.
                button.setText("");
                button.setIcon(delIcon);
                button.setPreferredSize(new Dimension(60, 55));
            } else {
                button.setPreferredSize(new Dimension(50, 55));
            }

            if (i <= 10) {
                keyboardPanelLine1.add(button);
            } else if (i <= 19) {
                keyboardPanelLine2.add(button);
            } else if (i <= 28) {
                keyboardPanelLine3.add(button);
            }
            i++;
        }

        bottomPanel.add(keyboardPanelLine1);
        bottomPanel.add(keyboardPanelLine2);
        bottomPanel.add(keyboardPanelLine3);
        worldlePanel.add(bottomPanel);
    }

    @Override
    public void update(Observable o, Object arg) {
        String[][] letters = wordleModel.getLetters();
        Color[][] backgroundColors = wordleModel.getBackgroundColors();
        Color[][] borderColors = wordleModel.getBorderColors();
        HashMap<Integer, Color> buttonColors = wordleModel.getButtonColors();

        int i = 0;
        for (int col = 0; col < 6; col++) {
            for (int row = 0; row < 5; row++) {
                textFieldsArray.get(i).setText(letters[col][row]);
                textFieldsArray.get(i).setBackground(backgroundColors[col][row] != null ? backgroundColors[col][row] : Color.white);
                textFieldsArray.get(i).setBorder(borderColors[col][row] != null ? new LineBorder(borderColors[col][row]) :
                        new LineBorder(Color.decode("#edeff1"), 2));
                i++;
            }
        }
        buttonColors.forEach((index, color) -> {
            if (color != null) {
                if (buttonsArray.get(index).getBackground().equals(Color.green) && (color.equals(Color.gray) ||
                        color.equals(Color.yellow))) {
                    buttonsArray.get(index).setBackground(Color.green);
                } else if (buttonsArray.get(index).getBackground().equals(Color.yellow) && color.equals(Color.gray)) {
                    buttonsArray.get(index).setBackground(Color.yellow);
                } else {
                    buttonsArray.get(index).setBackground(color);
                }
            } else {
                buttonsArray.get(index).setBackground(Color.decode("#edeff1"));
            }
        });

        if (arg instanceof LinesEnum) {
            currentLine = (LinesEnum) arg;
        }
        if (arg instanceof Boolean)
            if ((Boolean) arg) {
                JOptionPane.showMessageDialog(worldlePanel, "Not in word list!", "", JOptionPane.WARNING_MESSAGE);
            }
        worldlePanel.repaint();
    }

    public ArrayList<JTextField> getTextFieldsArray() {
        return textFieldsArray;
    }

    public JPanel getWorldlePanel() {
        return worldlePanel;
    }

    public ArrayList<JButton> getButtonsArray() {
        return buttonsArray;
    }
}

