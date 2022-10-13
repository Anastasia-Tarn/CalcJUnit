import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator sut;

    @BeforeAll
    public static void start () {
        System.out.println("AllTestsStarted");
    }

    @BeforeEach
    public void testInit () {
        System.out.println("TestStarted");
        sut = new Calculator();
    }

    @AfterEach
    public void finishTheTest () {
        System.out.println("TestFinished");
        sut=null;
    }

    @AfterAll
    public static void finish (){
        System.out.println("AllTestsFinished");
    }




    @ParameterizedTest
    @MethodSource("source")
    public void testConcat_validArgument_success_multiply(int a, int b, int expected) {
        int actual = sut.multiply.apply(a,b);
        assertEquals(expected, actual);

    }

    public static Stream<Arguments> source () {
        return Stream.of(
                Arguments.of(2,3,6),
                Arguments.of(4,5,20),
                Arguments.of(1,2,2)
        );

    }

    @Test
    public void testConcat_validArgument_success_devideByZero() {
        int a=4,b=0;
        var expected=ArithmeticException.class;
        assertThrows(expected,
                ()->sut.devide.apply(a,b));
    }
}
