package c07_basicMath1.p2_2292;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int res = solution(N);
        bw.write(Integer.toString(res));
        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(int N) {
        int sum = 1;
        int cnt = 1;
        while (sum < N) {
            sum += cnt * 6;
            cnt++;
        }
        return cnt;

    }

}
