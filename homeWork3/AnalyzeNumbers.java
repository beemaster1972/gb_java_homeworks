/*
 Анализатор списка

Инструкция по использованию платформы



Реализуйте метод, который принимает на вход целочисленный массив arr:
- Создаёт список ArrayList, заполненный числами из исходого массива arr.
- Сортирует список по возрастанию и выводит на экран.
- Находит минимальное значение в списке и выводит на экран
- Minimum is {число}
- Находит максимальное значение в списке и выводит на экран
- Maximum is {число}
- Находит среднее арифметическое значений списка и выводит на экран
- Average is =  {число}
Напишите свой код в методе analyzeNumbers класса Answer.
Метод analyzeNumbers принимает на вход один параметр:

Integer[] arr - массив целых чисел.

Пример.
Исходный массив:

4, 2, 7, 5, 1, 3, 8, 6, 9
Результаты:

[1, 2, 3, 4, 5, 6, 7, 8, 9]
Minimum is 1
Maximum is 9

*/

/** AnalyzeNumbers */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AnalyzeNumbers {
  private static void analyzeNumbers(Integer[] arr) {
    Arrays.sort(arr);
    ArrayList<Integer> sortedList = new ArrayList<>(arr.length);
    int sumArray = 0;
    for (Integer el : arr) {
      sortedList.add(el);
      sumArray += el;
    }
    int minArray = Collections.min(sortedList);
    int maxArray = Collections.max(sortedList);
    float averageArray = (float) ((float) (sumArray) / sortedList.size());
    System.out.println(sortedList);
    System.out.printf("Minimum is %d%n", minArray);
    System.out.printf("Maximum is %d%n", maxArray);
    System.out.printf("Average is %s%n", averageArray);
  }

  public static void main(String[] args) {
    analyzeNumbers(new Integer[] {1, 2, 3, 4, 5, 6});
  }
}
