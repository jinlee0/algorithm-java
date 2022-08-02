package c34_backTracking.p2_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        comb(new boolean[N + 1], 0, 1, N, M);
        System.out.println(sb);
    }

    private static void comb(boolean[] visited, int depth, int start, int N, int M) {
        if (depth == M) {
            for (int i = 1; i <= N; i++) {
                if (visited[i]) {
                    sb.append(i).append(' ');
                }
            }
            sb.append(System.lineSeparator());
        }
        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(visited, depth + 1, i + 1, N, M);
                visited[i] = false;
            }
        }
    }
}
