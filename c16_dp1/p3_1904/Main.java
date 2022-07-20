package c16_dp1.p3_1904;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int DIVIDER = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[1000001];
        Arrays.fill(arr, -1);
        arr[0] = 0; arr[1] = 1; arr[2] = 2;

        int res = solution(N);

        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
        br.close();
    }
    private static int solution(int N) {
        if(arr[N] == -1) arr[N] = (solution(N - 1) + solution(N - 2)) % DIVIDER;
        return arr[N];
    }
}
