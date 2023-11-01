package hw6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class NumListComparisonTest {

    private List<Integer> list1;
    private List<Integer> list2;

    //Создаем 2 одинаковых списка
    @BeforeEach
    void setUp() {
        list1 = new ArrayList<>(Arrays.asList(1, 0, -1));
        list2 = new ArrayList<>(Arrays.asList(1, 0, -1));
    }

    @Test
    @DisplayName("Тест-средние значения равны")
    void testCompareListsBothEquals() {
        NumListComparison numListComparison = new NumListComparison(list1, list2);
        String result = numListComparison.compareLists();
        Assertions.assertEquals("Средние значения равны", result);
    }

    @Test
    @DisplayName("Тест-2 список имеет > среднее значение")
    void testCompareListsSecondGreater() {
        list2.add(1);
        NumListComparison numListComparison = new NumListComparison(list1, list2);
        String result = numListComparison.compareLists();
        Assertions.assertEquals("Второй список имеет большее среднее значение", result);
    }

    @Test
    @DisplayName("Тест-1 список имеет > среднее значение")
    void testCompareListsFirstGreater() {
        list1.add(1);
        NumListComparison numListComparison = new NumListComparison(list1, list2);
        String result = numListComparison.compareLists();
        Assertions.assertEquals("Первый список имеет большее среднее значение", result);
    }

    @Test
    void testGetAverage() {
        list1.add(1);
        double result = NumListComparison.getAverage(list1);
        Assertions.assertEquals(0.25, result);
    }

}
