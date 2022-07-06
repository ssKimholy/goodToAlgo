package Sort;

public class HeapSort {
    static int n = 10;
    static int[] arr = {10, 26, 5, 37, 1, 61, 1, 59, 15, 48, 19};
    public static void main(String[] args) {

        for (int i = 1; i < n; i++) { // 상향식
            int child = i;
            do {
                int root = (child - 1) / 2;
                if (arr[root] < arr[child]) {
                    int tmp = arr[root];
                    arr[root] = arr[child];
                    arr[child] = tmp;
                }
                child = root;
            } while (child != 0);
        } // 상향식으로 힙 생성.

        for (int i = n - 1; i >= 0; i--) { // 하향식
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            // 루트를 가장 끝값과 교체하여 그 수를 제외하고 heapify.
            int root = 0;
            int child;
            do {
                child = 2 * root + 1;
                if (child < i - 1 && arr[child] < arr[child + 1]) {
                    child++;
                } // 왼쪽 자식보다 오른쪽 자식이 더 크면 1 증가.

                if (child < i && arr[root] < arr[child]) {
                    // 자식이 부모보다 값이 크다면 교체
                    tmp = arr[root];
                    arr[root] = arr[child];
                    arr[child] = tmp;
                }
                root = child; // 밑으로 내려간다.
            } while (root < i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
