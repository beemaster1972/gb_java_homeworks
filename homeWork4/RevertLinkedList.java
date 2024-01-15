/*
Перевернутый LinkedList

Инструкция по использованию платформы



Дан LinkedList с несколькими элементами разного типа. В методе revert класса LLTasks реализуйте разворот этого списка без использования встроенного функционала.

Пример


// Дан
[1, One, 2, Two]

// Вывод
[1, One, 2, Two]
[Two, 2, One, 1]
 */

import java.util.LinkedList;

public class RevertLinkedList {

  public static LinkedList<Object> revert(LinkedList<Object> ll) {
    LinkedList<Object> result = new LinkedList<>();
    for (int i = ll.size() - 1; i >= 0; i--)
      result.add(ll.get(i));
    return result;
  }

  public static void main(String[] args) {
    LinkedList<Object> ll = new LinkedList<>();
    ll.add(1);
    ll.add("One");
    ll.add(2);
    ll.add("Two");
    System.out.println(revert(ll));
  }
}
