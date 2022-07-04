package c08_basicMath2.p1_1978;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line1 = br.readLine();
        String line2 = br.readLine();
        br.close();

        int N = Integer.parseInt(line1);
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line2);
        while(st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));

        int res = getNumberOfPrimes(list);
        bw.write(Integer.toString(res));
        bw.flush();
    }

    public static int getNumberOfPrimes(List<Integer> list) {
        Collections.sort(list);
        List<Integer> primes = getPrimes(list.get(list.size() - 1));
        int cnt = 0;
        for(Integer e : list) if(primes.contains(e)) cnt++;
        return cnt;
    }

    private static boolean isPrime(int n) {
        if(n<2) return false;
        for (int i = 2; i < n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }

    private static List<Integer> getPrimes(int rangeEnd) {
        boolean[] arr = new boolean[rangeEnd + 1]; // false: prime
        for (int i = 2; i * i < rangeEnd + 1; i++) {
            for (int j = i * i; j < rangeEnd + 1; j += i) {
                if(!arr[j]){
                    arr[j] = true;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i=2; i<arr.length; i++) if(!arr[i]) primes.add(i);
        return primes;
    }
}
