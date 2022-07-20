package c16_dp1.p10_10844;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long res = solution(N);
        bw.write(Long.toString(res));
        bw.flush();
        br.close();
        bw.close();
    }

    private static long solution(int N) {
        long[][] dp = new long[N + 1][10];
        Arrays.fill(dp[1], 1L);
        dp[1][0] = 0L;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < 9; j++) dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) sum = (sum + dp[N][i]) % MOD;
        return sum;
    }

}
