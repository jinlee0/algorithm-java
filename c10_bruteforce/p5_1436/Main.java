package c10_bruteforce.p5_1436;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        int n=0;
        while (true) {
            String s = Integer.toString(n);
            if (s.contains("666")) {
                cnt++;
                if (cnt == N) {
                    break;
                }
            }
            n++;
        }

        System.out.println(n);
    }

}
