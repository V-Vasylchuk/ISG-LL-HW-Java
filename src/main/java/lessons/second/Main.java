package lessons.second;

public class Main {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Масив до сортування:");
        printArray(array);

        BubbleSort.sort(array);
        System.out.println("\n Після сортування бульбашкою:");
        printArray(array);

        int[] secondArray = {64, 34, 25, 12, 22, 11, 90};
        InsertionSort.sort(secondArray);
        System.out.println("\n Після сортування вставками:");
        printArray(secondArray);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
