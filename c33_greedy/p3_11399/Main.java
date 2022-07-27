package c33_greedy.p3_11399;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int res = solution(arr);
        bw.write(Integer.toString(res));
        bw.close();
        br.close();
    }

    private static int solution(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for(int i=0; i<arr.length; i++) sum += arr[i] * (arr.length - i);
        return sum;
    }
}
