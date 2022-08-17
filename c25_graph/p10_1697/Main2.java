package c25_graph.p10_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int[] v = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int res = bfs(N, K);
        System.out.println(res);
    }

    private static int bfs(int N, int K) {
        Queue<Integer> queue = new ArrayDeque<>();
        v[N] = 0;
        queue.add(N);

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            if(x == K) break;
            if (x - 1 >= 0 && v[x - 1] == 0) {
                v[x - 1] = v[x] + 1;
                queue.add(x - 1);
            }
            if (x + 1 <= 100000 && v[x + 1] == 0) {
                v[x + 1] = v[x] + 1;
                queue.add(x + 1);
            }
            if (2 * x <= 100000 && v[2 * x] == 0) {
                v[2 * x] = v[x] + 1;
                queue.add(2 * x);
            }
        }
        return v[K];
    }
}
