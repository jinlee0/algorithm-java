package c08_basicMath2.p2_2581;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] res = solution(M, N);
        if(res == null) bw.write(Integer.toString(-1));
        else bw.write(res[0] + System.lineSeparator() + res[1]);
        bw.flush();
    }

    private static int[] solution(int M, int N) {
        List<Integer> primes = getPrimes(M, N);
        if(primes.size() < 1) return null;
        Integer sum = primes.stream().reduce(0, (a, b) -> a + b);
        int min = primes.get(0);
        return new int[]{sum, min};
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
