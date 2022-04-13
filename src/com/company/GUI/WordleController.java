package com.company.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordleController {
    private final WordleModel wordleModel;

    public WordleController(WordleModel wordleModel, WordleView wordleView) {
        this.wordleModel = wordleModel;
        wordleView.physicalKeyboardListener(new PhysicalKeyboardListener(wordleView));
        wordleView.digitalKeyboardListener(new DigitalKeyboardActionListener(wordleView));
    }

    class DigitalKeyboardActionListener implements ActionListener {
        private final WordleView wordleView;

        DigitalKeyboardActionListener(WordleView wordleView) {
            this.wordleView = wordleView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ENTER")) {
                wordleModel.processWord(wordleView.getTextFieldsArray(), wordleView.getButtonsArray());
                wordleView.getWorldlePanel().requestFocus();
            } else if (e.getActionCommand().equals("")) {
                //Using an empty string for the delete button because there is no good way to hide the text,
                //and I need to show the icon and not the text. It's being set empty where the icon is set
                //but still need to find the button.
                wordleModel.deleteLetter(wordleView.getTextFieldsArray());
                wordleView.getWorldlePanel().requestFocus();
            } else if (e.getActionCommand().equals("Start Over")) {
                wordleModel.startOver();
                wordleView.getWorldlePanel().requestFocus();
            } else {
                wordleModel.addLetter(wordleView.getTextFieldsArray(), e, null);
                wordleView.getWorldlePanel().requestFocus();
            }
        }
    }

    class PhysicalKeyboardListener implements KeyListener {
        private final WordleView wordleView;

        PhysicalKeyboardListener(WordleView wordleView) {
            this.wordleView = wordleView;
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            String acceptableLetters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                wordleModel.processWord(wordleView.getTextFieldsArray(), wordleView.getButtonsArray());
                wordleView.getWorldlePanel().requestFocus();
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                wordleModel.deleteLetter(wordleView.getTextFieldsArray());
                wordleView.getWorldlePanel().requestFocus();
            } else {
                if (acceptableLetters.contains(String.valueOf(e.getKeyChar()))) {
                    wordleModel.addLetter(wordleView.getTextFieldsArray(), null, e);
                    wordleView.getWorldlePanel().requestFocus();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
