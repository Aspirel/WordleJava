package com.company.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordleController {
    private final WordleModel wordleModel;

    public WordleController(WordleModel wordleModel, WordleView wordleView){
        this.wordleModel = wordleModel;
        wordleView.wordCheckListener(new WordCheckListener());
    }

    class WordCheckListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                wordleModel.checkLine();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
