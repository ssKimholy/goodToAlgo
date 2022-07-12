package graphAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_byHeap {
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

        Arrays.fill(d, 1_000_000_000);

        dijkstra(0);

        for (int i = 0; i < 6; i++) {
            System.out.println(d[i]);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Nodes> pq = new PriorityQueue<>();
        pq.offer(new Nodes(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Nodes nodes = pq.poll();
            int distance = nodes.getDistance();
            int now = nodes.getIdx();

            if (d[now] < distance) continue; // 이미 처리가 된 노드는 더 이상 반복문을 탈 필요가 없다. (이미 최단 경로를 갱신한 노드이기 때문에)

            for (int i = 0; i < list.get(now).size(); i++) {
                int cost = d[now] + list.get(now).get(i).getDistance();
                if (cost < d[list.get(now).get(i).getIdx()]) {
                    d[list.get(now).get(i).getIdx()] = cost;
                    pq.offer(new Nodes(list.get(now).get(i).getIdx(), cost));
                    // 우선순위 큐에 삽입.
                }
            }
        }
    }
}

class Nodes implements Comparable<Nodes> {
    int idx;
    int distance;

    public Nodes(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }

    public int getIdx() {
        return idx;
    }

    public int getDistance() {
        return distance;
    }


    @Override
    public int compareTo(Nodes n) {
        return this.getDistance() - n.getDistance();
    } // 거리 순으로 정렬
}
