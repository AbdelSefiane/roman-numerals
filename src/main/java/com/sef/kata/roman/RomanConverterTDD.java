package com.sef.kata.roman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanConverterTDD implements Converter {

    protected static final String I = "I";
    protected static final String V = "V";
    protected static final String X = "X";
    protected static final String L = "L";
    protected static final String C = "C";
    protected static final String D = "D";
    protected static final String M = "M";
    private static List<Unit> units;

    static {
        units = new ArrayList<>();
        Unit one = new Unit(I, 1, null);
        Unit five = new Unit(V, 5, one);
        Unit ten = new Unit(X, 10, one);
        Unit fifty = new Unit(L, 50, ten);
        Unit hundred = new Unit(C, 100, ten);
        Unit fiveHundred = new Unit(D, 500, hundred);
        Unit thousand = new Unit(M, 1000, hundred);
        units.add(one);
        units.add(five);
        units.add(ten);
        units.add(fifty);
        units.add(hundred);
        units.add(fiveHundred);
        units.add(thousand);

    }

    private Integer[] sumCarriage;
    private Integer[] substractCarriage;

    public RomanConverterTDD() {
        sumCarriage = new Integer[units.size()];
        Arrays.fill(sumCarriage, 0);
        substractCarriage = new Integer[units.size()];
        Arrays.fill(substractCarriage, 0);
    }

    @Override
    public String intToString(int convertedValue) {
        if (convertedValue <= 0) {
            throw new RuntimeException("Romans were positifs folks");
        }
        StringBuilder output = new StringBuilder();
        this.nbOccurenceUnit(convertedValue);
        int i = sumCarriage.length - 1;
        int t;
        while (i >= 0) {
            Integer sums = sumCarriage[i];
            Integer substract = substractCarriage[i];
            if (sums > 0) {
                t = sums;
                while (t > 0) {
                    output.append(units.get(i).symbol);
                    t -= 1;
                }
            }
            if (substract == 1) {
                output.append(units.get(i).threshold.symbol);
                output.append(units.get(i).symbol);
            }
            i -= 1;
        }
        return output.toString();
    }

    protected void nbOccurenceUnit(int a) {
        var tmp = a;
        for (int i = units.size() - 1; i >= 0; i--) {
            var unit = units.get(i);
            while (a > 0) {
                a = a - unit.value;
                if (unit.threshold != null && a < 0 && Math.abs(a) <= unit.threshold().value) {
                    a = a + unit.threshold.value;
                    substractCarriage[i]=1;
                } else if (a < 0) {
                    a = a + unit.value;
                    break;
                } else if (a >= 0) {
                    sumCarriage[i] += 1;
                }
            }
        }
    }

    protected Integer[] getSumCarriage() {
        return sumCarriage;
    }

    public Integer[] getSubstractCarriage() {
        return substractCarriage;
    }

    private record Unit(String symbol, Integer value, Unit threshold) {

    }

}
