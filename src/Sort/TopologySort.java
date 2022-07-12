package Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologySort {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<Integer> answer = new ArrayList<>();
    static int[] inDegree = new int[8];
    public static void main(String[] args) {
        int n = 7;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        list.get(1).add(2);
        inDegree[2]++;
        list.get(1).add(5);
        inDegree[5]++;
        list.get(2).add(3);
        inDegree[3]++;
        list.get(3).add(4);
        inDegree[4]++;
        list.get(4).add(6);
        inDegree[6]++;
        list.get(5).add(6);
        inDegree[6]++;
        list.get(6).add(7);
        inDegree[7]++;
        topology(n);
    }

    static void topology(int n) {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                que.offer(i);
            }
        } // 진입 차수가 0인 노드를 삽입

        for (int i = 1; i <= n; i++) {
            if (que.isEmpty()) {
                System.out.println("사이클 발생");
            } // n개의 노드를 다 돌기전에 큐가 빈다면 그건 사이클이 발생했다는 것이다.

            int tmp = que.poll();
            answer.add(tmp);
            // 큐에서 나온 순서대로 정렬.

            for (int a : list.get(tmp)) {
                if (--inDegree[a] == 0) {
                    // tmp와 연결된 간선 제거 후 진입차수가 0이 되는 노드가 있다면 큐에 삽입.
                    que.offer(a);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
