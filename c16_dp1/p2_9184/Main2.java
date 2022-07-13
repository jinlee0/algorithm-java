package c16_dp1.p2_9184;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    static int[][][] W = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        setW();
        while (true) {
            String line = br.readLine();
            if(line.equals("-1 -1 -1")) break;
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int res = getW(a, b, c);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(res).append(System.lineSeparator());
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void setW() {
        for (int i = 0; i <= 20; i++)
            for (int j = 0; j <= 20; j++)
                W[0][i][j] = W[i][0][j] = W[i][j][0] = 1;
        for (int a = 1; a <= 20; a++)
            for (int b = 1; b <= 20; b++)
                for (int c = 1; c <= 20; c++)
                    if (a < b && b < c) W[a][b][c] = W[a][b][c-1] + W[a][b-1][c-1] - W[a][b-1][c];
                    else W[a][b][c] = W[a-1][b][c] + W[a-1][b-1][c] + W[a-1][b][c-1] - W[a-1][b-1][c-1];
    }

    private static int getW(int a, int b, int c) {
        if(a < 1 || b < 1 || c < 1) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20) return W[20][20][20];
        return W[a][b][c];
    }
}
