package com.sef.kata.roman;

import java.util.LinkedList;

public class RomanConverterTDD implements Converter {

    public static final String I = "I";
    public static final String V = "V";

    @Override
    public String intToString(int i) {
        LinkedList<String> output = new LinkedList<>();
        int rest = i;
        while(rest>0){
            if(rest-5==0){
                output.push(V);
                rest = rest-5;
            } else if(rest-4>=0){
                output.push(V);
                rest = rest-3;
            } else if(rest-1>=0){
                output.push(I);
                rest--;
            }
        }
        return output.stream().reduce((String x,String y) -> x+y).get();
    }
}
