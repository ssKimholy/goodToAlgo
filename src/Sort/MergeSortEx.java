package Sort;

import java.util.Arrays;

public class MergeSortEx {
    static int number = 10;
    static int[] sorted = new int[10]; // 배열을 메서드안에서 계속 생성하면 메모리 낭비가 심할 수 있다.
    public static void main(String[] args) {
        int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        mergeSort(arr, 0, 9);
        System.out.println(Arrays.toString(arr));
    }

    static void merge(int[] a, int m, int mid, int n) {
        int i = m; // 왼쪽 배열 시작 인덱스
        int j = mid + 1; // 오른쪽 배열 시작 인덱스
        int k = m; // 정렬된 배열 인덱스

        while (i <= mid && j <= n) {
            // mid는 왼쪽 배열 끝 인덱스
            if (a[i] <= a[j]) {
                // 정해진 영역까지 더 작은 값을 먼저 배열에 넣으며 정렬.
                sorted[k] = a[i];
                i++;
            } else {
                sorted[k] = a[j];
                j++;
            }
            k++;
        }

        if (i > mid) { // 왼쪽 배열이 먼저 정렬이 끝났다면 오른쪽 배열을 그대로 정렬 배열에 삽입
            for (int p = j; p <= n; p++) {
                sorted[k] = a[p];
                k++;
            }
        } else {
            for (int p = i; p <= mid; p++) {
                sorted[k] = a[p];
                k++;
            }
        }

        for (int p = m; p <= n; p++) {
            a[p] = sorted[p];
            // 정렬 배열의 값을 원배열에 대입 그래야 값이 진짜 배열에 정렬된 상태로 갱신.
        }
    }

    static void mergeSort(int[] a, int m, int n) {
        if (m >= n) { // 원소가 하나인 경우는 정렬필요 X
            return;
        }

        int mid = (m+n) / 2;
        mergeSort(a, m, mid); // 중앙값을 기준으로 반으로 계속 쪼갠다.
        mergeSort(a, mid+1, n);
        merge(a, m, mid, n); // 그 후에 merge하면서 정렬
    }
}
