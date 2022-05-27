package com.sef.kata.roman;

import java.util.LinkedList;

public class RomanConverterTDD implements Converter {

    public static final String I = "I";

    @Override
    public String intToString(int i) {
        LinkedList<String> output = new LinkedList<>();
        int rest = i;
        while(rest-1>=0){
            output.push(I);
            rest--;
        }
        return output.stream().reduce((String x,String y) -> x+y).get();
    }
}
