package Sort;

public class CountingSort {
    static int[] count = new int[6];
    static int[] array = {1, 3, 2, 4, 3, 2, 5, 3, 1, 2,
                              3, 4, 4, 3, 5, 1, 2, 3, 5, 2,
                              3, 1, 4, 3, 5, 1, 2, 1, 1, 1};
    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
