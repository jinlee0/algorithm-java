package c16_dp1.p6_1149;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3]; // dp[x][y] x 집이 y색인 경우 1~x 비용 최소 합
        int[] rgb = new int[3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[0] = Integer.parseInt(st.nextToken());
            rgb[1] = Integer.parseInt(st.nextToken());
            rgb[2] = Integer.parseInt(st.nextToken());
            // 현재 i번째 집이 j색인 경우, i-1번째 집이 다른 색인 경우 두 가지 중 최소를 현재 비용과 더한다.
            for (int j = 0; j < 3; j++) dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + rgb[j];
        }
        int res = Arrays.stream(dp[N]).min().getAsInt();
        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
        br.close();
    }

}
