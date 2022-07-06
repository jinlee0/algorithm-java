package c08_basicMath1.p6_2775;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int res = getResidentNum(k, n);
            bw.write(res + System.lineSeparator());
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getResidentNum(int k, int n) {
        int sum = 0;
        if(k==0) return n;
        for (int i = 1; i <= n; i++) sum += getResidentNum(k - 1, i);
        return sum;
    }

}
