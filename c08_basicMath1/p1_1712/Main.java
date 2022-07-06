package c08_basicMath1.p1_1712;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int res = solution(A, B, C);
        bw.write(Integer.toString(res));
        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(int A, int B, int C) {
        if(B >= C) return -1;
        return A/(C-B) + 1;

    }

}

