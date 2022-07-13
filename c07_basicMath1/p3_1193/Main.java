package c07_basicMath1.p3_1193;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        String res = solution(X);
        bw.write(res);
        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int X) {
        int sum = 0;
        int cnt = 0;
        int i = 0;
        while (sum < X) {
            i = sum;
            sum += ++cnt;
        }
        int num1 = X - i;
        int num2 = cnt + 1 - num1;
        return cnt % 2 != 0 ? num2 + "/" + num1 : num1 + "/" + num2;

    }

}
