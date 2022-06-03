import com.sef.kata.roman.RomanConverter;
import com.sef.kata.roman.RomanConverterTDD;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
        assertEquals("IV",rc.intToString(4));
    }

    @Test
    public void shouldConvert5ToV() {
        RomanConverterTDD rc = new RomanConverterTDD();
        assertEquals(RomanConverterTDD.V, rc.intToString(5));
    }

    @Test
    public void nbOccurenceUnitShouldCountOnlyReleventUnit(){
        RomanConverterTDD rc = new RomanConverterTDD();
        //Integer[] integers = rc.nbOccurenceUnit(1);
        rc.nbOccurenceUnit(1);
        Integer[] unitCarriage = rc.getUnitCarriage();
        assertEquals(unitCarriage[0],Integer.valueOf(1));
        assertEquals(unitCarriage[1],Integer.valueOf(0));
    }
}
