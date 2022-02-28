package com.company.GUI;

import com.company.Utils.LineEnums;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

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
            String acceptableLetters = "qwertyuiopasdfghjklzxcvbnm";
            if (Objects.equals(e.getActionCommand(), "Start Over")) {
                wordleView.restart();
            } else if (e.getActionCommand().equals("ENTER")) {
                wordleModel.checkWord();
            } else if (e.getActionCommand().equals("DEL")) {
                wordleModel.deleteLetter();
            } else {
                if (acceptableLetters.contains(e.getActionCommand())) {
                    if (wordleView.getCurrentLine() == LineEnums.Line1) {
                        if (wordleView.getWord1Line1().getText().length() < 1) {
                            wordleView.getWord1Line1().setEnabled(true);
                            wordleView.getWord1Line1().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line1().getText().length() >= 1 &&
                                wordleView.getWord2Line1().getText().length() < 1) {
                            wordleView.getWord2Line1().setEnabled(true);
                            wordleView.getWord2Line1().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line1().getText().length() >= 1 &&
                                wordleView.getWord3Line1().getText().length() < 1) {
                            wordleView.getWord3Line1().setEnabled(true);
                            wordleView.getWord3Line1().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line1().getText().length() >= 1 &&
                                wordleView.getWord4Line1().getText().length() < 1) {
                            wordleView.getWord4Line1().setEnabled(true);
                            wordleView.getWord4Line1().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line1().getText().length() >= 1 &&
                                wordleView.getWord5Line1().getText().length() < 1) {
                            wordleView.getWord5Line1().setEnabled(true);
                            wordleView.getWord5Line1().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }
                    //line2
                    if (wordleView.getCurrentLine() == LineEnums.Line2) {
                        if (wordleView.getWord1Line2().getText().length() < 1) {
                            wordleView.getWord1Line2().setEnabled(true);
                            wordleView.getWord1Line2().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line2().getText().length() >= 1 &&
                                wordleView.getWord2Line2().getText().length() < 1) {
                            wordleView.getWord2Line2().setEnabled(true);
                            wordleView.getWord2Line2().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line2().getText().length() >= 1 &&
                                wordleView.getWord3Line2().getText().length() < 1) {
                            wordleView.getWord3Line2().setEnabled(true);
                            wordleView.getWord3Line2().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line2().getText().length() >= 1 &&
                                wordleView.getWord4Line2().getText().length() < 1) {
                            wordleView.getWord4Line2().setEnabled(true);
                            wordleView.getWord4Line2().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line2().getText().length() >= 1 &&
                                wordleView.getWord5Line2().getText().length() < 1) {
                            wordleView.getWord5Line2().setEnabled(true);
                            wordleView.getWord5Line2().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line3
                    if (wordleView.getCurrentLine() == LineEnums.Line3) {
                        if (wordleView.getWord1Line3().getText().length() < 1) {
                            wordleView.getWord1Line3().setEnabled(true);
                            wordleView.getWord1Line3().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line3().getText().length() >= 1 &&
                                wordleView.getWord2Line3().getText().length() < 1) {
                            wordleView.getWord2Line3().setEnabled(true);
                            wordleView.getWord2Line3().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line3().getText().length() >= 1 &&
                                wordleView.getWord3Line3().getText().length() < 1) {
                            wordleView.getWord3Line3().setEnabled(true);
                            wordleView.getWord3Line3().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line3().getText().length() >= 1 &&
                                wordleView.getWord4Line3().getText().length() < 1) {
                            wordleView.getWord4Line3().setEnabled(true);
                            wordleView.getWord4Line3().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line3().getText().length() >= 1 &&
                                wordleView.getWord5Line3().getText().length() < 1) {
                            wordleView.getWord5Line3().setEnabled(true);
                            wordleView.getWord5Line3().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line4
                    if (wordleView.getCurrentLine() == LineEnums.Line4) {
                        if (wordleView.getWord1Line4().getText().length() < 1) {
                            wordleView.getWord1Line4().setEnabled(true);
                            wordleView.getWord1Line4().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line4().getText().length() >= 1 &&
                                wordleView.getWord2Line4().getText().length() < 1) {
                            wordleView.getWord2Line4().setEnabled(true);
                            wordleView.getWord2Line4().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line4().getText().length() >= 1 &&
                                wordleView.getWord3Line4().getText().length() < 1) {
                            wordleView.getWord3Line4().setEnabled(true);
                            wordleView.getWord3Line4().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line4().getText().length() >= 1 &&
                                wordleView.getWord4Line4().getText().length() < 1) {
                            wordleView.getWord4Line4().setEnabled(true);
                            wordleView.getWord4Line4().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line4().getText().length() >= 1 &&
                                wordleView.getWord5Line4().getText().length() < 1) {
                            wordleView.getWord5Line4().setEnabled(true);
                            wordleView.getWord5Line4().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line5
                    if (wordleView.getCurrentLine() == LineEnums.Line5) {
                        if (wordleView.getWord1Line5().getText().length() < 1) {
                            wordleView.getWord1Line5().setEnabled(true);
                            wordleView.getWord1Line5().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line5().getText().length() >= 1 &&
                                wordleView.getWord2Line5().getText().length() < 1) {
                            wordleView.getWord2Line5().setEnabled(true);
                            wordleView.getWord2Line5().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line5().getText().length() >= 1 &&
                                wordleView.getWord3Line5().getText().length() < 1) {
                            wordleView.getWord3Line5().setEnabled(true);
                            wordleView.getWord3Line5().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line5().getText().length() >= 1 &&
                                wordleView.getWord4Line5().getText().length() < 1) {
                            wordleView.getWord4Line5().setEnabled(true);
                            wordleView.getWord4Line5().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line5().getText().length() >= 1 &&
                                wordleView.getWord5Line5().getText().length() < 1) {
                            wordleView.getWord5Line5().setEnabled(true);
                            wordleView.getWord5Line5().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line6
                    if (wordleView.getCurrentLine() == LineEnums.Line6) {
                        if (wordleView.getWord1Line6().getText().length() < 1) {
                            wordleView.getWord1Line6().setEnabled(true);
                            wordleView.getWord1Line6().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line6().getText().length() >= 1 &&
                                wordleView.getWord2Line6().getText().length() < 1) {
                            wordleView.getWord2Line6().setEnabled(true);
                            wordleView.getWord2Line6().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line6().getText().length() >= 1 &&
                                wordleView.getWord3Line6().getText().length() < 1) {
                            wordleView.getWord3Line6().setEnabled(true);
                            wordleView.getWord3Line6().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line6().getText().length() >= 1 &&
                                wordleView.getWord4Line6().getText().length() < 1) {
                            wordleView.getWord4Line6().setEnabled(true);
                            wordleView.getWord4Line6().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line6().getText().length() >= 1 &&
                                wordleView.getWord5Line6().getText().length() < 1) {
                            wordleView.getWord5Line6().setEnabled(true);
                            wordleView.getWord5Line6().setText(String.valueOf(e.getActionCommand()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }
                }
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
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                wordleModel.deleteLetter();
            } else {
                if(acceptableLetters.contains(String.valueOf(e.getKeyChar()))) {
                    //line1
                    if (wordleView.getCurrentLine() == LineEnums.Line1) {
                        if (wordleView.getWord1Line1().getText().length() < 1) {
                            wordleView.getWord1Line1().setEnabled(true);
                            wordleView.getWord1Line1().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line1().getText().length() >= 1 &&
                                wordleView.getWord2Line1().getText().length() < 1) {
                            wordleView.getWord2Line1().setEnabled(true);
                            wordleView.getWord2Line1().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line1().getText().length() >= 1 &&
                                wordleView.getWord3Line1().getText().length() < 1) {
                            wordleView.getWord3Line1().setEnabled(true);
                            wordleView.getWord3Line1().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line1().getText().length() >= 1 &&
                                wordleView.getWord4Line1().getText().length() < 1) {
                            wordleView.getWord4Line1().setEnabled(true);
                            wordleView.getWord4Line1().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line1().getText().length() >= 1 &&
                                wordleView.getWord5Line1().getText().length() < 1) {
                            wordleView.getWord5Line1().setEnabled(true);
                            wordleView.getWord5Line1().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line2
                    if (wordleView.getCurrentLine() == LineEnums.Line2) {
                        if (wordleView.getWord1Line2().getText().length() < 1) {
                            wordleView.getWord1Line2().setEnabled(true);
                            wordleView.getWord1Line2().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line2().getText().length() >= 1 &&
                                wordleView.getWord2Line2().getText().length() < 1) {
                            wordleView.getWord2Line2().setEnabled(true);
                            wordleView.getWord2Line2().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line2().getText().length() >= 1 &&
                                wordleView.getWord3Line2().getText().length() < 1) {
                            wordleView.getWord3Line2().setEnabled(true);
                            wordleView.getWord3Line2().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line2().getText().length() >= 1 &&
                                wordleView.getWord4Line2().getText().length() < 1) {
                            wordleView.getWord4Line2().setEnabled(true);
                            wordleView.getWord4Line2().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line2().getText().length() >= 1 &&
                                wordleView.getWord5Line2().getText().length() < 1) {
                            wordleView.getWord5Line2().setEnabled(true);
                            wordleView.getWord5Line2().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line3
                    if (wordleView.getCurrentLine() == LineEnums.Line3) {
                        if (wordleView.getWord1Line3().getText().length() < 1) {
                            wordleView.getWord1Line3().setEnabled(true);
                            wordleView.getWord1Line3().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line3().getText().length() >= 1 &&
                                wordleView.getWord2Line3().getText().length() < 1) {
                            wordleView.getWord2Line3().setEnabled(true);
                            wordleView.getWord2Line3().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line3().getText().length() >= 1 &&
                                wordleView.getWord3Line3().getText().length() < 1) {
                            wordleView.getWord3Line3().setEnabled(true);
                            wordleView.getWord3Line3().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line3().getText().length() >= 1 &&
                                wordleView.getWord4Line3().getText().length() < 1) {
                            wordleView.getWord4Line3().setEnabled(true);
                            wordleView.getWord4Line3().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line3().getText().length() >= 1 &&
                                wordleView.getWord5Line3().getText().length() < 1) {
                            wordleView.getWord5Line3().setEnabled(true);
                            wordleView.getWord5Line3().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line4
                    if (wordleView.getCurrentLine() == LineEnums.Line4) {
                        if (wordleView.getWord1Line4().getText().length() < 1) {
                            wordleView.getWord1Line4().setEnabled(true);
                            wordleView.getWord1Line4().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line4().getText().length() >= 1 &&
                                wordleView.getWord2Line4().getText().length() < 1) {
                            wordleView.getWord2Line4().setEnabled(true);
                            wordleView.getWord2Line4().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line4().getText().length() >= 1 &&
                                wordleView.getWord3Line4().getText().length() < 1) {
                            wordleView.getWord3Line4().setEnabled(true);
                            wordleView.getWord3Line4().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line4().getText().length() >= 1 &&
                                wordleView.getWord4Line4().getText().length() < 1) {
                            wordleView.getWord4Line4().setEnabled(true);
                            wordleView.getWord4Line4().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line4().getText().length() >= 1 &&
                                wordleView.getWord5Line4().getText().length() < 1) {
                            wordleView.getWord5Line4().setEnabled(true);
                            wordleView.getWord5Line4().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line5
                    if (wordleView.getCurrentLine() == LineEnums.Line5) {
                        if (wordleView.getWord1Line5().getText().length() < 1) {
                            wordleView.getWord1Line5().setEnabled(true);
                            wordleView.getWord1Line5().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line5().getText().length() >= 1 &&
                                wordleView.getWord2Line5().getText().length() < 1) {
                            wordleView.getWord2Line5().setEnabled(true);
                            wordleView.getWord2Line5().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line5().getText().length() >= 1 &&
                                wordleView.getWord3Line5().getText().length() < 1) {
                            wordleView.getWord3Line5().setEnabled(true);
                            wordleView.getWord3Line5().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line5().getText().length() >= 1 &&
                                wordleView.getWord4Line5().getText().length() < 1) {
                            wordleView.getWord4Line5().setEnabled(true);
                            wordleView.getWord4Line5().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line5().getText().length() >= 1 &&
                                wordleView.getWord5Line5().getText().length() < 1) {
                            wordleView.getWord5Line5().setEnabled(true);
                            wordleView.getWord5Line5().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line6
                    if (wordleView.getCurrentLine() == LineEnums.Line6) {
                        if (wordleView.getWord1Line6().getText().length() < 1) {
                            wordleView.getWord1Line6().setEnabled(true);
                            wordleView.getWord1Line6().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line6().getText().length() >= 1 &&
                                wordleView.getWord2Line6().getText().length() < 1) {
                            wordleView.getWord2Line6().setEnabled(true);
                            wordleView.getWord2Line6().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line6().getText().length() >= 1 &&
                                wordleView.getWord3Line6().getText().length() < 1) {
                            wordleView.getWord3Line6().setEnabled(true);
                            wordleView.getWord3Line6().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line6().getText().length() >= 1 &&
                                wordleView.getWord4Line6().getText().length() < 1) {
                            wordleView.getWord4Line6().setEnabled(true);
                            wordleView.getWord4Line6().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line6().getText().length() >= 1 &&
                                wordleView.getWord5Line6().getText().length() < 1) {
                            wordleView.getWord5Line6().setEnabled(true);
                            wordleView.getWord5Line6().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
