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
            Arrays.fill(visited, false);
            if (dfs(i)) count++;
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
                    answer[i] = n;
                    return true;
                }
            }
        }
        
        return false;
    }
}
