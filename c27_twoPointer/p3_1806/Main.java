package c27_twoPointer.p3_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int S = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st2.nextToken());

        int res = solution(arr, N, S);
        System.out.println(res);

        br.close();
    }

    private static int solution(int[] arr, int N, int S) {
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while (start < N && end < N) {
            sum += arr[end];
            if (sum >= S) {
                int dist = end - start + 1;
                if(dist < min) min = dist;
                sum -= arr[start];
                sum -= arr[end];
                start++;
            } else {
                end++;
            }
        }

        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
