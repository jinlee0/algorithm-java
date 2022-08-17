package c25_graph.p10_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] v = new boolean[100001];
    static List<List<Integer>> E = new ArrayList<>();
    static int[] res = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < 100001; i++) E.add(new ArrayList<>());
        for (int i = 100000; i > 0; i--) {
            if(i%2 == 0) E.get(i / 2).add(i);
            E.get(i).add(i - 1);
            E.get(i - 1).add(i);
        }

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
        System.out.println(res[K]);

    }

    private static void bfs(int N, int K) {
        Queue<Integer> queue = new ArrayDeque<>();
        v[N] = true;
        queue.add(N);
        res[N] = 0;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            if(x == K) return;
            for (Integer next : E.get(x)) {
                if (!v[next]) {
                    v[next] = true;
                    queue.add(next);
                    res[next] = res[x] + 1;
                }
            }

        }
    }
}
