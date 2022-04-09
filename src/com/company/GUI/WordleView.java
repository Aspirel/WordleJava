package com.company.GUI;

import com.company.Utils.LineEnums;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class WordleView extends JFrame {
    private final ImageIcon delIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("delete.png")));
    private JTextField  word4Line1, word5Line1, word1Line2, word2Line2, word3Line2,
            word4Line2, word5Line2, word1Line3, word2Line3, word3Line3, word4Line3, word5Line3, word1Line4, word2Line4,
            word3Line4, word4Line4, word5Line4, word1Line5, word2Line5, word3Line5, word4Line5, word5Line5, word1Line6,
            word2Line6, word3Line6, word4Line6, word5Line6;

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

    private final ArrayList<JButton> buttonsLine1 = new ArrayList<>(){
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
            }
    };

    private final ArrayList<JButton> buttonsLine2 = new ArrayList<>(){
        {
            add(new JButton("A"));
            add(new JButton("S"));
            add(new JButton("D"));
            add(new JButton("F"));
            add(new JButton("G"));
            add(new JButton("H"));
            add(new JButton("J"));
            add(new JButton("K"));
            add(new JButton("L"));
        }
    };

    private final ArrayList<JButton> buttonsLine3 = new ArrayList<>(){
        {
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
    private LineEnums currentLine = LineEnums.Line1;


    public WordleView() {
        this.setTitle("Wordle");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(worldlePanel);
        //ensures the frame does not have any default layout disrupting the panels settings
        this.setLayout(null);
        //centers the window (java 1.4 and newer)
        this.setLocationRelativeTo(null);
        worldlePanel.setBackground(Color.white);

        this.keyboardSetup();
        this.textFieldsSetup();


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                worldlePanel.requestFocus();
            }
        });
    }

    public void wordCheckListener(KeyListener keyListener) {
        assert worldlePanel != null;
        worldlePanel.addKeyListener(keyListener);
    }

    public void keyboardListener(ActionListener actionListener) {
        startOverButton.addActionListener(e -> {
            if (currentLine != LineEnums.Line1 || textFieldsArray.get(0).getText().length() > 0) {
                dispose();
                WordleView wordleView = new WordleView();
                WordleModel wordleModel = new WordleModel(wordleView);
                WordleController wordleController = new WordleController(wordleModel, wordleView);
                wordleView.setVisible(true);
            } else {
                worldlePanel.requestFocus();
            }
        });
        //Adds an action listener to every button in the array
        buttonsLine1.forEach(button -> button.addActionListener(actionListener));
        buttonsLine2.forEach(button -> button.addActionListener(actionListener));
        buttonsLine3.forEach(button -> button.addActionListener(actionListener));
    }

    private void textFieldsSetup() {
        JPanel textFieldsPanel = new JPanel();
        JPanel gridPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        buttonPanel.setBounds(0, 0, 800, 30);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBackground(Color.white);
        startOverButton.setSize(new Dimension(200, 30));
        startOverButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startOverButton.setBackground(Color.white);
        worldlePanel.add(buttonPanel);
        buttonPanel.add(startOverButton);

        textFieldsArray.forEach(field -> {
            field.setFont(new Font("SansSerif", Font.BOLD, 30));
            field.setPreferredSize(new Dimension(70, 70));
            field.setDocument(new UpperCaseTextFilter());
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

        buttonsLine1.forEach(button -> {
            button.setFont(new Font("SansSerif", Font.BOLD, 13));
            button.setPreferredSize(new Dimension(50, 55));
            button.setBorderPainted(false);
            button.setBackground(Color.decode("#edeff1"));
            keyboardPanelLine1.add(button);
        });

        buttonsLine2.forEach(button -> {
            button.setFont(new Font("SansSerif", Font.BOLD, 14));
            button.setPreferredSize(new Dimension(50, 55));
            button.setBorderPainted(false);
            button.setBackground(Color.decode("#edeff1"));
//            button.setBorder(new RoundedBorder(10));
            keyboardPanelLine2.add(button);
        });

        buttonsLine3.forEach(button -> {
            button.setFont(new Font("SansSerif", Font.BOLD, 13));
            if (button.getText().equals("ENTER")){
                button.setPreferredSize(new Dimension(90, 55));
            }else if(button.getText().equals("DEL")){
                button.setText(null);
                button.setIcon(delIcon);
                button.setPreferredSize(new Dimension(60, 55));
            }else {
                button.setPreferredSize(new Dimension(50, 55));
            }
            button.setBorderPainted(false);
            button.setBackground(Color.decode("#edeff1"));
            keyboardPanelLine3.add(button);
        });

        bottomPanel.add(keyboardPanelLine1);
        bottomPanel.add(keyboardPanelLine2);
        bottomPanel.add(keyboardPanelLine3);
        worldlePanel.add(bottomPanel);
    }

    public ArrayList<JTextField> getTextFieldsArray() {
        return textFieldsArray;
    }

    public LineEnums getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(LineEnums currentLine) {
        this.currentLine = currentLine;
    }

    public JTextField getWord4Line1() {
        return word4Line1;
    }

    public JTextField getWord5Line1() {
        return word5Line1;
    }

    public JTextField getWord1Line2() {
        return word1Line2;
    }

    public JTextField getWord2Line2() {
        return word2Line2;
    }

    public JTextField getWord3Line2() {
        return word3Line2;
    }

    public JTextField getWord4Line2() {
        return word4Line2;
    }

    public JTextField getWord5Line2() {
        return word5Line2;
    }

    public JTextField getWord1Line3() {
        return word1Line3;
    }

    public JTextField getWord2Line3() {
        return word2Line3;
    }

    public JTextField getWord3Line3() {
        return word3Line3;
    }

    public JTextField getWord4Line3() {
        return word4Line3;
    }

    public JTextField getWord5Line3() {
        return word5Line3;
    }

    public JTextField getWord1Line4() {
        return word1Line4;
    }

    public JTextField getWord2Line4() {
        return word2Line4;
    }

    public JTextField getWord3Line4() {
        return word3Line4;
    }

    public JTextField getWord4Line4() {
        return word4Line4;
    }

    public JTextField getWord5Line4() {
        return word5Line4;
    }

    public JTextField getWord1Line5() {
        return word1Line5;
    }

    public JTextField getWord2Line5() {
        return word2Line5;
    }

    public JTextField getWord3Line5() {
        return word3Line5;
    }

    public JTextField getWord4Line5() {
        return word4Line5;
    }

    public JTextField getWord5Line5() {
        return word5Line5;
    }

    public JTextField getWord1Line6() {
        return word1Line6;
    }

    public JTextField getWord2Line6() {
        return word2Line6;
    }

    public JTextField getWord3Line6() {
        return word3Line6;
    }

    public JTextField getWord4Line6() {
        return word4Line6;
    }

    public JTextField getWord5Line6() {
        return word5Line6;
    }

    public JPanel getWorldlePanel() {
        return worldlePanel;
    }

    private static class RoundedBorder implements Border {

        private int radius;


        RoundedBorder(int radius) {
            this.radius = radius;
        }


        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }


        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
}

