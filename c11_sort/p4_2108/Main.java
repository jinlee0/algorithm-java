package c11_sort.p4_2108;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        int[] res = solution(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) sb.append(res[i]).append(System.lineSeparator());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] solution(int[] arr) {
        int sum = 0;
        int[] counting = new int[8001];
        for (int i = 0; i < arr.length; i++) counting[arr[i] + 4000]++;
        for (int i = 1; i < counting.length; i++) counting[i] += counting[i - 1];
        return null;
    }

}
