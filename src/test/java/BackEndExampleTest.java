import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.ArithmeticException;

public class BackEndExampleTest {
    BackEndExample example = new BackEndExample();

    @Test
    void testDivideTwoNumber_ValidInput() {
        // given
        int numerator = 10;
        int denominator = 5;

        // when
        double output = example.divideTwoNumber(numerator, denominator);

        // then
        assertEquals(2, output);
    }

    @Test
    void testDivideTwoNumber_InvalidInput() {
        // given
        int numerator = 10;
        int denominator = 0;

        // when/then
        assertThrows(ArithmeticException.class, () -> example.divideTwoNumber(numerator, denominator));
    }
}
