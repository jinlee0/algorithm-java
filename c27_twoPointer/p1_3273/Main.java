package c27_twoPointer.p1_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());

        int res = solution(arr, x);
        System.out.println(res);

        br.close();
    }

    private static int solution(int[] arr, int x) {
        int cnt = 0;
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if(sum > x) end--;
            else if(sum < x) start++;
            else {
                cnt++;
                start++;
                end--;
            }
        }
        return cnt;
    }
}
