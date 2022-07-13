package c16_dp1.p1_24416;

import java.io.*;

public class Main {
    static int[] f;
    static int cntRec = 0;
    static int cntDp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        f = new int[n + 1];
        fib(n);
        fibonacci(n);
        bw.write(cntRec + 1 + " " + cntDp);
        bw.flush();
        br.close();
        bw.close();
    }

    private static int fib(int n) {
        if(n==1 || n==2) return 1;
        else {
            cntRec++;
            return fib(n - 1) + fib(n - 2);
        }
    }

    private static void fibonacci(int n) {
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            cntDp++;
            f[i] = f[i-1] + f[i-2];
        }
    }
}
