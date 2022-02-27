package com.company.GUI;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldHandler extends PlainDocument {
    private final JTextField field;
    private final boolean lastField;

    public TextFieldHandler(JTextField field, boolean lastField){
        this.field = field;
        this.lastField = lastField;
    }

    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException{
        if((getLength() + str.length()) <= 1){
            str = str.toUpperCase();
            super.insertString(offset, str, set);

            if (!lastField){
                field.transferFocus();
            }
        }
    }
}
