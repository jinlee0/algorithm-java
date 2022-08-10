package c25_graph.p1_24479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, cnt = 1;
    static List<List<Integer>> E;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        E = new ArrayList<>();
        visited = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            E.add(new ArrayList<>());
        }

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

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<N+1; i++) {
            sb.append(visited[i]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void dfs(int R) {
        visited[R] = cnt++;
        for (Integer x : E.get(R)) {
            if(visited[x] == 0) {
                dfs(x);
            }
        }
    }
}
