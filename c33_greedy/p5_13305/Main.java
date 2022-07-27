package c33_greedy.p5_13305;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] distances = new long[N - 1];
        long[] prices = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distances.length; i++) distances[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long prev = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            long curr = Long.parseLong(st.nextToken());
            prices[i] = prev = curr < prev ? curr : prev;
        }

        long sum = 0;
        for(int i=0; i<distances.length; i++) sum += prices[i] * distances[i];
        bw.write(Long.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
