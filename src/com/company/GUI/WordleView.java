package com.company.GUI;

import com.company.Utils.LineEnums;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WordleView extends JFrame {
    private JTextField  word4Line1, word5Line1, word1Line2, word2Line2, word3Line2,
            word4Line2, word5Line2, word1Line3, word2Line3, word3Line3, word4Line3, word5Line3, word1Line4, word2Line4,
            word3Line4, word4Line4, word5Line4, word1Line5, word2Line5, word3Line5, word4Line5, word5Line5, word1Line6,
            word2Line6, word3Line6, word4Line6, word5Line6;

    private final ArrayList<JTextField> textArray = new ArrayList<>() {
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

    private final JPanel worldlePanel = new JPanel();
    private final JButton startOverButton = new JButton("Start Over");
    private LineEnums currentLine = LineEnums.Line1;

    private JButton qButton, wButton, eButton, rButton, tButton, yButton, uButton, iButton, oButton, pButton, aButton,
            sButton, dButton, fButton, gButton, hButton, jButton, kButton, lButton, zButton, xButton, cButton, vButton,
            bButton, nButton, mButton, enterButton, delButton;
    private JPanel keysLine2;
    private JPanel keysLine3;
    private JPanel keysLine1;



    public WordleView() {
        this.setTitle("Wordle");
        this.setSize(900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(worldlePanel);
        this.setLayout(null);
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
            if (currentLine != LineEnums.Line1 || textArray.get(0).getText().length() > 0) {
                dispose();
                WordleView wordleView = new WordleView();
                WordleModel wordleModel = new WordleModel(wordleView);
                WordleController wordleController = new WordleController(wordleModel, wordleView);
                wordleView.setVisible(true);
            }else {
                worldlePanel.requestFocus();
            }
        });
//        qButton.addActionListener(actionListener);
//        wButton.addActionListener(actionListener);
//        eButton.addActionListener(actionListener);
//        rButton.addActionListener(actionListener);
//        tButton.addActionListener(actionListener);
//        yButton.addActionListener(actionListener);
//        uButton.addActionListener(actionListener);
//        iButton.addActionListener(actionListener);
//        oButton.addActionListener(actionListener);
//        pButton.addActionListener(actionListener);
//        aButton.addActionListener(actionListener);
//        sButton.addActionListener(actionListener);
//        dButton.addActionListener(actionListener);
//        fButton.addActionListener(actionListener);
//        gButton.addActionListener(actionListener);
//        hButton.addActionListener(actionListener);
//        jButton.addActionListener(actionListener);
//        kButton.addActionListener(actionListener);
//        lButton.addActionListener(actionListener);
//        enterButton.addActionListener(actionListener);
//        zButton.addActionListener(actionListener);
//        xButton.addActionListener(actionListener);
//        cButton.addActionListener(actionListener);
//        vButton.addActionListener(actionListener);
//        bButton.addActionListener(actionListener);
//        nButton.addActionListener(actionListener);
//        mButton.addActionListener(actionListener);
//        delButton.addActionListener(actionListener);
    }

    private void textFieldsSetup() {
        JPanel textFieldsPanel = new JPanel();
        JPanel gridPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        buttonPanel.setBounds(0, 0,900,30);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBackground(Color.white);
        startOverButton.setSize(new Dimension(200, 30));
        startOverButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startOverButton.setBackground(Color.white);
        worldlePanel.add(buttonPanel);
        buttonPanel.add(startOverButton);

        textArray.forEach(field -> {
            field.setFont(new Font("SansSerif", Font.BOLD, 36));
            field.setPreferredSize(new Dimension(80, 80));
            field.setDocument(new TextFieldHandler());
            field.setEditable(false);
            field.setEnabled(false);
            field.setBackground(Color.white);
            field.setDisabledTextColor(Color.black);
            field.setHorizontalAlignment(JTextField.CENTER);
            textFieldsPanel.add(field);
        });

        gridPanel.setBounds(0, 30,900,515);
        gridPanel.setBackground(Color.white);
        textFieldsPanel.setBounds(0, 0, 400, 500);
        textFieldsPanel.setLayout(new GridLayout(6, 5, 5, 5));
        textFieldsPanel.setBackground(Color.white);
        gridPanel.add(textFieldsPanel);
        worldlePanel.add(gridPanel);
    }

    private void keyboardSetup() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 515, 900, 350);
        bottomPanel.setBackground(Color.white);
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setBounds(0, 515, 750, 300);
        keyboardPanel.setLayout(new GridLayout(3, 10, 10, 10));

        //adds the buttons here

        bottomPanel.add(keyboardPanel);
        worldlePanel.add(bottomPanel);
    }

    public ArrayList<JTextField> getTextArray() {
        return textArray;
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
}
