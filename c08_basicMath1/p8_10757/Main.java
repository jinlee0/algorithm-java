package c08_basicMath1.p8_10757;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        String res = sumBigNum(A, B);
        bw.write(res);
        bw.close();
        br.close();
    }

    private static String sumBigNum(String A, String B) {
        int bufLen = Math.max(A.length(), B.length());
        A = "\0".repeat(bufLen - A.length()) + A;
        B = "\0".repeat(bufLen - B.length()) + B;
        StringBuilder sb = new StringBuilder();
        int end = bufLen - 1;
        int up = 0;
        while (end >= 0) {
            int aN = A.charAt(end) != '\0' ? A.charAt(end) - '0' : 0;
            int bN = B.charAt(end) != '\0' ? B.charAt(end) - '0' : 0;
            int sum = aN + bN + up;
            if (sum > 9) {
                up = 1;
                sum -= 10;
            } else {
                up = 0;
            }
            sb.append((char)(sum + (int)'0'));
            end--;
        }
        if(up==1) sb.append(1);
        return sb.reverse().toString();
    }
}
