import com.sef.kata.roman.Main;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTDD {


    @Test
    public void shouldConvert1ToI(){
        Main main = new Main();
        assertEquals("I", main.convert(1));
    }
}
