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

    //Both keyboard listeners include requestFocus(). Everytime a function from the model is called,
    //a requestFocus function is called for the game panel. With the user not having to click anything
    //on the board and just type directly physically or with the buttons, if these focus functions
    //are not called and the user clicks somewhere on the board, the text fields will no longer be
    // automatically focused and letters won't be added.
    class DigitalKeyboardActionListener implements ActionListener {
        private final WordleView wordleView;

        DigitalKeyboardActionListener(WordleView wordleView) {
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
                //but still need to find the button. Nothing else is empty so there is no conflict.
                wordleModel.deleteLetter();
                wordleView.getWorldlePanel().requestFocus();
            } else if (e.getActionCommand().equals("Start Over")) {
                wordleModel.startOver();
                wordleView.getWorldlePanel().requestFocus();
            } else {
                wordleModel.addLetter(String.valueOf(e.getActionCommand()));
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
                wordleModel.processWord();
                wordleView.getWorldlePanel().requestFocus();
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                wordleModel.deleteLetter();
                wordleView.getWorldlePanel().requestFocus();
            } else {
                if (acceptableLetters.contains(String.valueOf(e.getKeyChar()))) {
                    wordleModel.addLetter(String.valueOf(e.getKeyChar()));
                    wordleView.getWorldlePanel().requestFocus();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
