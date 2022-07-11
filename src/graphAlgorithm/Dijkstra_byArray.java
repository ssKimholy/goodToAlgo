package graphAlgorithm;

import java.util.Arrays;

public class Dijkstra_1 {
    static int INF = 1_000_000_000;
    static int[][] arr = {
            {0, 2, 5, 1, INF, INF},
            {2, 0, 3, 2, INF, INF},
            {5, 3, 0, 3, 1, 5},
            {1, 2, 3, 0, 1, INF},
            {INF, INF, 1, 1, 0, 2},
            {INF, INF, 5, INF, 2, 0},
    };
    static boolean[] visited;
    static int[] d;
    public static void main(String[] args) {
        visited = new boolean[6];
        d = new int[6];
        Arrays.fill(d, Integer.MAX_VALUE);
        dijkstra(0);
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }
    }

    static int getSmallIndex() {
        int min = INF;
        int idx = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] < min && !visited[i]) {
                min = d[i];
                idx = i;
            }
        }
        return idx;
    }

    static void dijkstra(int start) {
        for (int i = 0; i < arr.length; i++) {
            d[i] = arr[start][i];
        }
        visited[start] = true;

        for (int i = 0; i < arr.length - 1; i++) {
            int current = getSmallIndex();
            visited[current] = true;
            for (int j = 0; j < arr.length; j++) {
                if (!visited[j] && d[current] + arr[current][j] < d[j]) {
                    d[j] = d[current] + arr[current][j];
                }
            }
        }
    }
}
