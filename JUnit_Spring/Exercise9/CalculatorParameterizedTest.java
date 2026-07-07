import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorParameterizedTest {

    CalculatorService service = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "1,2,3",
        "5,10,15",
        "100,200,300",
        "-5,5,0"
    })
    void testAdd(int a, int b, int expected) {

        assertEquals(expected, service.add(a, b));
    }
}