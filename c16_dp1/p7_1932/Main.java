package c16_dp1.p7_1932;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] weights = new int[i];
            for (int j = 0; j < weights.length; j++){
                weights[j] = Integer.parseInt(st.nextToken());
                int prev1 = j > 0 ? dp[i - 1][j - 1] : 0;
                int prev2 = j < weights.length - 1 ? dp[i - 1][j] : 0;
                dp[i][j] = Math.max(prev1, prev2) + weights[j];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) res = Math.max(res, dp[n][i]);
        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
        br.close();
    }
}
