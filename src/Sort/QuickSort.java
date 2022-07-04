package Sort;
// 퀵정렬은 분할정복 알고리즘이다.
// divide And conquer

import java.util.Arrays;

public class QuickSort {
    static int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
    public static void main(String[] args) {
        int n = arr.length;
        quickSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return; // 원소가 하나인 경우.
        }

        int pivot = start; // 피봇값 설정
        int i = start + 1; // 피봇값보다 큰 값을 찾는 인덱스
        int j = end; // 피봇값보다 작은 값을 찾는 인덱스
        int tmp;

        while (i <= j) {
            while (i <= end && arr[i] <= arr[pivot]) { // 피봇값보다 큰 값을 찾아준다.
                i++;
            }
            while (j > start && arr[j] >= arr[pivot]) { // 피봇값보다 작은 값을 찾아준다.
                j--;
            }

            if (i > j) { // 만약 엇갈렸다면 j번째 값과 피봇값 교체
                tmp = arr[j];
                arr[j] = arr[pivot];
                arr[pivot] = tmp;
            } else { // 엇갈리지 않았다면 i번째 값과 j번째 값 교체
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);
    }
}
