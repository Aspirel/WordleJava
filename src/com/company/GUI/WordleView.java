package com.company.GUI;

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
        //With this listener, the user never has to click the window or the text field to start typing.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                worldlePanel.requestFocus();
            }
        });

        update(wordleModel, null);
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
        JPanel startOverButtonPanel = new JPanel();

        //Create a panel for the start over button, so I can center it in the middle without adding margins.
        startOverButtonPanel.setBounds(0, 0, 800, 30);
        startOverButtonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startOverButtonPanel.setBackground(Color.white);
        startOverButton.setBackground(Color.decode("#edeff1"));
        startOverButtonPanel.add(startOverButton);
        worldlePanel.add(startOverButtonPanel);

        //Text fields setup.
        textFieldsArray.forEach(field -> {
            field.setFont(new Font("SansSerif", Font.BOLD, 30));
            field.setPreferredSize(new Dimension(70, 70));
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

    //Digital keyboard setup. I use three separate lines with flow layouts to give them the look of the
    //original game.
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
        HashMap<String, Color> buttonColors = wordleModel.getButtonColors();

        //Displays a popup dialog message when the word does not exist in the list and when there
        //are not enough letters. Inspired by the original game.
        if (wordleModel.getNotEnoughLetters()) {
            JOptionPane.showMessageDialog(worldlePanel, "Not enough letters!", "", JOptionPane.WARNING_MESSAGE);
        } else if (wordleModel.getNoWordFlagFound()) {
            JOptionPane.showMessageDialog(worldlePanel, "Not in word list!", "", JOptionPane.WARNING_MESSAGE);
        } else {
            //The size of the grid is known and does not need to be dynamic, so I simply loop through the
            //rows and columns and add the values for text and colors.
            int i = 0;
            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 5; col++) {
                    textFieldsArray.get(i).setText(letters[row][col]);
                    textFieldsArray.get(i).setBackground(backgroundColors[row][col] != null ? backgroundColors[row][col] : Color.white);
                    textFieldsArray.get(i).setBorder(borderColors[row][col] != null ? new LineBorder(borderColors[row][col]) :
                            new LineBorder(Color.decode("#edeff1"), 2));
                    i++;
                }
            }

            //Colors the digital keyboard buttons.
            if (buttonColors.isEmpty()) {
                buttonsArray.forEach(b -> b.setBackground(Color.decode("#edeff1")));
            } else {
                for (JButton jButton : buttonsArray) {
                    if (buttonColors.containsKey(jButton.getText().toLowerCase())) {
                        jButton.setBackground(buttonColors.get(jButton.getText().toLowerCase()));
                    }
                }
            }

            //An optional feature. It is used to display game over (only) messages. It's used in here because
            //I want the blocks to be coloured before displaying the message and not the other way around.
            if (wordleModel.getVictory()) {
                JOptionPane.showMessageDialog(worldlePanel, "Congratulations! You've Won!", "Victory!",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (wordleModel.getGameOver()) {
                JOptionPane.showMessageDialog(worldlePanel, "The word was \"" + wordleModel.getTargetWord() + "\"",
                        "Game Over!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public JPanel getWorldlePanel() {
        return worldlePanel;
    }
}