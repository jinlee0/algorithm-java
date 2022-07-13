package c07_basicMath1.p5_10250;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[T][3];
        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 0; j < 3; j++) arr[i][j] = Integer.parseInt(st.nextToken());
            String res = getRoomNumber(arr[i]);
            StringBuilder sb = new StringBuilder();
            sb.append(res).append(System.lineSeparator());
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static String getRoomNumber(int[] arr) {
        int H = arr[0];
        int N = arr[2];
        int floor = (N - 1) % H + 1;
        int room = (N - 1) / H + 1;
        StringBuilder sb = new StringBuilder();
        sb.append(floor);
        if(room < 10) sb.append(0);
        sb.append(room);
        return sb.toString();
    }
}
