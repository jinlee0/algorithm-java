package c27_twoPointer.p2_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] res = solve(arr);
        System.out.println(res[0] + " " + res[1]);

        br.close();
    }

    private static int[] solve(int[] arr) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length-1;
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        while (start < end) {
            int sum = arr[start] + arr[end];
            int sumAbs = Math.abs(sum);
            if (sumAbs < min) {
                min = sumAbs;
                answer[0] = arr[start];
                answer[1] = arr[end];
            }
            if(sum < 0) start++;
            else if(sum > 0) end--;
            else break;
        }
        return answer;
    }
}
