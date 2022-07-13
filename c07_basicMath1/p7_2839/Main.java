package c07_basicMath1.p7_2839;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int res = getNumberOfBags(N);
        bw.write(Integer.toString(res));
        bw.close();
        br.close();
    }

    private static int getNumberOfBags(int N) {
        int r5 = N % 5;
        if(N==4 || N==7) return -1;
        else if (r5 == 0) return N / 5;
        else if (r5 == 1 || r5 == 3) return N / 5 + 1;
        else return N / 5 + 2;
    }
}
