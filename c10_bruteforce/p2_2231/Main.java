package c10_bruteforce.p2_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);

        int min = N - input.length() * 9;
        int res = 0;
        for (int i = min; i < N; i++) {
            int temp = i;
            int sum = i;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum == N) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}
