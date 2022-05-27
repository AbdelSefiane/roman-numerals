import com.sef.kata.roman.RomanConverterTDD;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTDD {

    @Test
    public void shouldConvert1ToI() {
        RomanConverterTDD romanConverterTDD = new RomanConverterTDD();
        assertEquals(RomanConverterTDD.I, romanConverterTDD.intToString(1));
    }

    @Test
    public void shouldConvert2ToII() {
        RomanConverterTDD romanConverterTDD = new RomanConverterTDD();
        assertEquals("II", romanConverterTDD.intToString(2));
    }

    @Test
    public void shouldConvert3ToIII() {
        RomanConverterTDD romanConverterTDD = new RomanConverterTDD();
        assertEquals("III", romanConverterTDD.intToString(3));
    }
}
