package hello.javacote.sort;

import hello.javacote.aop.TimeLogAspect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@Import({TimeLogAspect.class})
@SpringBootTest
class QuickSortTest {

    @Autowired
    private QuickSort quickSort;

//    int[] arr = {10, 7, 8, 9, 1, 5};
    int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

    @BeforeEach
    void printOriginalArray() {
        quickSort.print(arr);
    }

    @Test
    void middlePivotQuickSortTest() {
        quickSort.middlePivotSort(arr);
    }

    @Test
    void leftPivotQuickSortTest() {
        quickSort.leftPivotSort(arr);
    }

    @Test
    void rightPivotQuickSortTest() {
        quickSort.rightPivotSort(arr);
    }
}
