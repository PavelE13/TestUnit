package hw3;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NumIntervalTest {
    private NumInterval interval;
    @BeforeEach
    void setUp() {
        interval = new NumInterval();
    }

    //проверяет, попадает ли переданное число в интервал (25;100)
    @Test
    void numberInInterval() {
        int num = 30;
        assertTrue(interval.numberInInterval(60));
        assertFalse(interval.numberInInterval(5));
    }
}
