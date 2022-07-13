package c16_dp1.p2_9184;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][][] W = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if(line.equals("-1 -1 -1")) break;
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int res = w(a, b, c);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(res).append(System.lineSeparator());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int w(int a, int b, int c) {
        if(a < 1 || b < 1 || c < 1) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20) return W[20][20][20] = w(20, 20, 20);
        if (W[a][b][c] != 0) return W[a][b][c];
        if (a < b && b < c) {
            return W[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return W[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}
