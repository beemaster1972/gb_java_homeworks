
/*
 Сортировка массива с использованием кучи


Необходимо разработать программу для сортировки массива целых чисел
с использованием сортировки кучей (Heap Sort). Программа должна работать
следующим образом:

Принимать на вход массив целых чисел для сортировки.
Если массив не предоставлен, программа использует массив по умолчанию.

Сначала выводить исходный массив на экран.

Затем применять сортировку кучей (Heap Sort) для сортировки элементов
массива в порядке возрастания.

Выводить отсортированный массив на экран.

Ваше решение должно содержать два основных метода: buildTree,
который строит сортирующее дерево на основе массива, и heapSort,
который выполняет собственно сортировку кучей.

Программа должна быть способной сортировать массив, даже если
он состоит из отрицательных чисел и имеет дубликаты.

На входе:


'5 8 12 3 6 9'
На выходе:


Initial array:
[5, 8, 12, 3, 6, 9]
Sorted array:
[3, 5, 6, 8, 9, 12]
 */
import java.util.Arrays;

class HeapSort {
  public static void buildTree(int[] tree, int sortLength, int rootIndex) {
    // Введите свое решение ниже
    int maxElementIndex = rootIndex; // инициализируем наибольший элемент как корень
    int leftIndex = 2 * rootIndex + 1; // левый индекс
    int rightIndex = 2 * rootIndex + 2; // правый индекс
    // находим индекс максимального элемента в поддереве
    if (left < n && tree[leftIndex] > tree[maxElementIndex])
      maxElementIndex = leftIndex;
    if (right < n && tree[rightIndex] > tree[maxElementIndex])
      maxElementIndex = rightIndex;
    // Переносим в корень максимальный элемент
    if (maxElementIndex != rootIndex) {
      int swap = tree[rootIndex];
      tree[rootIndex] = tree[maxElementIndex];
      tree[maxElementIndex] = swap;
    }
    // Рекурсия
    buildTree(tree, sortLength, maxElementIndex);
  }

  public static void heapSort(int[] sortArray, int sortLength) {
    // Введите свое решение ниже
    // Строим дерево
    for (int i = sortLength/2-1;i>=0;i--)
      buildTree(sortArray, sortLength, i);

    //Извлекаем из элементы из дерева с конца
    for (int i=sortLength-1;i>=0;i--){
      int swap = 
    }
  }

  public static void main(String[] args) {
    int[] initArray;

    if (args.length == 0) {
      initArray = new int[] { 17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1 };
    } else {
      initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    System.out.println("Initial array:");
    System.out.println(Arrays.toString(initArray));
    HeapSort.heapSort(initArray, initArray.length);
    System.out.println("Sorted array:");
    System.out.println(Arrays.toString(initArray));
  }
}
