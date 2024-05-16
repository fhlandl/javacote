package hello.javacote.sort;

import hello.javacote.annotation.TimeLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuickSort {

    @TimeLog
    public void middlePivotSort(int[] arr) {
        middlePivotSort(arr, 0, arr.length - 1);
    }

    @TimeLog
    public void leftPivotSort(int[] arr) {
        leftPivotSort(arr, 0, arr.length - 1);
    }

    @TimeLog
    public void rightPivotSort(int[] arr) {
        rightPivotSort(arr, 0, arr.length - 1);
    }

    public void print(int[] arr) {
        log.info("{}", arr);
    }

    private void middlePivotSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int pivot = middlePivotPartition(arr, left, right);

        middlePivotSort(arr, left, pivot);
        middlePivotSort(arr, pivot + 1, right);
    }

    private int middlePivotPartition(int[] arr, int left, int right) {

        int low = left - 1;
        int high = right + 1;
        int pivotValue = arr[(left + right) / 2];

        while (true) {

            do {
                low++;
            } while (arr[low] < pivotValue);

            do {
                high--;
            } while (arr[high] > pivotValue && low <= high);

            if (low >= high) {
                break;
            }

            swap(arr, low, high);
            print(arr);
        }

        return high;
    }

    private void leftPivotSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = leftPivotPartition(arr, left, right);

        leftPivotSort(arr, left, pivot - 1);
        leftPivotSort(arr, pivot + 1, right);
    }

    private int leftPivotPartition(int[] arr, int left, int right) {

        int low = left;
        int high = right;
        int pivotValue = arr[left];

        while (low < high) {

            while (arr[high] > pivotValue && low < high) {
                high--;
            }

            while (arr[low] <= pivotValue && low < high) {
                low++;
            }

            printSwapPos(low, high);
            swap(arr, low, high);
            print(arr);
        }

        printSwapPos(left, low);
        swap(arr, left, low);
        print(arr);

        return low;
    }

    private void rightPivotSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = rightPivotPartition(arr, left, right);

        rightPivotSort(arr, left, pivot - 1);
        rightPivotSort(arr, pivot + 1, right);
    }

    private int rightPivotPartition(int[] arr, int left, int right) {

        int low = left;
        int high = right;
        int pivotValue = arr[right];

        while (low < high) {

            while (arr[low] < pivotValue && low < high) {
                low++;
            }

            while (arr[high] >= pivotValue && low < high) {
                high--;
            }

            swap(arr, low, high);
            print(arr);
        }

        swap(arr, right, high);
        print(arr);

        return high;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private void printSwapPos(int left, int right) {
        log.info("left: {}, right: {}", left, right);
    }
}
