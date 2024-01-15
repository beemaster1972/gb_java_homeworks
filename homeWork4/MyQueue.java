// Реализация очереди
//
//
// В классе MyQueue реализуйте очередь для типа данных Integer с помощью
// LinkedList со следующими методами:
//
// enqueue() - помещает элемент в конец очереди
// dequeue() - возвращает первый элемент из очереди и удаляет его
// first() - возвращает первый элемент из очереди, не удаляя
// getElements() - возвращает все элементы в очереди
//
// Пример
//
//
// queue.enqueue(1);
// queue.enqueue(10);
// queue.enqueue(15);
// queue.enqueue(5);
// System.out.println(queue.getElements());
// Результат:
//
// [1, 10, 15, 5]
// queue.dequeue();
// queue.dequeue();
// System.out.println(queue.getElements());
// Результат:
//
//  [15, 5]
// System.out.println(queue.first());
// Результат:
//
// 15
//

import java.util.LinkedList;

/** MyQueue */
public class MyQueue {
  public LinkedList<T> myQueue = new LinkedList<>();

  public void enqueue(T element) {
    // Напишите свое решение ниже
    myQueue.add(element);
  }

  public T dequeue() {
    // Напишите свое решение ниже
    T result = myQueue.get(0);
    myQueue.remove(0);
    return result;
  }

  public T first() {
    // Напишите свое решение ниже
    T result = myQueue.get(0);

    return result;
  }

  public LinkedList<T> getElements() {
    // Напишите свое решение ниже

    return myQueue;
  }

  public static void main(String[] args) {
  }
}
