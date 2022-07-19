
import java.util.*;

class HelloWorld {
    static int[] answer;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n = 3;
    public static void main(String[] args) {
        int count = 0;
        answer = new int[n+1];
        visited = new boolean[n+1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(1);
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(1);
        graph.get(3).add(2);
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false); // 한 번 돌때마다 초기화해야 미카운트를 막을 수 있다.
            if (dfs(i)) count++; // dfs가 true면 해당 번호가 정상적인 매칭이 됐다는 뜻이다.
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d -> %d\n", answer[i], i);
        }
    }
    
    static boolean dfs(int n) {
        
        for (int i : graph.get(n)) {
            if (!visited[i]) {
                visited[i] = true;
                
                if (answer[i] == 0 || dfs(answer[i])) {
                    // 해당 번호 그룹이 비어있거나 해당 자리 주인이 양보할 수 있다면 그 자리 차지.
                    answer[i] = n;
                    return true;
                }
            }
        }
        
        return false;
    }
}
