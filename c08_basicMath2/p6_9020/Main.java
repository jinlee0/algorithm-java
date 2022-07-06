package c08_basicMath2.p6_9020;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] partition = getGoldbach(Integer.parseInt(br.readLine()));
            sb.append(partition[0]).append(" ").append(partition[1]).append(System.lineSeparator());
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] getGoldbach(int n) {
        int[] primes = getPrimes(n);
        int start = 0;
        int end = primes.length - 1;
        int[] partition = new int[2];
        while (start <= end) {
            int sum = primes[start] + primes[end];
            if(sum < n) start++;
            else if (sum > n) end--;
            else {
                partition[0] = primes[start];
                partition[1] = primes[end];
                start++; end--;
            }
        }
        return partition;
    }

    private static int[] getPrimes(int N) {
        boolean[] arr = new boolean[N + 1];
        int primeSize = arr.length - 2;
        for (int i = 2; i * i < N + 1; i++) {
            if(!arr[i])
                for (int j = i * i; j < N + 1; j += i) {
                    if(!arr[j]){
                        arr[j] = true;
                        primeSize--;
                    }
                }
        }
        int[] primes = new int[primeSize];
        int idx = 0;
        for(int i=2; i<arr.length; i++) if(!arr[i]) primes[idx++] = i;
        return primes;
    }
}
