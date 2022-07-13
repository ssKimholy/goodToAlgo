package graphAlgorithm;

import java.util.ArrayList;
import java.util.Stack;

public class SCC_Tarjan {
    static int[] d; // 방문 여부 및 우선순위 배열
    static boolean[] finished; // 처리 유무를 확인하는 배열.
    static int priority = 0; // 우선순위
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> SCC = new ArrayList<>();

    public static void main(String[] args) {
        int v = 11; // 총 정점의 개수.
        d = new int[v+1];
        finished = new boolean[v+1];

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(1);
        graph.get(4).add(2);
        graph.get(4).add(5);
        graph.get(5).add(7);
        graph.get(6).add(5);
        graph.get(7).add(6);
        graph.get(8).add(5);
        graph.get(8).add(9);
        graph.get(9).add(10);
        graph.get(10).add(11);
        graph.get(11).add(3);
        graph.get(11).add(8);

        for (int i = 1; i <= v; i++) {
            if (d[i] == 0) dfs(i);
            // dfs는 각 노드당 한번씩은 돌아야 한다.
        }

        System.out.println("SCC의 개수: " + SCC.size());
        for (int i = 0; i < SCC.size(); i++) {
            System.out.printf("%d번째 SCC: ", i+1);
            for (int j = 0; j < SCC.get(i).size(); j++) {
                System.out.print(SCC.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static int dfs(int x) {
        d[x] = ++priority; // 우선순위 부여 겸 방문 처리.

        int parent = d[x]; // 현재 우선순위가 부모.
        stack.push(x); // 스택에 삽입

        for (int a : graph.get(x)) {
            // 연결된 노드를 다 탐색하는데
            if (d[a] == 0) parent = Math.min(parent, dfs(a)); // 방문하지 않은 노드라면 현재 우선순위와 dfs로 탐색한 부모 중 더 작은 값으로 부모갱신.
            else if (!finished[a]) parent = Math.min(parent, d[a]); // 방문은 했지만 처리가 되지 않은 노드는 현재 부모와 그 노드의 우선순위 중 더 작은 값으로 부모갱신.
        }

        if (parent == d[x]) {
            // 부모가 갱신되지 않았다면 가장 우선순위가 높으면서 그SCC의 헤드.
            ArrayList<Integer> scc = new ArrayList<>();
            while (!stack.isEmpty()) {
                int tmp = stack.pop();
                scc.add(tmp);
                finished[tmp] = true;
                // 그 scc를 꺼내면서 방문처리
                if (parent == tmp) {
                    break;
                }
            }
            SCC.add(scc);
        }

        return parent;
    }
}
