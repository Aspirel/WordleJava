package com.company.GUI;

import com.company.Utils.LineEnums;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.Stream;

public class WordleView extends JFrame {
    private JTextField word1Line1, word2Line1, word3Line1, word4Line1, word5Line1, word1Line2, word2Line2,
            word3Line2, word4Line2, word5Line2, word1Line3, word2Line3, word3Line3, word4Line3, word5Line3,
            word1Line4, word2Line4, word3Line4, word4Line4, word5Line4, word1Line5, word2Line5, word3Line5,
            word4Line5, word5Line5, word1Line6, word2Line6, word3Line6, word4Line6, word5Line6;
    private JPanel worldlePanel;
    private JButton startOverButton;
    private JButton qButton, wButton, eButton, rButton, tButton, yButton, uButton, iButton, oButton, pButton,
    aButton, sButton, dButton, fButton, gButton, hButton, jButton, kButton, lButton, zButton, xButton,
            cButton, vButton, bButton, nButton, mButton, enterButton, delButton;
    private JPanel textFieldsPanel;
    private JPanel keysLine2;
    private JPanel keysLine3;
    private JPanel keysLine1;
    private LineEnums currentLine = LineEnums.Line1;
    private JTextField focusedField;

    public WordleView() {
        this.setTitle("Wordle");
        this.setSize(900,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(worldlePanel);
        this.fieldsSetup();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                worldlePanel.requestFocus();
            }
        });
    }

    public void restart(){
        this.fieldsSetup();
        getWord1Line1().requestFocus();
        focusedField = word1Line1;
    }

    public void getFields(){
        Container container = textFieldsPanel;
        Stream.of(container.getComponents())
                .filter(c -> c instanceof JTextField)
                .map(c -> ((JTextField) c).getText())
                .forEach(System.out::println);
    }

    public void wordCheckListener(KeyListener keyListener) {
        assert word5Line1 != null;
        worldlePanel.addKeyListener(keyListener);
    }

    public void keyboardListener(ActionListener actionListener) {
        startOverButton.addActionListener(actionListener);
        qButton.addActionListener(actionListener);
        wButton.addActionListener(actionListener);
        eButton.addActionListener(actionListener);
        rButton.addActionListener(actionListener);
        tButton.addActionListener(actionListener);
        yButton.addActionListener(actionListener);
        uButton.addActionListener(actionListener);
        iButton.addActionListener(actionListener);
        oButton.addActionListener(actionListener);
        pButton.addActionListener(actionListener);
        aButton.addActionListener(actionListener);
        sButton.addActionListener(actionListener);
        dButton.addActionListener(actionListener);
        fButton.addActionListener(actionListener);
        gButton.addActionListener(actionListener);
        hButton.addActionListener(actionListener);
        jButton.addActionListener(actionListener);
        kButton.addActionListener(actionListener);
        lButton.addActionListener(actionListener);
        enterButton.addActionListener(actionListener);
        zButton.addActionListener(actionListener);
        xButton.addActionListener(actionListener);
        cButton.addActionListener(actionListener);
        vButton.addActionListener(actionListener);
        bButton.addActionListener(actionListener);
        nButton.addActionListener(actionListener);
        mButton.addActionListener(actionListener);
        delButton.addActionListener(actionListener);
    }

    private void fieldsSetup(){
        //line1
        word1Line1.setDocument(new TextFieldHandler());
        word2Line1.setDocument(new TextFieldHandler());
        word3Line1.setDocument(new TextFieldHandler());
        word4Line1.setDocument(new TextFieldHandler());
        word5Line1.setDocument(new TextFieldHandler());
        //line2
        word1Line2.setDocument(new TextFieldHandler());
        word2Line2.setDocument(new TextFieldHandler());
        word3Line2.setDocument(new TextFieldHandler());
        word4Line2.setDocument(new TextFieldHandler());
        word5Line2.setDocument(new TextFieldHandler());
        //line3
        word1Line3.setDocument(new TextFieldHandler());
        word2Line3.setDocument(new TextFieldHandler());
        word3Line3.setDocument(new TextFieldHandler());
        word4Line3.setDocument(new TextFieldHandler());
        word5Line3.setDocument(new TextFieldHandler());
        //line4
        word1Line4.setDocument(new TextFieldHandler());
        word2Line4.setDocument(new TextFieldHandler());
        word3Line4.setDocument(new TextFieldHandler());
        word4Line4.setDocument(new TextFieldHandler());
        word5Line4.setDocument(new TextFieldHandler());
        //line 5
        word1Line5.setDocument(new TextFieldHandler());
        word2Line5.setDocument(new TextFieldHandler());
        word3Line5.setDocument(new TextFieldHandler());
        word4Line5.setDocument(new TextFieldHandler());
        word5Line5.setDocument(new TextFieldHandler());
        //line 6
        word1Line6.setDocument(new TextFieldHandler());
        word2Line6.setDocument(new TextFieldHandler());
        word3Line6.setDocument(new TextFieldHandler());
        word4Line6.setDocument(new TextFieldHandler());
        word5Line6.setDocument(new TextFieldHandler());
    }

    public LineEnums getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(LineEnums currentLine) {
        this.currentLine = currentLine;
    }

    public JTextField getWord1Line1() {
        return word1Line1;
    }

    public JTextField getWord2Line1() {
        return word2Line1;
    }

    public JTextField getWord3Line1() {
        return word3Line1;
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

    public JTextField getFocusedField() {
        return focusedField;
    }

    public void setFocusedField(JTextField focusedField) {
        this.focusedField = focusedField;
    }

    public JPanel getWorldlePanel() {
        return worldlePanel;
    }
}
