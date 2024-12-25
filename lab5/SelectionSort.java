import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Интерфейс для сортировок
interface SortAlgorithm {
    <T extends Comparable<T>> void sort(T[] array);
}

// Реализация алгоритма Selection Sort
class SelSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

// Репозиторий для управления массивами
class ArrayRepository<T extends Comparable<T>> {
    private List<T[]> arrays;

    public ArrayRepository() {
        this.arrays = new ArrayList<>();
    }

    // Добавление нового массива
    public void addArray(T[] array) {
        arrays.add(array);
    }

    // Удаление массива
    public void removeArray(T[] array) {
        arrays.remove(array);
    }

    // Обновление массива
    public void updateArray(T[] oldArray, T[] newArray) {
        int index = arrays.indexOf(oldArray);
        if (index != -1) {
            arrays.set(index, newArray);
        }
    }

    // Получение всех массивов
    public List<T[]> getArrays() {
        return new ArrayList<>(arrays);
    }
}

// Главный класс
public class Sorter {
    public static void main(String[] args) {
        // Создаем репозиторий массивов
        ArrayRepository<Integer> repository = new ArrayRepository<>();

        // Добавляем массивы в репозиторий
        Integer[] array1 = {64, 25, 12, 22, 11};
        Integer[] array2 = {3, 5, 2, 8, 6};
        repository.addArray(array1);
        repository.addArray(array2);

        // Отображаем исходные массивы
        System.out.println("Исходные массивы:");
        for (Integer[] array : repository.getArrays()) {
            System.out.println(Arrays.toString(array));
        }

        // Создаем объект сортировки
        SortAlgorithm selectionSort = new SelSort();

        // Сортируем массивы
        for (Integer[] array : repository.getArrays()) {
            selectionSort.sort(array);
        }

        // Отображаем отсортированные массивы
        System.out.println("\nОтсортированные массивы:");
        for (Integer[] array : repository.getArrays()) {
            System.out.println(Arrays.toString(array));
        }
    }
}
