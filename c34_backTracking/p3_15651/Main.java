package c34_backTracking.p3_15651;

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
        comb(0, N, M, new int[M]);
        System.out.println(sb);
    }

    private static void comb(int depth, int N, int M, int[] result) {
        if (depth == M) {
            for (int i = 0; i < M; i++) sb.append(result[i]).append(' ');
            sb.append(System.lineSeparator());
            return;
        }
        for (int i = 1; i <= N; i++) {
            result[depth] = i;
            comb(depth + 1, N, M, result);
        }
    }
}
