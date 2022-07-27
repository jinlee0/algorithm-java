package c33_greedy.p4_1541;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer minusTokenizer = new StringTokenizer(line, "-");
        int[] sums = new int[minusTokenizer.countTokens()];
        int total = 0;
        for (int i = 0; i < sums.length; i++) {
            StringTokenizer plusTokenizer = new StringTokenizer(minusTokenizer.nextToken(), "+");
            while(plusTokenizer.hasMoreTokens()) sums[i] += Integer.parseInt(plusTokenizer.nextToken());
            total += sums[i];
        }
        total = (total - sums[0] * 2) * -1;
        bw.write(Integer.toString(total));
        bw.flush();
        bw.close();
        br.close();
    }
}
