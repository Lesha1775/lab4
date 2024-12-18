import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {
    @Test
    public void testSelectionSort() {
        int[] arr = {64, 25, 12, 22, 11};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{11, 12, 22, 25, 64}, arr);

        int[] arr2 = {5, 3, 8, 6, 2};
        SelectionSort.selectionSort(arr2);
        assertArrayEquals(new int[]{2, 3, 5, 6, 8}, arr2);

        int[] arr3 = {};
        SelectionSort.selectionSort(arr3);
        assertArrayEquals(new int[]{}, arr3);

        int[] arr4 = {1};
        SelectionSort.selectionSort(arr4);
        assertArrayEquals(new int[]{1}, arr4);
    }
}
