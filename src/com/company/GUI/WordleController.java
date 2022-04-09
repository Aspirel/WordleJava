package com.company.GUI;

import com.company.Utils.LineEnums;

import javax.swing.*;
import java.awt.*;
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
            } else if (e.getActionCommand().equals("DEL")) {
                wordleModel.deleteLetter();
            } else {
                if (wordleView.getCurrentLine() == LineEnums.Line1) {
                    if (wordleView.getTextFieldsArray().get(0).getText().length() < 1) {
                        wordleView.getTextFieldsArray().get(0).setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(0).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getTextFieldsArray().get(0).getText().length() >= 1 &&
                            wordleView.getTextFieldsArray().get(1).getText().length() < 1) {
                        wordleView.getTextFieldsArray().get(1).setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(1).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getTextFieldsArray().get(1).getText().length() >= 1 &&
                            wordleView.getTextFieldsArray().get(2).getText().length() < 1) {
                        wordleView.getTextFieldsArray().get(2).setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getTextFieldsArray().get(2).getText().length() >= 1 &&
                            wordleView.getWord4Line1().getText().length() < 1) {
                        wordleView.getWord4Line1().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord4Line1().getText().length() >= 1 &&
                            wordleView.getWord5Line1().getText().length() < 1) {
                        wordleView.getWord5Line1().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    }
                }
                //line2
                if (wordleView.getCurrentLine() == LineEnums.Line2) {
                    if (wordleView.getWord1Line2().getText().length() < 1) {
                        wordleView.getWord1Line2().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord1Line2().getText().length() >= 1 &&
                            wordleView.getWord2Line2().getText().length() < 1) {
                        wordleView.getWord2Line2().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord2Line2().getText().length() >= 1 &&
                            wordleView.getWord3Line2().getText().length() < 1) {
                        wordleView.getWord3Line2().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord3Line2().getText().length() >= 1 &&
                            wordleView.getWord4Line2().getText().length() < 1) {
                        wordleView.getWord4Line2().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord4Line2().getText().length() >= 1 &&
                            wordleView.getWord5Line2().getText().length() < 1) {
                        wordleView.getWord5Line2().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    }
                }

                //line3
                if (wordleView.getCurrentLine() == LineEnums.Line3) {
                    if (wordleView.getWord1Line3().getText().length() < 1) {
                        wordleView.getWord1Line3().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord1Line3().getText().length() >= 1 &&
                            wordleView.getWord2Line3().getText().length() < 1) {
                        wordleView.getWord2Line3().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord2Line3().getText().length() >= 1 &&
                            wordleView.getWord3Line3().getText().length() < 1) {
                        wordleView.getWord3Line3().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord3Line3().getText().length() >= 1 &&
                            wordleView.getWord4Line3().getText().length() < 1) {
                        wordleView.getWord4Line3().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord4Line3().getText().length() >= 1 &&
                            wordleView.getWord5Line3().getText().length() < 1) {
                        wordleView.getWord5Line3().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    }
                }

                //line4
                if (wordleView.getCurrentLine() == LineEnums.Line4) {
                    if (wordleView.getWord1Line4().getText().length() < 1) {
                        wordleView.getWord1Line4().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord1Line4().getText().length() >= 1 &&
                            wordleView.getWord2Line4().getText().length() < 1) {
                        wordleView.getWord2Line4().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord2Line4().getText().length() >= 1 &&
                            wordleView.getWord3Line4().getText().length() < 1) {
                        wordleView.getWord3Line4().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord3Line4().getText().length() >= 1 &&
                            wordleView.getWord4Line4().getText().length() < 1) {
                        wordleView.getWord4Line4().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord4Line4().getText().length() >= 1 &&
                            wordleView.getWord5Line4().getText().length() < 1) {
                        wordleView.getWord5Line4().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    }
                }

                //line5
                if (wordleView.getCurrentLine() == LineEnums.Line5) {
                    if (wordleView.getWord1Line5().getText().length() < 1) {
                        wordleView.getWord1Line5().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord1Line5().getText().length() >= 1 &&
                            wordleView.getWord2Line5().getText().length() < 1) {
                        wordleView.getWord2Line5().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord2Line5().getText().length() >= 1 &&
                            wordleView.getWord3Line5().getText().length() < 1) {
                        wordleView.getWord3Line5().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord3Line5().getText().length() >= 1 &&
                            wordleView.getWord4Line5().getText().length() < 1) {
                        wordleView.getWord4Line5().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord4Line5().getText().length() >= 1 &&
                            wordleView.getWord5Line5().getText().length() < 1) {
                        wordleView.getWord5Line5().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    }
                }

                //line6
                if (wordleView.getCurrentLine() == LineEnums.Line6) {
                    if (wordleView.getWord1Line6().getText().length() < 1) {
                        wordleView.getWord1Line6().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord1Line6().getText().length() >= 1 &&
                            wordleView.getWord2Line6().getText().length() < 1) {
                        wordleView.getWord2Line6().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord2Line6().getText().length() >= 1 &&
                            wordleView.getWord3Line6().getText().length() < 1) {
                        wordleView.getWord3Line6().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord3Line6().getText().length() >= 1 &&
                            wordleView.getWord4Line6().getText().length() < 1) {
                        wordleView.getWord4Line6().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
                    } else if (wordleView.getWord4Line6().getText().length() >= 1 &&
                            wordleView.getWord5Line6().getText().length() < 1) {
                        wordleView.getWord5Line6().setText(String.valueOf(e.getActionCommand()));
                        wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                        wordleView.getWorldlePanel().requestFocus();
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
                if (acceptableLetters.contains(String.valueOf(e.getKeyChar()))) {
                    //line1
                    if (wordleView.getCurrentLine() == LineEnums.Line1) {
                        if (wordleView.getTextFieldsArray().get(0).getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(0).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getTextFieldsArray().get(0).setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getTextFieldsArray().get(0).getText().length() >= 1 &&
                                wordleView.getTextFieldsArray().get(1).getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(1).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getTextFieldsArray().get(1).setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getTextFieldsArray().get(1).getText().length() >= 1 &&
                                wordleView.getTextFieldsArray().get(2).getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(2).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getTextFieldsArray().get(2).setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getTextFieldsArray().get(2).getText().length() >= 1 &&
                                wordleView.getTextFieldsArray().get(3).getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(3).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getTextFieldsArray().get(3).setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getTextFieldsArray().get(3).getText().length() >= 1 &&
                                wordleView.getTextFieldsArray().get(4).getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(4).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getTextFieldsArray().get(4).setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line2
                    if (wordleView.getCurrentLine() == LineEnums.Line2) {
                        if (wordleView.getTextFieldsArray().get(5).getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(5).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getTextFieldsArray().get(5).setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line2().getText().length() >= 1 &&
                                wordleView.getWord2Line2().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(6).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord2Line2().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line2().getText().length() >= 1 &&
                                wordleView.getWord3Line2().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(7).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord3Line2().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line2().getText().length() >= 1 &&
                                wordleView.getWord4Line2().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(8).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord4Line2().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line2().getText().length() >= 1 &&
                                wordleView.getWord5Line2().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(9).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord5Line2().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line3
                    if (wordleView.getCurrentLine() == LineEnums.Line3) {
                        if (wordleView.getWord1Line3().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(10).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord1Line3().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line3().getText().length() >= 1 &&
                                wordleView.getWord2Line3().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(11).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord2Line3().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line3().getText().length() >= 1 &&
                                wordleView.getWord3Line3().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(12).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord3Line3().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line3().getText().length() >= 1 &&
                                wordleView.getWord4Line3().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(13).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord4Line3().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line3().getText().length() >= 1 &&
                                wordleView.getWord5Line3().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(14).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord5Line3().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line4
                    if (wordleView.getCurrentLine() == LineEnums.Line4) {
                        if (wordleView.getWord1Line4().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(15).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord1Line4().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line4().getText().length() >= 1 &&
                                wordleView.getWord2Line4().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(15).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord2Line4().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line4().getText().length() >= 1 &&
                                wordleView.getWord3Line4().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(16).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord3Line4().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line4().getText().length() >= 1 &&
                                wordleView.getWord4Line4().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(17).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord4Line4().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line4().getText().length() >= 1 &&
                                wordleView.getWord5Line4().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(18).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord5Line4().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line5
                    if (wordleView.getCurrentLine() == LineEnums.Line5) {
                        if (wordleView.getWord1Line5().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(19).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord1Line5().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line5().getText().length() >= 1 &&
                                wordleView.getWord2Line5().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(20).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord2Line5().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line5().getText().length() >= 1 &&
                                wordleView.getWord3Line5().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(21).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord3Line5().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line5().getText().length() >= 1 &&
                                wordleView.getWord4Line5().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(22).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord4Line5().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line5().getText().length() >= 1 &&
                                wordleView.getWord5Line5().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(23).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord5Line5().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        }
                    }

                    //line6
                    if (wordleView.getCurrentLine() == LineEnums.Line6) {
                        if (wordleView.getWord1Line6().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(24).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord1Line6().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord1Line6().getText().length() >= 1 &&
                                wordleView.getWord2Line6().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(25).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord2Line6().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord2Line6().getText().length() >= 1 &&
                                wordleView.getWord3Line6().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(26).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord3Line6().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord3Line6().getText().length() >= 1 &&
                                wordleView.getWord4Line6().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(27).setBorder(BorderFactory.createLineBorder(Color.black));
                            wordleView.getWord4Line6().setText(String.valueOf(e.getKeyChar()));
                            wordleView.getWorldlePanel().requestFocus();
                        } else if (wordleView.getWord4Line6().getText().length() >= 1 &&
                                wordleView.getWord5Line6().getText().length() < 1) {
                            wordleView.getTextFieldsArray().get(28).setBorder(BorderFactory.createLineBorder(Color.black));
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
