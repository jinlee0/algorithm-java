package c33_greedy.p1_11047;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String[] NK = line.split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        int res = solution(arr, K);
        bw.write(Integer.toString(res));
        bw.close();
        br.close();
    }

    private static int solution(int[] arr, int K) {
        int money = K;
        int idx = arr.length - 1;
        int cnt = 0;
        while (idx > -1) {
            if (money >= arr[idx]) {
                cnt += money / arr[idx];
                money %= arr[idx];
            }
            idx--;
        }
        return cnt;
    }
}
