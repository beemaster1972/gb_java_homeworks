/*
 Удаление четных элементов

Дан произвольный массив целых чисел. Создайте список ArrayList,
заполненный данными из этого массива. Необходимо удалить из списка
четные числа и вернуть результирующий.

Напишите свой код в методе removeEvenNumbers класса Answer.
Метод removeEvenNumbers принимает на вход один параметр:
Integer[] arr - список целых чисел,
возвращает список ArrayList<Integer>

Примеры.
Исходный массив:

1, 2, 3, 4, 5, 6, 7, 8, 9
Результат:

[1, 3, 5, 7, 9]
Исходный массив:

2, 4, 6, 8
Результат:

[]
 */
/** RemoveEvenNumbers */
import java.util.ArrayList;
import java.util.List;

public class RemoveEvenNumbers {
  public static void removeEvenNumbers(Integer[] arr) {
    List<Integer> result = new ArrayList<>(arr.length);
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 == 0) continue;
      result.add(arr[i]);
    }
    System.out.println(result);
  }

  public static void main(String[] args) {
    removeEvenNumbers(new Integer[] {2, 4, 6, 8, 10});
  }
}
