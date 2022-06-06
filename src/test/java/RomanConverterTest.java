import com.sef.kata.roman.RomanConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanConverterTest {

    private static Stream conversionTestMethodInput() {
        return Stream.of(Arguments.of(3, "III"),
                         Arguments.of(4, "IV"),
                         Arguments.of(5, "V"),
                         Arguments.of(8, "VIII"),
                         Arguments.of(9, "IX"),
                         Arguments.of(13, "XIII"),
                         Arguments.of(14, "XIV"),
                         Arguments.of(19, "XIX"),
                         Arguments.of(110, "CX"),
                         Arguments.of(111, "CXI"),
                         Arguments.of(119, "CXIX"),
                         Arguments.of(194, "CXCIV"),
                         Arguments.of(222, "CCXXII"),
                         Arguments.of(333, "CCCXXXIII"),
                         Arguments.of(1234, "MCCXXXIV")
                        );
    }

    @ParameterizedTest()
    @MethodSource(value = "conversionTestMethodInput")
    public void convertShouldConvertIntToRoman(int decimal, String roman) {
        RomanConverter converter = new RomanConverter();
        assertEquals(roman, converter.intToString(decimal));
    }

    private static Stream lowerLimitInput() {
        return Stream.of(Arguments.of(1, 6),
                         Arguments.of(5, 5),
                         Arguments.of(10, 4),
                         Arguments.of(50, 3),
                         Arguments.of(100, 2),
                         Arguments.of(500, 1),
                         Arguments.of(1000, 0)
                        );
    }

    @ParameterizedTest()
    @MethodSource(value = "lowerLimitInput")
    public void upperLimitTest(int arg, int expected){
        //assertEquals(expected, new RomanConverter().findLowerLimitIndex(arg));
    }

    @Test
    public void toto() {
        RomanConverter converter = new RomanConverter();
        assertEquals("XCIV", converter.intToString(94));
    }
}
