package task5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

public class StringConcatenatorTest {
    @ParameterizedTest
    @CsvSource({"Hello, World, Hello World",
            "Java, 5 , Java 5"})

    public void testConcatenation(String str1, String str2, String expectedResult){
        System.out.println(StringConcatenator.concatenateStrings(str1,str2));
        String result = StringConcatenator.concatenateStrings(str1,str2);
        assertEquals(expectedResult,result, "Некорректная конкатенация строк");
    }
}
