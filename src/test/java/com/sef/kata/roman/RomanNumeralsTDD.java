package com.sef.kata.roman;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RomanNumeralsTDD {

    @Test
    public void shouldConvert1ToI() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals(RomanConverterTDD.I, rc.intToString(1));
    }

    @Test
    public void shouldConvert3ToIII() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals("III", rc.intToString(3));
    }

    @Test
    public void shouldConvert4ToIV() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals("IV", rc.intToString(4));
    }

    @Test
    public void shouldConvert10ToX() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals(RomanConverterTDD.X, rc.intToString(10));
    }

    @Test
    public void shouldConvert52ToLII() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals(RomanConverterTDD.X, rc.intToString(10));
    }

    @Test
    public void shouldConvert5ToV() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals(RomanConverterTDD.V, rc.intToString(5));
    }

    @Test
    public void shouldConvert50ToL() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals(RomanConverterTDD.L, rc.intToString(50));
    }

    @Test
    public void shouldConvert44ToXLIV() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals("XLIV", rc.intToString(44));
    }

    @Test
    public void shouldConvert64ToLXIV() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals("LXIV", rc.intToString(64));
    }

    @Test
    public void shouldConvert100ToD() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals(RomanConverterTDD.C, rc.intToString(100));
    }

    @Test
    public void shouldConvert90ToXC() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals("XC", rc.intToString(90));
    }

    @Test
    public void shouldConvert94ToXCIV() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals("XCIV", rc.intToString(94));
    }

    @Test
    public void shouldConvert194ToCXCIV() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals("CXCIV", rc.intToString(194));
    }

    @Test
    public void shouldConvert1984ToCXCIV() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals("MCMLXXXIV", rc.intToString(1984));
    }

    @Test
    public void nbOccurenceUnitShouldCountOnlyReleventUnitForIdentifiableValue() {
        RomanConverterTDD rc = new RomanConverterTDD();
        rc.nbOccurenceUnit(1);
        Integer[] unitCarriage = rc.getSumCarriage();
        assertEquals(unitCarriage[0], Integer.valueOf(1));
        assertEquals(unitCarriage[1], Integer.valueOf(0));
        assertEquals(unitCarriage[2], Integer.valueOf(0));
    }

    @Test
    public void nbOccurenceUnitShouldCountOnlyReleventUnitForSums() {
        RomanConverterTDD rc = new RomanConverterTDD();
        rc.nbOccurenceUnit(3);
        Integer[] unitCarriage = rc.getSumCarriage();
        assertEquals(unitCarriage[0], Integer.valueOf(3));
        assertEquals(unitCarriage[1], Integer.valueOf(0));
        assertEquals(unitCarriage[2], Integer.valueOf(0));
    }

    @Test
    public void nbOccurenceUnitShouldCountOnlyReleventUnitForLargeSums() {
        RomanConverterTDD rc = new RomanConverterTDD();
        rc.nbOccurenceUnit(17);
        Integer[] unitCarriage = rc.getSumCarriage();
        assertEquals(unitCarriage[0], Integer.valueOf(2));
        assertEquals(unitCarriage[1], Integer.valueOf(1));
        assertEquals(unitCarriage[2], Integer.valueOf(1));
    }

    @Test
    public void nbOccurenceUnitShouldCountOnlyReleventUnitForSubstraction() {
        RomanConverterTDD rc = new RomanConverterTDD();
        rc.nbOccurenceUnit(4);
        Integer[] sumCarriage = rc.getSumCarriage();
        Integer[] substractCarriage = rc.getSubstractCarriage();
        assertEquals(sumCarriage[0], Integer.valueOf(0));
        assertEquals(sumCarriage[1], Integer.valueOf(0));
        assertEquals(sumCarriage[2], Integer.valueOf(0));
        assertEquals(sumCarriage[3], Integer.valueOf(0));
        assertEquals(substractCarriage[0], Integer.valueOf(0));
        assertEquals(substractCarriage[1], Integer.valueOf(1));
        assertEquals(substractCarriage[2], Integer.valueOf(0));
        assertEquals(substractCarriage[3], Integer.valueOf(0));
    }

    @Test
    public void nbOccurenceUnitShouldCountOnlyReleventUnitForSubstractionAndSums() {
        RomanConverterTDD rc = new RomanConverterTDD();
        rc.nbOccurenceUnit(14);
        Integer[] sumCarriage = rc.getSumCarriage();
        Integer[] substractCarriage = rc.getSubstractCarriage();
        assertEquals(sumCarriage[0], Integer.valueOf(0));
        assertEquals(sumCarriage[1], Integer.valueOf(0));
        assertEquals(sumCarriage[2], Integer.valueOf(1));
        assertEquals(sumCarriage[3], Integer.valueOf(0));
        assertEquals(substractCarriage[1], Integer.valueOf(1));
    }

    @Test
    public void shouldThrowRuntimeExceptionFor0() {
        RomanConverterTDD rc = new RomanConverterTDD();
        try {
            rc.intToString(0);
        }catch (RuntimeException e){
            assertTrue(true);
        }
    }
}
