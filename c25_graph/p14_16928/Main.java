package c25_graph.p14_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[] v = new int[101];
    static int[] ladder = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ladder[from] = to;
        }

        int res = bfs();
        System.out.println(res);
    }

    private static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer cur = queue.remove();
            if(cur == 100) break;
            for (int i = 1; i <= 6; i++) {
                int next = i + cur;
                if (next < 101 && v[next] == 0) {
                    v[next] = v[cur] + 1;
                    if (ladder[next] != 0) { // 여기서 ladder[next] != 0 && v[ladder[next]] == 0 하면 안됨. 분리함. 왜?
                        if (v[ladder[next]] == 0) {
                            v[ladder[next]] = v[next];
                            queue.add(ladder[next]);
                        }
                    } else {
                        queue.add(next);
                    }
                }
            }
        }

        return v[100];
    }
}
