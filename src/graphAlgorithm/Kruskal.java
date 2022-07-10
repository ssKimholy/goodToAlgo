package graphAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
    static int[] parent; // 부모확인 노드
    static ArrayList<Edge> list = new ArrayList<>();
    public static void main(String[] args) {
        int n = 7; // 전체 노드의 개수
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; // 자기 자신을 부모로 초기화
        }

        // 간선 연결
        list.add(new Edge(1, 7, 12));
        list.add(new Edge(1, 4, 28));
        list.add(new Edge(1, 2, 67));
        list.add(new Edge(1, 5, 17));
        list.add(new Edge(2, 4, 24));
        list.add(new Edge(2, 5, 62));
        list.add(new Edge(3, 5, 20));
        list.add(new Edge(3, 6, 37));
        list.add(new Edge(4, 7, 13));
        list.add(new Edge(5, 6, 45));
        list.add(new Edge(5, 7, 73));

        // 거리 순으로 정렬 후
        Collections.sort(list);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            // 그 간선이 사이클을 도는지 확인.
            if (!find(list.get(i).nodeA-1, list.get(i).nodeB-1)) {
                // 사이클을 돌지 않는다면 비용 추가 후, union.
                sum += list.get(i).cost;
                union(list.get(i).nodeA-1, list.get(i).nodeB-1);
            }
        }

        System.out.println(sum);
    }

    private static int getParent(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = getParent(parent[i]);
    }

    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static boolean find(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a == b) {
            return true;
        }
        return false;
    }
}

class Edge implements Comparable<Edge> {
    int nodeA; // a간선
    int nodeB; // b간선
    int cost; // a간선과 b간선을 연결하는데 드는 비용 or 거리

    public Edge(int nodeA, int nodeB, int cost) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge edge) {
        // 거리 순 정렬
        return this.cost - edge.cost;
    }
}