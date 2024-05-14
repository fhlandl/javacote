package hello.javacote.sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickSort {

    public static void sort(int[] arr) {
        middlePivotSort(arr, 0, arr.length - 1);
    }

    public static void print(int[] arr) {
        log.info("{}", arr);
    }

    private static void middlePivotSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int pivot = middlePivotPartition(arr, left, right);

        middlePivotSort(arr, left, pivot);
        middlePivotSort(arr, pivot + 1, right);
    }

    private static int middlePivotPartition(int[] arr, int left, int right) {

        int low = left - 1;
        int high = right + 1;
        int pivot = arr[(left + right) / 2];

        while (true) {

            do {
                low++;
            } while (arr[low] < pivot);

            do {
                high--;
            } while (arr[high] > pivot && low <= high);

            if (low >= high) {
                break;
            }

            swap(arr, low, high);
        }

        return high;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
