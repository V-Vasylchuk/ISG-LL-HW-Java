package lessons.third;

import java.util.ArrayList;
import java.util.LinkedList;

public class CompareListSpeed {
    long startTime = System.nanoTime();
    long endTime = System.nanoTime();

    public void addingToStart(ArrayList<Integer> arrayList,
                              LinkedList<Integer> linkedList,
                              int addingTimes) {
        startTime = System.nanoTime();
        for (int i = 0; i < addingTimes; i++) {
            arrayList.add(0, i);
        }
        endTime = System.nanoTime();
        long durationArrayListStart = endTime - startTime;
        System.out.println("Додавання елементів на початок ArrayList: "
                + durationArrayListStart + " наносекунд");

        startTime = System.nanoTime();
        for (int i = 0; i < addingTimes; i++) {
            linkedList.add(0, i);
        }
        endTime = System.nanoTime();
        long durationLinkedListStart = endTime - startTime;
        System.out.println("Додавання елементів на початок LinkedList: "
                + durationLinkedListStart + " наносекунд");

    }
    public void addingToCentre(ArrayList<Integer> arrayList,
                               LinkedList<Integer> linkedList,
                               int addingTimes) {
        startTime = System.nanoTime();
        for (int i = 0; i < addingTimes; i++) {
            arrayList.add(arrayList.size() / 2, i);
        }
        endTime = System.nanoTime();
        long durationArrayListMiddle = endTime - startTime;
        System.out.println("Додавання елементів у середину ArrayList: "
                + durationArrayListMiddle + " наносекунд");

        startTime = System.nanoTime();
        for (int i = 0; i < addingTimes; i++) {
            linkedList.add(linkedList.size() / 2, i);
        }
        endTime = System.nanoTime();
        long durationLinkedListMiddle = endTime - startTime;
        System.out.println("Додавання елементів у середину LinkedList: "
                + durationLinkedListMiddle + " наносекунд");
    }
    public void addingToEnd(ArrayList<Integer> arrayList,
                            LinkedList<Integer> linkedList,
                            int addingTimes) {
        startTime = System.nanoTime();
        for (int i = 0; i < addingTimes; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        long durationArrayListEnd = endTime - startTime;
        System.out.println("Додавання елементів у кінець ArrayList: "
                + durationArrayListEnd + " наносекунд");


        startTime = System.nanoTime();
        for (int i = 0; i < addingTimes; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        long durationLinkedListEnd = endTime - startTime;
        System.out.println("Додавання елементів у кінець LinkedList: "
                + durationLinkedListEnd + " наносекунд");
    }
}
