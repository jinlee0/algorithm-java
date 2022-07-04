package c08_basicMath2.p1_1978;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line1 = br.readLine();
        String line2 = br.readLine();
        br.close();

        int N = Integer.parseInt(line1);
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(line2);
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
        int res = getNumberOfPrimes(arr);
        bw.write(Integer.toString(res));
        bw.flush();
    }

    public static int getNumberOfPrimes(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(isPrime(arr[i])) cnt++;
        }
        return cnt;
    }

    private static boolean isPrime(int n) {
        if(n<2) return false;
        for (int i = 2; i < n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
