package com.sef.kata.roman;

public class RomanConverterTDD implements Converter {

    public static final String I = "I";

    @Override
    public String intToString(int i) {
        if (1 == i) {
            return I;
        } else {
            return I + I;
        }
    }
}
