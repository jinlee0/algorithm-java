package c27_twoPointer.p5_1450;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String line2 = br.readLine();

        String[] NC = line.split(" ");
        int N = Integer.parseInt(NC[0]);
        int C = Integer.parseInt(NC[1]);
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(line2);
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int res = Knapsack(arr, N, C);
        bw.write(Integer.toString(res));
        bw.flush();

    }

    private static int Knapsack(final int[] arr, final int N, final int C) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        getCases(arr, list1, 0, N/2, 0, C);
        getCases(arr, list2, N/2, N, 0, C);
        Collections.sort(list2);

        int cnt = 0;
        for (int i = 0; i < list1.size(); i++) cnt += getUpperBoundIdx(list2, list1.get(i), C) + 1;

        return cnt;
    }

    private static int getUpperBoundIdx(ArrayList<Integer> list, int val, int C) {
        int start = 0;
        int end = list.size() - 1;
        while (true) {
            if(start > end) break;
            int mid = (start + end) / 2;
            if (list.get(mid) + val <= C) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    private static void getCases(int[] arr, List<Integer> list, int start, int end, int sum, int C) {
        if(sum > C) return;
        if(start == end) {
            list.add(sum);
            return;
        }
        getCases(arr, list, start + 1, end, sum, C);
        getCases(arr, list, start + 1, end, sum + arr[start], C);
    }
}
