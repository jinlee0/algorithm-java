package c33_greedy.p2_1931;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 확실히 String::split보다 StringTokenizer가 빠르다!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int res = solution(arr);
        bw.write(Integer.toString(res));
        bw.close();
        br.close();
    }

    private static int solution(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int idx = 1;
        int cnt = 1;
        int last = 0;
        while (idx < arr.length) {
            if (arr[idx][0] >= arr[last][1]) {
                cnt++;
                last = idx;
            }
            idx++;
        }
        return cnt;
    }
}
