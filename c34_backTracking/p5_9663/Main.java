package c34_backTracking.p5_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        solution(new int[N], 0, N);
        System.out.println(cnt);
    }

    private static void solution(int[] arr, int depth, int N) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if(possible(arr, depth)) solution(arr, depth + 1, N);
        }
    }

    private static boolean possible(int[] arr, int c) {
        for (int i = 0; i < c; i++) {
            if(arr[c] == arr[i]) return false;
            else if (Math.abs(c-i) == Math.abs(arr[c] - arr[i])) return false;
        }
        return true;
    }
}
