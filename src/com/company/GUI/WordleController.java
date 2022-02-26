package com.company.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordleController {
    private final WordleModel wordleModel;
    private final WordleView wordleView;

    public WordleController(WordleModel wordleModel, WordleView wordleView){
        this.wordleModel = wordleModel;
        this.wordleView = wordleView;
        this.wordleView.wordCheckListener(new WordCheckListener());
    }

    class WordCheckListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            String letter1, letter2;

            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                try {
                    letter1 = String.valueOf(wordleView.getWord1Line1());
                    letter2 = String.valueOf(wordleView.getWord2Line1());

                    wordleModel.checkWord(letter1, letter2);
                    System.out.println(wordleModel.getCorrectWord());
                } catch (Exception ex){
                    System.out.println("Wrong type of input");
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            Character letter = e.getKeyChar();
            System.out.println(letter);
        }
    }
}
