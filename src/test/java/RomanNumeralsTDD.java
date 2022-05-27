import com.sef.kata.roman.RomanConverterTDD;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTDD {

    public static final RomanConverterTDD ROMAN_CONVERTER = new RomanConverterTDD();

    @Test
    public void shouldConvert1ToI() {
        assertEquals(RomanConverterTDD.I, ROMAN_CONVERTER.intToString(1));
    }

    @Test
    public void shouldConvert3ToIII() {
        assertEquals("III", ROMAN_CONVERTER.intToString(3));
    }

    @Test
    public void shouldConvert4ToIV() {
        assertEquals("IV", ROMAN_CONVERTER.intToString(4));
    }

    @Test
    public void shouldConvert5ToV() {
        assertEquals("V", ROMAN_CONVERTER.intToString(5));
    }
}
