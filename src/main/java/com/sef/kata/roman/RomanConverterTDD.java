package com.sef.kata.roman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanConverterTDD implements Converter {

    private static final String I = "I";
    private static final String V = "V";
    private static final String X = "X";
    private static List<Unit> units;
    private Integer[] unitCarriage;

    static {
        units = new ArrayList<>();
        Unit one = new Unit(I, 1, null);
        Unit five = new Unit(V, 5, one);
        Unit ten = new Unit(X, 10, one);
        units.add(one);
        units.add(five);
        units.add(ten);
    }

    public RomanConverterTDD() {
        unitCarriage = new Integer[units.size()];
        Arrays.fill(unitCarriage, 0);
    }

    @Override
    public String intToString(int convertedValue) {
        StringBuilder output = new StringBuilder();
        this.nbOccurenceUnit(convertedValue);
        for(int i=0;i<unitCarriage.length;i++){
            System.out.println(unitCarriage[i]);
        }
        int i = unitCarriage.length - 1;
        int t;
        while (i >= 0) {
            if (unitCarriage[i] == -1) {
                output.append(units.get(i).threshold.symbol);
                output.append(units.get(i).symbol);
            } else if (unitCarriage[i] > 0) {
                t = unitCarriage[i];
                while (t > 0) {
                    output.append(units.get(i).symbol);
                    t -= 1;
                }
            }
            i -= 1;
        }
        return output.toString();
    }

    public void nbOccurenceUnit(int a) {
        for (int i = units.size() - 1; i >= 0; i--) {
            var unit = units.get(i);
            while (a > 0) {
                a = a - unit.value;
                if (unit.threshold != null && unit.value == unit.value - unit.threshold.value - a) {
                    unitCarriage[i] = -1;
                }else if (a < 0) {
                    a = a + unit.value;
                    break;
                }else if (unitCarriage[i] < 3 && a >= 0) {
                    unitCarriage[i] += 1;
                }
            }
        }
    }

    public Integer[] getUnitCarriage() {
        return unitCarriage;
    }

    private record Unit(String symbol, Integer value, Unit threshold) {

    }

}
