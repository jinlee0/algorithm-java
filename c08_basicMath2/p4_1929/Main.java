package c08_basicMath2.p4_1929;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] MN = br.readLine().split(" ");
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);

        List<Integer> primes = getPrimes(M, N);
        for (Integer p : primes) bw.write(p + System.lineSeparator());
        bw.flush();

        br.close();
        bw.close();
    }

    private static List<Integer> getPrimes(int M, int N) {
        boolean[] arr = new boolean[N + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i * i < N + 1; i++)
            if(!arr[i])
                for (int j = i * i; j < N + 1; j += i)
                    arr[j] = true;
        for(int i=Math.max(M, 2); i<arr.length; i++) if(!arr[i]) primes.add(i);
        return primes;
    }
}
