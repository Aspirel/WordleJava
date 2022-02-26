package com.company.GUI;

import javax.swing.*;
import java.awt.event.KeyListener;

public class WordleView extends JFrame{
    private JTextField word1Line4;
    private JTextField word2Line4;
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

    public WordleView() {
        this.setTitle("Wordle");
        this.setSize(550,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(worldlePanel);
    }

    void wordCheckListener(KeyListener keyListener) {
        assert word1Line1 != null;
        assert word2Line1 != null;
        word2Line1.addKeyListener(keyListener);
    }

    public String getWord1Line1() {
        return word1Line1.getText();
    }

    public void setWord1Line1(JTextField word1Line1) {
        this.word1Line1.setText(String.valueOf(word1Line1));
    }

    public String getWord2Line1() {
        return word2Line1.getText();
    }

    public void setWord2Line1(JTextField word2Line1) {
        this.word2Line1.setText(String.valueOf(word2Line1));
    }

    public String getWord3Line1() {
        return word3Line1.getText();
    }

    public void setWord3Line1(JTextField word3Line1) {
        this.word3Line1.setText(String.valueOf(word3Line1));
    }

    public String getWord4Line1() {
        return word4Line1.getText();
    }

    public void setWord4Line1(JTextField word4Line1) {
        this.word4Line1.setText(String.valueOf(word4Line1));
    }

    public String getWord5Line1() {
        return word5Line1.getText();
    }

    public void setWord5Line1(JTextField word5Line1) {
        this.word5Line1.setText(String.valueOf(word5Line1));
    }

    public String getWord1Line2() {
        return word1Line2.getText();
    }

    public void setWord1Line2(JTextField word1Line2) {
        this.word1Line2.setText(String.valueOf(word1Line2));
    }

    public String getWord2Line2() {
        return word2Line2.getText();
    }

    public void setWord2Line2(JTextField word2Line2) {
        this.word2Line2.setText(String.valueOf(word2Line2));
    }

    public String getWord3Line2() {
        return word3Line2.getText();
    }

    public void setWord3Line2(JTextField word3Line2) {
        this.word3Line2.setText(String.valueOf(word3Line2));
    }

    public String getWord4Line2() {
        return word4Line2.getText();
    }

    public void setWord4Line2(JTextField word4Line2) {
        this.word4Line2.setText(String.valueOf(word4Line2));
    }

    public String getWord5Line2() {
        return word5Line2.getText();
    }

    public void setWord5Line2(JTextField word5Line2) {
        this.word5Line2.setText(String.valueOf(word5Line2));
    }

    public String getWord1Line3() {
        return word1Line3.getText();
    }

    public void setWord1Line3(JTextField word1Line3) {
        this.word1Line3.setText(String.valueOf(word1Line3));
    }

    public String getWord2Line3() {
        return word2Line3.getText();
    }

    public void setWord2Line3(JTextField word2Line3) {
        this.word2Line3.setText(String.valueOf(word2Line3));
    }

    public String getWord3Line3() {
        return word3Line3.getText();
    }

    public void setWord3Line3(JTextField word3Line3) {
        this.word3Line3.setText(String.valueOf(word3Line3));
    }

    public String getWord4Line3() {
        return word4Line3.getText();
    }

    public void setWord4Line3(JTextField word4Line3) {
        this.word4Line3.setText(String.valueOf(word4Line3));
    }

    public String getWord5Line3() {
        return word5Line3.getText();
    }

    public void setWord5Line3(JTextField word5Line3) {
        this.word5Line3.setText(String.valueOf(word5Line3));
    }

    public String getWord1Line4() {
        return word1Line4.getText();
    }

    public void setWord1Line4(JTextField word1Line4) {
        this.word1Line4.setText(String.valueOf(word1Line4));
    }

    public String getWord2Line4() {
        return word2Line4.getText();
    }

    public void setWord2Line4(JTextField word2Line4) {
        this.word2Line4.setText(String.valueOf(word2Line4));
    }

    public String getWord3Line4() {
        return word3Line4.getText();
    }

    public void setWord3Line4(JTextField word3Line4) {
        this.word3Line4.setText(String.valueOf(word3Line4));
    }

    public String getWord4Line4() {
        return word4Line4.getText();
    }

    public void setWord4Line4(JTextField word4Line4) {
        this.word4Line4.setText(String.valueOf(word4Line4));
    }

    public String getWord5Line4() {
        return word5Line4.getText();
    }

    public void setWord5Line4(JTextField word5Line4) {
        this.word5Line4.setText(String.valueOf(word5Line4));
    }

    public String getWord1Line5() {
        return word1Line5.getText();
    }

    public void setWord1Line5(JTextField word1Line5) {
        this.word1Line5.setText(String.valueOf(word1Line5));
    }

    public String getWord2Line5() {
        return word2Line5.getText();
    }

    public void setWord2Line5(JTextField word2Line5) {
        this.word2Line5.setText(String.valueOf(word2Line5));
    }

    public String getWord3Line5() {
        return word3Line5.getText();
    }

    public void setWord3Line5(JTextField word3Line5) {
        this.word3Line5.setText(String.valueOf(word3Line5));
    }

    public String getWord4Line5() {
        return word4Line5.getText();
    }

    public void setWord4Line5(JTextField word4Line5) {
        this.word4Line5.setText(String.valueOf(word4Line5));
    }

    public String getWord5Line5() {
        return word5Line5.getText();
    }

    public void setWord5Line5(JTextField word5Line5) {
        this.word5Line5.setText(String.valueOf(word5Line5));
    }

    public String getWord1Line6() {
        return word1Line6.getText();
    }

    public void setWord1Line6(JTextField word1Line6) {
        this.word1Line6.setText(String.valueOf(word1Line6));
    }

    public String getWord2Line6() {
        return word2Line6.getText();
    }

    public void setWord2Line6(JTextField word2Line6) {
        this.word2Line6.setText(String.valueOf(word2Line6));
    }

    public String getWord3Line6() {
        return word3Line6.getText();
    }

    public void setWord3Line6(JTextField word3Line6) {
        this.word3Line6.setText(String.valueOf(word3Line6));
    }

    public String getWord4Line6() {
        return word4Line6.getText();
    }

    public void setWord4Line6(JTextField word4Line6) {
        this.word4Line6.setText(String.valueOf(word4Line6));
    }

    public String getWord5Line6() {
        return word5Line6.getText();
    }

    public void setWord5Line6(JTextField word5Line6) {
        this.word5Line6.setText(String.valueOf(word5Line6));
    }
}
