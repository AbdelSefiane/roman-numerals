package com.sef.kata.roman;

public class RomanConverterTDD implements Converter{

    @Override
    public String intToString(int i) {
        if(1 == i){
            return "I";
        } else {
            return "II";
        }
    }
}
