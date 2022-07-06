package c08_basicMath2;

import java.util.ArrayList;
import java.util.List;

public class GetPrime {
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

    private static int[] getPrimes(int N) {
        boolean[] arr = new boolean[N + 1]; // false: prime
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
