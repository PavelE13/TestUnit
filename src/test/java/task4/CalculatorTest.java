package task4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @BeforeAll
    public static void initAll() {
        System.out.printf("Hiii!!!!!");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.printf("END!");    }

    @AfterEach
    public void tearDown() {
        calculator = null; // Очистка после каждого теста
    }

    @Test
    @DisplayName("Проверка равенства значений")
    void testAssertEquals() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    @DisplayName("Проверка неравенства значений")
    void testAssertNotEquals() {
        assertNotEquals(5, calculator.add(2, 2));
    }

    @Test
    @DisplayName("Проверка истинного условия")
    void testAssertTrue() {
        assertTrue(calculator.add(2, 2) == 4);
    }

    @Test
    @DisplayName("Проверка ложного условия")
    void testAssertFalse() {
        assertFalse(calculator.add(2, 2) == 5);
    }

    @Test
    @DisplayName("Проверка наличия объекта")
    void testAssertNotNull() {
        assertNotNull(calculator);
    }

    @Test
    @DisplayName("Проверка отсутствия объекта")
    void testAssertNull() {
        calculator = null;
        assertNull(calculator);
    }

    @Test
    @DisplayName("Проверка равенства массивов")
    void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка на генерацию исключений")
    void testAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
    }

    // Дополнительные ассерты
    @Test
    @DisplayName("Проверка с сообщением")
    void testAssertWithMessage() {
        //assertEquals(4, calculator.add(2, 2));
        assertEquals(4, calculator.add(2, 2), "2 + 2 должно быть равно 4");
    }

    @Test
    @DisplayName("Проверка с использованием лямбда-выражения для сообщения")
    void testAssertWithLambdaMessage() {
        assertEquals(4, calculator.add(2, 2), () -> "2 + 2 должно быть равно 4");
    }

    // Дмашнее задание №1
    // 1. Проверяем, что метод правильно вычисляет скидку для различных вариаций значеий цены и скидки

    /*@Test //Способ 1 @ Test
    @DisplayName("Проверка метода calculateDiscount (скидка)")
    void testCalculateDiscount() {
        double result = calculator.calculateDiscount(100, 10);
        assertEquals(90, result);

        result = calculator.calculateDiscount(0, 50);
        assertEquals(0, result);

        result = calculator.calculateDiscount(100, 0);
        assertEquals(100, result);

    }*/

    //Способ 2 @ParameterizedTes
    @ParameterizedTest
    @DisplayName("Проверка метода calculateDiscount (скидка)")
        @CsvSource({"100, 10, 90", "0, 50, 0", "100, 0, 100"})
        void testCalculateDiscount(int price, int discount, int expectedDiscount) {
            //Calculator calculator = new Calculator();
            double result = calculator.calculateDiscount(price, discount);
            assertEquals(expectedDiscount, result);

    }

     // 2. Проверяем, что метод правильно выбрасывает исключения
    @Test //Способ 1 @Test
    @DisplayName("Проверка метода calculateDiscount при передаче недопустимых аргументов")
    void testCalculateDiscountWithInvalidArguments() {
        // Проверяем, что метод выбрасывает исключение при передаче отрицательной суммы покупки.
        assertThatThrownBy(() -> calculator.calculateDiscount(-100, 10))
                .isInstanceOf(ArithmeticException.class).hasMessage("Недопустимые аргументы");

        // Проверяем, что метод выбрасывает исключение при передаче отрицательного процента скидки.
        assertThatThrownBy(() -> calculator.calculateDiscount(100, -10))
                .isInstanceOf(ArithmeticException.class).hasMessage("Недопустимые аргументы");

        // Проверяем, что метод выбрасывает исключение при передаче процента скидки, превышающего 100%.
        assertThatThrownBy(() -> calculator.calculateDiscount(100, 150))
                .isInstanceOf(ArithmeticException.class).hasMessage("Недопустимые аргументы");

    }

}
