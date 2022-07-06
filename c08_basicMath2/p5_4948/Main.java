package c08_basicMath2.p5_4948;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            List<Integer> primes = getPrimes(n + 1, n * 2);
            sb.append(primes.size()).append(System.lineSeparator());
        }
        bw.write(sb.toString());
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
