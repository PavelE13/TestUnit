package seminar3Test;

import org.junit.jupiter.api.*;
import seminar3.Calculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void add() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void subtract() {
        int result = calculator.subtract(3, 1);
        assertEquals(2, result);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply() {
        int result = calculator.multiply(3, 2);
        assertEquals(6, result);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() {
        int result = calculator.divide(4, 2);
        assertEquals(2, result);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void divideExceptions() {
        assertThatThrownBy(() -> calculator.divide(10, 0))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Division by zero is not allowed.");
    }
}
