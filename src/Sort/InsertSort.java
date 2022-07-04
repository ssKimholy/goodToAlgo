package Sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 7};
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j-1] < arr[j]) {
                    break;
                }
                int tmp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = tmp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
