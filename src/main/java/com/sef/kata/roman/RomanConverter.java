package com.sef.kata.roman;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//V1 !KISS - Pen&Paper
// highly coupled
// Not built for modification
// BAD !
public class RomanConverter implements Converter {

    public static final String I = "I";
    public static final String V = "V";
    public static final String X = "X";
    public static final String L = "L";
    public static final String C = "C";
    public static final String D = "D";
    public static final String M = "M";
    List<Unit> unitTable = new ArrayList<>();
    Unit lowerLimit;
    Unit upperLimit;

    //Contructivist logic, hidden complexity, bad thing
    public RomanConverter() {
        Unit one = new Unit(I, 1);
        MultipleDigitUnit ten = new MultipleDigitUnit(X, 10, one);
        MultipleDigitUnit hundred = new MultipleDigitUnit(C, 100, ten);
        unitTable.add(new MultipleDigitUnit(M, 1000, hundred));
        unitTable.add(new MultipleDigitUnit(D, 500, hundred));
        unitTable.add(hundred);
        unitTable.add(new MultipleDigitUnit(L, 50, ten));
        unitTable.add(ten);
        unitTable.add(new Unit(V, 5));
        unitTable.add(one);
    }

    /**
     * Finds the bounding limits of a number considering roman numerals base.
     * If the evaluated value is equals to a unit,
     * this sets the lower limit the corresponding unit
     *
     * @param evaluatedValue
     */
    public void findLimits(final int evaluatedValue) {
        int lowerLimitIndex = 0;
        this.lowerLimit = unitTable.get(lowerLimitIndex);
        while (lowerLimitIndex < unitTable.size() && lowerLimit.getValue() - evaluatedValue > 0) {
            lowerLimit = unitTable.get(lowerLimitIndex++);
        }
        lowerLimitIndex = lowerLimitIndex > 0 ? lowerLimitIndex - 1 : 0;
        this.lowerLimit = unitTable.get(lowerLimitIndex);
        if (lowerLimit.getValue() == 1000) {
            upperLimit = lowerLimit;
        } else {
            upperLimit = unitTable.get(lowerLimitIndex - 1);
        }
    }

    @Override
    public String convert(int convertedValue) {
        if (convertedValue <= 0) {
            throw new RuntimeException("NUMBERS ARE FOR TRADING GOODS&SERVICES.");
        }
        int conversionRest = convertedValue;
        int lowerRest = 0;
        StringBuilder output = new StringBuilder("");
        findLimits(conversionRest);
        if (this.lowerLimit.getValue() == convertedValue) {
            return this.lowerLimit.getSymbol();
        }

        while (conversionRest > 0) {
            lowerRest = conversionRest - this.lowerLimit.getValue();
            if (lowerRest < 0) {
                findLimits(conversionRest);
            } else if (upperLimit instanceof MultipleDigitUnit &&
                    conversionRest == this.upperLimit.getValue() - ((MultipleDigitUnit)this.upperLimit).getThresholdUnitValue()) {
                output.append(((MultipleDigitUnit)(this.upperLimit)).getThresholdUnitSymbol());
                output.append(this.upperLimit.getSymbol());
                ((MultipleDigitUnit)this.upperLimit).countThresholdOccurence();
                this.upperLimit.countOccurence();
                conversionRest = conversionRest - upperLimit.getValue() + ((MultipleDigitUnit)upperLimit).getThresholdUnitValue();
            } else if (this.lowerLimit.isFlagged()) {
                output.delete(output.length() - 3, output.length());
                output.append(this.lowerLimit.getSymbol());
                output.append(this.upperLimit.getSymbol());
                this.lowerLimit.resetOccurenceCount();
                this.upperLimit.countOccurence();
                this.lowerLimit.toggleCompressionFlag();
                conversionRest = conversionRest - this.upperLimit.getValue() - this.lowerLimit.getValue();
            } else if (lowerRest >= 0) {
                output.append(this.lowerLimit.getSymbol());
                this.lowerLimit.countOccurence();
                conversionRest = lowerRest;
            }
        }

        return output.toString();
    }

    public static class MultipleDigitUnit extends Unit {

        final Unit thresholdUnit;

        public MultipleDigitUnit(String symbol, Integer value, Unit thresholdUnit) {
            super(symbol, value);
            this.thresholdUnit = thresholdUnit;
        }

        public int getThresholdUnitValue() {
            return this.thresholdUnit.getValue();
        }

        public String getThresholdUnitSymbol() {
            return this.thresholdUnit.getSymbol();
        }

        public void countThresholdOccurence() {
            this.thresholdUnit.countOccurence();
        }

        public void resetThresholdUnitOccurence() {
            this.thresholdUnit.resetOccurenceCount();
        }
    }

    //Use polymorphism
    //Responsability of building the answer goes to the converter
    //instead of polymorphic units use polymorphic converter,
    //fits more reality
    public static class Unit {

        //mendatory
        final String symbol;
        //mendatory
        final Integer value;
        //bad design
        Integer occurence;
        Boolean compressionFlag;

        public Unit(String symbol, Integer value) {
            this.symbol = symbol;
            this.value = value;
            this.occurence = 0;
            this.compressionFlag = Boolean.FALSE;
        }

        //Does 2 things count + raise flag, bad design
        public void countOccurence() {
            if (occurence == 2) {
                occurence = 0;
                toggleCompressionFlag();
            } else {
                occurence++;
            }
        }

        public void resetOccurenceCount() {
            this.occurence = 0;
        }

        public boolean isFlagged() {
            return compressionFlag;
        }

        public void toggleCompressionFlag() {
            compressionFlag = !compressionFlag;
        }

        public String getSymbol() {
            return symbol;
        }

        public Integer getValue() {
            return value;
        }

    }
}
