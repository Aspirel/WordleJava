package com.company.GUI;

import com.company.Utils.LineEnums;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WordleView extends JFrame {
    private JTextField word1Line1;
    private JTextField word2Line1;
    private JTextField word3Line1;
    private JTextField word4Line1;
    private JTextField word5Line1;
    private JTextField word1Line2;
    private JTextField word2Line2;
    private JTextField word3Line2;
    private JTextField word4Line2;
    private JTextField word5Line2;
    private JTextField word1Line3;
    private JTextField word2Line3;
    private JTextField word3Line3;
    private JTextField word4Line3;
    private JTextField word5Line3;
    private JTextField word1Line4;
    private JTextField word2Line4;
    private JTextField word3Line4;
    private JTextField word4Line4;
    private JTextField word5Line4;
    private JTextField word1Line5;
    private JTextField word2Line5;
    private JTextField word3Line5;
    private JTextField word4Line5;
    private JTextField word5Line5;
    private JTextField word1Line6;
    private JTextField word2Line6;
    private JTextField word3Line6;
    private JTextField word4Line6;
    private JTextField word5Line6;
    private JPanel worldlePanel;
    private JButton startOverButton;
    private LineEnums currentLine = LineEnums.Line1;

    public WordleView() {
        this.setTitle("Wordle");
        this.setSize(550,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(worldlePanel);
        this.fieldsSetup();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                word1Line1.requestFocus();
            }
        });
    }

    public void wordCheckListener(KeyListener keyListener) {
        assert word5Line1 != null;
        word5Line1.addKeyListener(keyListener);
        assert word5Line2 != null;
        word5Line2.addKeyListener(keyListener);
        assert word5Line3 != null;
        word5Line3.addKeyListener(keyListener);
        assert word5Line4 != null;
        word5Line4.addKeyListener(keyListener);
        assert word5Line5 != null;
        word5Line5.addKeyListener(keyListener);
        assert word5Line6 != null;
        word5Line6.addKeyListener(keyListener);
    }

    private void fieldsSetup(){
        this.enableLineOne(true);
        this.enableLineTwo(false);
        this.enableLineThree(false);
        this.enableLineFour(false);
        this.enableLineFive(false);
        this.enableLineSix(false);
        //line1
        word1Line1.setDocument(new TextFieldHandler(word1Line1, false));
        word2Line1.setDocument(new TextFieldHandler(word2Line1, false));
        word3Line1.setDocument(new TextFieldHandler(word3Line1, false));
        word4Line1.setDocument(new TextFieldHandler(word4Line1, false));
        word5Line1.setDocument(new TextFieldHandler(word5Line1, true));
        //line2
        word1Line2.setDocument(new TextFieldHandler(word1Line2, false));
        word2Line2.setDocument(new TextFieldHandler(word2Line2, false));
        word3Line2.setDocument(new TextFieldHandler(word3Line2, false));
        word4Line2.setDocument(new TextFieldHandler(word4Line2, false));
        word5Line2.setDocument(new TextFieldHandler(word5Line2, true));
        //line3
        word1Line3.setDocument(new TextFieldHandler(word1Line3, false));
        word2Line3.setDocument(new TextFieldHandler(word2Line3, false));
        word3Line3.setDocument(new TextFieldHandler(word3Line3, false));
        word4Line3.setDocument(new TextFieldHandler(word4Line3, false));
        word5Line3.setDocument(new TextFieldHandler(word5Line3, true));
        //line4
        word1Line4.setDocument(new TextFieldHandler(word1Line4, false));
        word2Line4.setDocument(new TextFieldHandler(word2Line4, false));
        word3Line4.setDocument(new TextFieldHandler(word3Line4, false));
        word4Line4.setDocument(new TextFieldHandler(word4Line4, false));
        word5Line4.setDocument(new TextFieldHandler(word5Line4, true));
        //line 5
        word1Line5.setDocument(new TextFieldHandler(word1Line5, false));
        word2Line5.setDocument(new TextFieldHandler(word2Line5, false));
        word3Line5.setDocument(new TextFieldHandler(word3Line5, false));
        word4Line5.setDocument(new TextFieldHandler(word4Line5, false));
        word5Line5.setDocument(new TextFieldHandler(word5Line5, true));
        //line 6
        word1Line6.setDocument(new TextFieldHandler(word1Line6, false));
        word2Line6.setDocument(new TextFieldHandler(word2Line6, false));
        word3Line6.setDocument(new TextFieldHandler(word3Line6, false));
        word4Line6.setDocument(new TextFieldHandler(word4Line6, false));
        word5Line6.setDocument(new TextFieldHandler(word5Line6, true));
    }

    public void enableLineOne(boolean enabled){
        word1Line1.setEditable(enabled);
        word2Line1.setEditable(enabled);
        word3Line1.setEditable(enabled);
        word4Line1.setEditable(enabled);
        word5Line1.setEditable(enabled);
    }

    public void enableLineTwo(boolean enabled){
        word1Line2.setEditable(enabled);
        word2Line2.setEditable(enabled);
        word3Line2.setEditable(enabled);
        word4Line2.setEditable(enabled);
        word5Line2.setEditable(enabled);
    }

    public void enableLineThree(boolean enabled){
        word1Line3.setEditable(enabled);
        word2Line3.setEditable(enabled);
        word3Line3.setEditable(enabled);
        word4Line3.setEditable(enabled);
        word5Line3.setEditable(enabled);
    }

    public void enableLineFour(boolean enabled){
        word1Line4.setEditable(enabled);
        word2Line4.setEditable(enabled);
        word3Line4.setEditable(enabled);
        word4Line4.setEditable(enabled);
        word5Line4.setEditable(enabled);
    }

    public void enableLineFive(boolean enabled){
        word1Line5.setEditable(enabled);
        word2Line5.setEditable(enabled);
        word3Line5.setEditable(enabled);
        word4Line5.setEditable(enabled);
        word5Line5.setEditable(enabled);
    }

    public void enableLineSix(boolean enabled){
        word1Line6.setEditable(enabled);
        word2Line6.setEditable(enabled);
        word3Line6.setEditable(enabled);
        word4Line6.setEditable(enabled);
        word5Line6.setEditable(enabled);
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
}
