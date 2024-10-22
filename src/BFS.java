import java.util.*;

public class BFS {
    public static List<Integer> bfs(int n, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for (int k : adj.get(cur)) {
                if (!visited[k]) {
                    q.add(k);
                    visited[k] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();

        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int f = scanner.nextInt();
            int t = scanner.nextInt();
            adj.get(f).add(t);
            adj.get(t).add(f);
        }

        List<Integer> result = bfs(n, adj);

        for (int i : result) {
            System.out.print(i + " ");
        }

        scanner.close();
    }
}
