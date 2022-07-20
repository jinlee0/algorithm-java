package c16_dp1.p12_11053;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[N]; // dp[i] : i 번째 값을 마지막으로 하는 증가 수열의 길이
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
        }
        int max = 0;
        for(int i : dp) max = Math.max(max, i);
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
