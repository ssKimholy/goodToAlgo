package graphAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra_one {
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] d;
    public static void main(String[] args) {
        visited = new boolean[6];
        d = new int[6];
        for (int i = 0; i < 6; i++) {
            list.add(new ArrayList<>());
        }

        list.get(0).add(new Node(0, 0));
        list.get(0).add(new Node(1, 2));
        list.get(0).add(new Node(2, 5));
        list.get(0).add(new Node(3, 1));
        list.get(1).add(new Node(0, 2));
        list.get(1).add(new Node(1, 0));
        list.get(1).add(new Node(2, 3));
        list.get(1).add(new Node(3, 2));
        list.get(2).add(new Node(0, 5));
        list.get(2).add(new Node(1, 3));
        list.get(2).add(new Node(2, 0));
        list.get(2).add(new Node(3, 3));
        list.get(2).add(new Node(4, 1));
        list.get(2).add(new Node(5, 5));
        list.get(3).add(new Node(0, 1));
        list.get(3).add(new Node(1, 2));
        list.get(3).add(new Node( 2, 3));
        list.get(3).add(new Node(3, 0));
        list.get(3).add(new Node(4, 1));
        list.get(4).add(new Node(2, 1));
        list.get(4).add(new Node(3, 1));
        list.get(4).add(new Node(4, 0));
        list.get(4).add(new Node(5, 2));
        list.get(5).add(new Node(2, 5));
        list.get(5).add(new Node(4, 2));
        list.get(5).add(new Node(5, 0));

        Arrays.fill(d, Integer.MAX_VALUE); // 최단경로 배열 최대값으로 초기화

        dijkstra(0);

        for (int i = 0; i < 6; i++) {
            System.out.println(d[i]);
        }

    }

    static int getSmallIndex() {
        // 현재 방문하지 않은 노드 중에서 가장 최소거리를 가진 인덱스를 반환.
        int min = Integer.MAX_VALUE;
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
        for (int i = 0; i < list.get(start).size(); i++) {
            // start부터 시작해서 연결된 노드들 먼저 초기화.
            d[i] = list.get(start).get(i).getDistance();
        }
        visited[start] = true;

        for (int i = 0; i < 5; i++) {
            // 시작점을 제외하고 반복.
            int current = getSmallIndex();
            visited[current] = true;
            for (int j = 0; j < list.get(current).size(); j++) {
                // current와 연결된 노드들을 최소값으로 갱신하게 만든다.
                int cost = d[current] + list.get(current).get(j).getDistance();
                if (cost < d[list.get(current).get(j).getIdx()]) {
                    d[list.get(current).get(j).getIdx()] = cost;
                }
            }
        }
    }
}

class Node {
    int idx;
    int distance;

    public Node(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }

    public int getIdx() {
        return idx;
    }

    public int getDistance() {
        return distance;
    }
}
