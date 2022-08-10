package c25_graph.p6_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> E = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) E.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            E.get(u).add(v);
            E.get(v).add(u);
        }

        for (List<Integer> list : E) {
            Collections.sort(list);
        }
        dfs(V);
        sb.append(System.lineSeparator());
        Arrays.fill(visited, false);
        bfs(V);
        System.out.println(sb);
    }

    private static void bfs(int V) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[V] = true;
        queue.add(V);

        while (queue.size() != 0) {
            int x = queue.poll();
            sb.append(x).append(' ');
            for (Integer next : E.get(x)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    private static void dfs(int V) {
        visited[V] = true;
        sb.append(V).append(' ');
        for (Integer next : E.get(V)) {
            if (!visited[next]) dfs(next);
        }
    }
}
