package c09_recursion.p1_10872;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = factorial(N);
        System.out.println(res);
    }

    private static int factorial(int n) {
        if(n<2) return 1;
        return n * factorial(n - 1);
    }
}
