package c16_dp1.p9_1463;

import java.io.*;
import java.util.Arrays;

public class Main {

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
        Arrays.fill(dp, -1);
        dp[1] = 0;
        return solution(dp, N);
    }

    private static int solution(int[] dp, int N) {
        if (dp[N] == -1) {
            int temp = 0;
            if (N % 6 == 0) {
                temp = Math.min(solution(dp, N / 3), Math.min(solution(dp, N / 2), solution(dp, N - 1)));
            } else if (N % 3 == 0) {
                temp = Math.min(solution(dp, N / 3), solution(dp, N - 1));
            } else if (N % 2 == 0) {
                temp = Math.min(solution(dp, N / 2), solution(dp, N - 1));
            } else temp = solution(dp, N - 1);
            dp[N] = temp + 1;
        }
        return dp[N];
    }
}

