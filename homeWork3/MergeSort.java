/*Сортировка слиянием

Инструкция по использованию платформы



Внутри класса MergeSort напишите метод mergeSort,
который принимает массив целых чисел, реализует
алгоритм сортировки слиянием. Метод должен возвращать
отсортированный массив.

Пример


a = {5, 1, 6, 2, 3, 4} -> [1, 2, 3, 4, 5, 6]
*/
import java.util.Arrays;

class MergeSort {
  private static int[] mergeArray(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int leftPosition = 0, rightPosition = 0;

    for (int i = 0; i < result.length; i++) {
      if (leftPosition == left.length) {
        result[i] = right[rightPosition];
        rightPosition++;
      } else if (rightPosition == right.length) {
        result[i] = left[leftPosition];
        leftPosition++;
      } else if (left[leftPosition] < right[rightPosition]) {
        result[i] = left[leftPosition];
        leftPosition++;
      } else {
        result[i] = right[rightPosition];
        rightPosition++;
      }
    }
    return result;
  }

  private static int[] sortUnsorted(int[] a) {
    if (a == null) return null;

    if (a.length < 2) return a;

    int[] leftArray = Arrays.copyOf(a, a.length / 2);
    int[] rightArray = Arrays.copyOfRange(a, a.length / 2, a.length);
    leftArray = sortUnsorted(leftArray);
    rightArray = sortUnsorted(rightArray);

    return mergeArray(leftArray, rightArray);
  }

  public static int[] mergeSort(int[] a) {

    return sortUnsorted(a);
  }

  public static void main(String[] args) {
    int[] a = new int[] {3, 4, 7, 8, 2, 1, 6};
    a = mergeSort(a);
    System.out.print("[");
    for (int el : a) System.out.printf("%s ", el);
    System.out.println("]");
  }
}
