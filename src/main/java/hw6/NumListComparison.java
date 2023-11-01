package hw6;

import  com.google.common.math.Stats;
import java.util.List;

public class NumListComparison {

        final List<Integer> list1;
        final List<Integer> list2;

        public NumListComparison(List<Integer> list1, List<Integer> list2) {
            this.list1 = list1;
            this.list2 = list2;
        }

        //Метод вычисления и возврата среднего значения списка
        public static double getAverage(List<Integer> list) {
              return Stats.meanOf(list);
        }

        //Метод сравнения списков
        public String compareLists() {
            double average1 = getAverage(list1);
            double average2 = getAverage(list2);

            if (average1 < average2) {
                return "Второй список имеет большее среднее значение";
            } else if (average1 > average2) {
                return "Первый список имеет большее среднее значение";
            } else {
                return "Средние значения равны";
            }
        }
}
