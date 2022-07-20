package c16_dp1.p9_1463;

import java.io.*;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int res = solution(N);
        bw.write(Integer.toString(res));
        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(int N) {
        int[] dp = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1];
            if(i%3==0) dp[i] = Math.min(dp[i / 3], dp[i]);
            if (i%2==0) dp[i] = Math.min(dp[i / 2], dp[i]);
            dp[i]++;
        }
        return dp[N];
    }
}
