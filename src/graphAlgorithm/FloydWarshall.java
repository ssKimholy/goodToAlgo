package graphAlgorithm;

public class FloydWarshall {
    static final int INF = 1_000_000_000;
    static int[][] dis = {
            {0, 5, INF, 8},
            {7, 0, 9, INF},
            {2, INF, 0, 4},
            {INF, INF, 3, 0}
    };
    static int num = dis.length;
    public static void main(String[] args) {
        FloydWar();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void FloydWar() {
        // 플로이드-워셜 점화식.
        for (int k = 0; k < num; k++) {
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    // i에서 j로 가는 경로보다 i에서 k, k에서 j로 가는 경로가 더 짧다면 거리 갱신.
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
    }
}
