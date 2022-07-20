package c16_dp1.p5_1912;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[n];
        arr = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        dp[0] = arr[0];

        getMaxSubsequenceSum(n-1);

        bw.write(Integer.toString(IntStream.of(dp).max().getAsInt()));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getMaxSubsequenceSum(int n) {
        if(dp[n] == Integer.MIN_VALUE){
            dp[n] = Math.max(getMaxSubsequenceSum(n - 1), 0) + arr[n];
        }
        return dp[n];
    }
}
