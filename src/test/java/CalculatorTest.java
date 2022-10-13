import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public static void start () {
        System.out.println("AllTestsStarted");
    }

    @BeforeEach
    public void testInit () {
        System.out.println("TestStarted");
        calculator = new Calculator();
    }

    @AfterEach
    public void finishTheTest () {
        System.out.println("TestFinished");
        calculator=null;
    }

    @AfterAll
    public static void finish (){
        System.out.println("AllTestsFinished");
    }




    @ParameterizedTest
    @MethodSource("source")
    public void testConcat_validArgument_success(int a, int b, int expected) {
        int result = calculator.multiply.apply(a,b);
        assertEquals(expected, result);

    }

    public static Stream<Arguments> source () {
        return Stream.of(
                Arguments.of(2,3,6),
                Arguments.of(4,5,20),
                Arguments.of(1,2,2)
        );

    }

}
