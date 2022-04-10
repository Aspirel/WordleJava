package com.company.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordleController {
    private final WordleModel wordleModel;

    public WordleController(WordleModel wordleModel, WordleView wordleView) {
        this.wordleModel = wordleModel;
        wordleView.wordCheckListener(new WordCheckListener(wordleView));
        wordleView.keyboardListener(new KeyboardActionListener(wordleView));
    }

    class KeyboardActionListener implements ActionListener {
        private final WordleView wordleView;

        KeyboardActionListener(WordleView wordleView) {
            this.wordleView = wordleView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ENTER")) {
                wordleModel.checkWord();
                wordleView.getWorldlePanel().requestFocus();
            } else if (e.getActionCommand().equals("DEL")) {
                wordleModel.deleteLetter();
                wordleView.getWorldlePanel().requestFocus();
            } else {
                wordleModel.fillTextFields(e, null);
                wordleView.getWorldlePanel().requestFocus();
            }
        }
    }

    class WordCheckListener implements KeyListener {
        private final WordleView wordleView;

        WordCheckListener(WordleView wordleView) {
            this.wordleView = wordleView;
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            String acceptableLetters = "qwertyuiopasdfghjklzxcvbnm";
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                wordleModel.checkWord();
                wordleView.getWorldlePanel().requestFocus();
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                wordleModel.deleteLetter();
                wordleView.getWorldlePanel().requestFocus();
            } else {
                if (acceptableLetters.contains(String.valueOf(e.getKeyChar()))) {
                    wordleModel.fillTextFields(null, e);
                    wordleView.getWorldlePanel().requestFocus();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
