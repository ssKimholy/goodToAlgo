package graphAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NetWorkFlow_Edmonds_Karp {
    static int n = 6, result = 0;
    static final int MAX = 100;
    static int[][] capacity = new int[MAX][MAX]; // 노드의 용량 배열
    static int[][] flow = new int[MAX][MAX]; // 노드의 유량 배열
    static int[] visited = new int[MAX];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1); // 양방향연결
        graph.get(1).add(0);
        graph.get(0).add(3);
        graph.get(3).add(0);
        capacity[0][1] = 12;
        capacity[0][3] = 11;

        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(1).add(3);
        graph.get(3).add(1);
        graph.get(1).add(4);
        graph.get(4).add(1);
        graph.get(1).add(5);
        graph.get(5).add(1);
        capacity[1][2] = 6;
        capacity[1][3] = 3;
        capacity[1][4] = 5;
        capacity[1][5] = 9;

        graph.get(2).add(5);
        graph.get(5).add(2);
        capacity[2][5] = 8;

        graph.get(3).add(4);
        graph.get(4).add(3);
        capacity[3][4] = 9;

        graph.get(4).add(2);
        graph.get(2).add(4);
        graph.get(4).add(5);
        graph.get(5).add(4);
        capacity[4][2] = 3;
        capacity[4][5] = 4;

        maxFlow(0, 5);

        System.out.print(result);
    }

    static void maxFlow(int start, int end) {
        while (true) {
            // 더 이상 경로를 찾을 수 없을 때까지 반복
            Queue<Integer> que = new LinkedList<>();
            que.offer(start);
            Arrays.fill(visited, -1); // 방문처리 초기화
            visited[start] = start;

            while (!que.isEmpty() && visited[end] == -1) {
                // bfs조건문이지만, 도착지 노드가 방문되었는지 체크하는 조건이기도 하다.
                int v = que.poll();
                for (int a : graph.get(v)) {
                    if (capacity[v][a] > flow[v][a] && visited[a] == -1) {
                        // 남은 용량이 있고 방문하지 않은 곳은 모두 큐에 넣는다. (가장 먼저 도착지에 도착하면 그게 최단경로).
                        que.offer(a);
                        visited[a] = v; // 경로를 추적하기위해 다음과 같이 값을 넣는다.
                    }
                }
            }

            if (visited[end] == -1) {
                // bfs가 끝났는데도 도착지가 방문이 안되었다면 더 이상 경로가 없는 것이다.
                break;
            }

            int maxFlow = Integer.MAX_VALUE;
            for (int i = end; i != start; i = visited[i]) {
                // 경로 중 최소 유량을 찾고, 경로 모두에 유량을 더한다.
                maxFlow = Math.min(maxFlow, capacity[visited[i]][i] - flow[visited[i]][i]);
            }

            for (int i = end; i != start; i = visited[i]) {
                flow[visited[i]][i] += maxFlow;
                flow[i][visited[i]] -= maxFlow; // 역간선 처리.
            }

            result += maxFlow;
        }
    }
}
