public class SelectionSort {
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Исходный массив:");
        for (int i : array) {
            System.out.print(i + " ");
        }

        selectionSort(array);

        System.out.println("\nОтсортированный массив:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}