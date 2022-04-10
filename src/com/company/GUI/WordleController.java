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
                wordleModel.processWord();
                wordleView.getWorldlePanel().requestFocus();
            } else if (e.getActionCommand().equals("")) {
                //Using an empty string for the delete button because there is no good way to hide the text,
                //and I need to show the icon and not the text. It's being set empty where the icon is set
                //but still need to find the button.
                wordleModel.deleteLetter();
                wordleView.getWorldlePanel().requestFocus();
            } else {
                wordleModel.addLetter(e, null);
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
                wordleModel.processWord();
                wordleView.getWorldlePanel().requestFocus();
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                wordleModel.deleteLetter();
                wordleView.getWorldlePanel().requestFocus();
            } else {
                if (acceptableLetters.contains(String.valueOf(e.getKeyChar()))) {
                    wordleModel.addLetter(null, e);
                    wordleView.getWorldlePanel().requestFocus();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
