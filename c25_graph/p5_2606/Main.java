package c25_graph.p5_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int cnt = 0;
    static List<Queue<Integer>> E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        E = new ArrayList<>();
        for (int i = 0; i <= N; i++) E.add(new PriorityQueue<>());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            E.get(u).add(v);
            E.get(v).add(u);
        }

        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int x) {
        visited[x] = true;
        for (Integer next : E.get(x)) {
            if(!visited[next]) {
                cnt++;
                dfs(next);
            }
        }
    }
}
