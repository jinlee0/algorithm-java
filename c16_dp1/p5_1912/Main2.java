package c16_dp1.p5_1912;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main2 {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        dp[0] = arr[0];

        getMaxSubsequenceSum(n);

        bw.write(Integer.toString(IntStream.of(dp).max().getAsInt()));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void getMaxSubsequenceSum(int n) {
        for (int i = 1; i < n; i++) dp[i] = Math.max(dp[i - 1], 0) + arr[i];
    }
}
