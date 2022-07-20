package c16_dp1.p4_9461;

import java.io.*;
import java.util.Arrays;

public class Main {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setDp();
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(solution(Integer.parseInt(br.readLine()))).append(System.lineSeparator());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long solution(int N) {
        if(dp[N] == -1) dp[N] = solution(N-3) + solution(N-2);
        return dp[N];
    }

    private static void setDp() {
        dp = new long[101];
        Arrays.fill(dp, -1);
        dp[1] = dp[2] = dp[3] = 1;
    }
}
