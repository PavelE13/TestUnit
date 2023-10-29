package hw3;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NumCheckTest {
    private NumCheck check;

    @BeforeEach
    void setUp() {
        check = new NumCheck();
    }

    //проверяет, является ли переданное число четным или нечетным:
    @Test
    void evenOddNumberTest() {
        assertTrue(check.evenOddNumber(2));
        assertFalse(check.evenOddNumber(5));
    }
}
