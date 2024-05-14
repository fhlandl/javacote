package hello.javacote.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void middlePivotQuickSortTest() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        QuickSort.print(arr);
        QuickSort.sort(arr);
        QuickSort.print(arr);
    }
}