package src.auxiliar;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumericLengthRestrictedDocumentFilter extends DocumentFilter {
    private int maxCharacters;

    public NumericLengthRestrictedDocumentFilter(int maxChars) {
        maxCharacters = maxChars;
    }

    @Override
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        if ((fb.getDocument().getLength() + str.length()) <= maxCharacters && str.matches("[0-9]*")) {
            super.insertString(fb, offs, str, a);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        if ((fb.getDocument().getLength() + str.length() - length) <= maxCharacters && str.matches("[0-9]*")) {
            super.replace(fb, offs, length, str, a);
        }
    }
}