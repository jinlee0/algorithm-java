package c08_basicMath2.p3_11653;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        br.close();

        List<Integer> res = solution(N);
        for (Integer i : res) bw.write(i + System.lineSeparator());
        bw.flush();
    }

    private static List<Integer> solution(int N) {
        int[] primes = getPrimes(N);
        int val = N;
        int idx = 0;
        List<Integer> answer = new ArrayList<>();
        while (val != 1 && idx < primes.length) {
            if (val % primes[idx] == 0) {
                val /= primes[idx];
                answer.add(primes[idx]);
            } else {
                idx++;
            }
        }
        return answer;
    }

    private static int[] getPrimes(int rangeEnd) {
        boolean[] arr = new boolean[rangeEnd + 1]; // false: prime
        int primeSize = arr.length - 2;
        for (int i = 2; i * i < rangeEnd + 1; i++) {
            for (int j = i * i; j < rangeEnd + 1; j += i) {
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
