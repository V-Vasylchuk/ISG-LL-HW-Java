package lessons.third;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        // Додавання елементів
        myList.addAll(List.of(1, 2, 3, 10, 12, 14, 42));
        // В кінець списку
        myList.add(38);
        // За індексом
        myList.add(112, 4);

        // Вивід розміру списку
        System.out.println("Розмір списку: " + myList.size());

        // Вивід елементів списку
        System.out.print("Елементи списку: ");
        printList(myList);

        // Видалення елемента за індексом
        System.out.println("Видалений об'єкт: " + myList.remove(2));
        // Видалення елемента за об'єктом
        System.out.println("Об'кт видалений? " + myList.remove((Integer) 38));

        // Вивід розміру списку після видалення
        System.out.println("Розмір списку після видалення: " + myList.size());

        // Зміна значення елемента за індексом
        System.out.println("Замінений елемент: " + myList.set(10, 0));

        // Вивід оновленого елемента та оновленого списку
        System.out.println("Оновлений перший елемент: " + myList.get(0));
        System.out.print("Оновлений список: ");
        printList(myList);
    }

    public static void printList(MyLinkedList<Integer> myList) {
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
    }
}
