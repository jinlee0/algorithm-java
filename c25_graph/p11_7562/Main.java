package c25_graph.p11_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] v;
    static int I;
    static int[][] jumps = {
            {-1, 2}, {1, 2},
            {2, 1}, {2, -1},
            {1, -2}, {-1, -2},
            {-2, 1}, {-2, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            v = new int[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cur = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] dst = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int res = bfs(cur, dst);
            sb.append(res).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static int bfs(int[] cur, int[] dst) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(cur);
        v[cur[0]][cur[1]] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.remove();
            if(node[0] == dst[0] && node[1] == dst[1]) break;
            for (int[] jump : jumps) {
                int[] next = new int[]{node[0] + jump[0], node[1] + jump[1]};
                if(isValid(next)) {
                    if(v[next[0]][next[1]] == 0) {
                        queue.add(next);
                        v[next[0]][next[1]] = v[node[0]][node[1]] + 1;
                    }
                }
            }
        }

        return v[dst[0]][dst[1]] - 1;
    }

    private static boolean isValid(int[] point) {
        return point[0] >= 0 && point[0] < I && point[1] >= 0 && point[1] < I;
    }
}
