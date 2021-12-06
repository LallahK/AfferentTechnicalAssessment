package abdullah.takehometest.afferent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Calculator {

    class ParseException extends Exception {
        public ParseException(String message) { super(message); }
    }

    private Iterator<Character> iter;
    private char c;

    private void nextChar() {
        c = iter.next();
        while (c == ' ') c = iter.next();
    }

    public Double parse(String input) {
        List<Character> list = new ArrayList<Character>();
        for (char c: input.toCharArray()) {
            list.add(c);
        }
        list.add('\0');
        iter = list.iterator();

        try {
            return parseStart();            
        } catch (ParseException e) {
            return null;
        }
    }

    private double parseStart() throws ParseException {
        nextChar();
        double number = parseSum();
        if (c != '\0') throw new ParseException("Expected End of String");
        return Math.round(number * 100.0) / 100.0;
    }

    private double parseSum() throws ParseException {
        double number = parseMul();

        while (c == '+' || c == '-') {
            if (c == '+') {
                nextChar();
                number = number + parseMul();
            } else {
                nextChar();
                number = number - parseMul();
            }
        }

        return number;
    }

    private double parseMul() throws ParseException {
        double number = parsePow();

        while (c == '*' || c == '/') {
            if (c == '*') {
                nextChar();
                number = number * parsePow();
            } else {
                nextChar();
                number = number / parsePow();
            }
        }

        return number;
    }

    private double parsePow() throws ParseException {
        double number = parseFactor();

        while (c == '^') {
            nextChar();
            number = Math.pow(number, parseFactor());
        }

        return number;
    }

    private double parseFactor() throws ParseException {
        if (c == '(') {
            nextChar();
            double number = parseSum();
            if (c != ')') throw new ParseException("Expected Close Parenthese ')'");
            nextChar();
            return number;
        } else if (c == '-') {
            nextChar();
            return -1 * parseNum();
        } else {
            return parseNum();
        }
    }

    private double parseNum() throws ParseException {
        double number = 0;

        if (!Character.isDigit(c)) throw new ParseException("Expected Digit");

        for (; Character.isDigit(c); nextChar()) {
            number = number * 10 + Character.getNumericValue(c);
        }

        if (c == '.') {
            nextChar();
            number = number + parseFloat();
        }

        return number;
    }

    private double parseFloat() throws ParseException {
        double number = 0;
        int count = 1;

        if (!Character.isDigit(c)) throw new ParseException("Expected Digit");

        for (; Character.isDigit(c); nextChar()) {
            number = number + Character.getNumericValue(c) / (Math.pow(10, count));
            count++;
        }

        return number;
    }

}