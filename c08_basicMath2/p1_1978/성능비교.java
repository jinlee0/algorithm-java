package c08_basicMath2.p1_1978;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Main2가 성능 훨 좋음. '에라토스테네스의 체' 알고리즘 O(N log log N)
public class 성능비교 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line1 = br.readLine();
        String line2 = br.readLine();
        br.close();

        int N = Integer.parseInt(line1);
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(line2);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list.add(arr[i]);
        }

        double timeSum1 = 0;
        for (int i = 0; i < 1000; i++) {
            long startTime = System.nanoTime();

            int res = Main.getNumberOfPrimes(arr);

            long endTime = System.nanoTime();
            Double elapsedTime = (endTime - startTime) / 1000000.0;
            System.out.println(elapsedTime);
            timeSum1 += elapsedTime;
        }

        double timeSum2 = 0;
        for (int i = 0; i < 1000; i++) {
            long startTime = System.nanoTime();

            int res = Main2.getNumberOfPrimes(list);

            long endTime = System.nanoTime();
            Double elapsedTime = (endTime - startTime) / 1000000.0;
            System.out.println(elapsedTime);
            timeSum2 += elapsedTime;
        }

        double avg1 = timeSum1 / 1000.0;
        double avg2 = timeSum2 / 1000.0;
        System.out.println(avg1 + "\n" + avg2);
        bw.flush();


    }
}
