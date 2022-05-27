package com.sef.kata.roman;

import java.util.LinkedList;

public class RomanConverterTDD implements Converter {

    public static final String I = "I";

    @Override
    public String intToString(int i) {
        LinkedList<String> output = new LinkedList<>();
        if(i >= 3){
            output.push(I);
        } if( i >= 2){
            output.push(I);
        } if(i >= 1){
            output.push(I);
        }
        return output.stream().reduce((String x,String y) -> x+y).get();
    }
}
