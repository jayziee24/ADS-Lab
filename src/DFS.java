import java.util.*;

public class DFS {
    static void dfsRecursive(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> ans) {
        ans.add(cur);
        visited[cur] = true;
        for (int k : adj.get(cur)) {
            if (!visited[k]) dfsRecursive(k, adj, visited, ans);
        }
    }

    static List<Integer> dfs(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        dfsRecursive(0, adj, visited, ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  
        int e = scanner.nextInt();  
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();  
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int f = scanner.nextInt();  
            int t = scanner.nextInt();  
            adj.get(f).add(t);
            adj.get(t).add(f);
        }

        List<Integer> ans = dfs(n, adj);  
        for (int k : ans) {  
            System.out.print(k + " ");
        }
    }

}