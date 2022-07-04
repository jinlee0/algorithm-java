package c27_twoPointer.p4_1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int res = solution(N);
        System.out.println(res);
    }

    private static int solution(int N) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        int[] primes = getPrimes(N);
        while (true) {
            if(end == primes.length) {
                break;
            }
            sum += primes[end];
            if(sum == N)cnt++;
            if (sum >= N) {
                sum -= primes[start++];
                sum -= primes[end];
            } else {
                end++;
            }
        }
        return cnt;
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
