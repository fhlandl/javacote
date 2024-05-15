package hello.javacote.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    int[] arr = {10, 7, 8, 9, 1, 5};

    @BeforeEach
    void printOriginalArray() {
        QuickSort.print(arr);
    }

    @Test
    void middlePivotQuickSortTest() {
        QuickSort.middlePivotSort(arr);
    }

    @Test
    void leftPivotQuickSortTest() {
        QuickSort.leftPivotSort(arr);
    }

    @Test
    void rightPivotQuickSortTest() {
        QuickSort.rightPivotSort(arr);
    }
}
