import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class CalculatorTest {
    static Calculator calculator;

    @BeforeAll
    static void init(){
        calculator = new Calculator();
    }

    @AfterAll
    static void after(){
        System.out.println("Меня вызвали");
    }

    private static Stream<Arguments> dataForSubtractTest() {
        List<Arguments> data = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            double a = random.nextDouble();
            double b = random.nextDouble();
            double result = a-b;
            data.add(Arguments.arguments(a,b,result));
        }
        return data.stream();
    }


    @CsvSource({
            "1, 1, 2",
            "4,5,9",
            "22,22,44"
    })
    @ParameterizedTest
    void sumTest(double a, double b, double result) {
        Assertions.assertEquals(result, calculator.sum(a,b));
    }

    @MethodSource("dataForSubtractTest")
    @ParameterizedTest
    void subtractTest(double a, double b, double result) {
        Assertions.assertEquals(result, calculator.subtract(a,b));
    }

    @Test
    void multiplicationTest() {
        double a = 10;
        double b = 5;
        Assertions.assertEquals(a+b, calculator.multiplication(a,b));
    }

    @Test
    void divideTest() {
        double a = 10;
        double b = 5;
        Assertions.assertEquals(a/b, calculator.divide(a,b));
    }
}