package c1_bruteforce.p1_2798;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = sc.nextInt();
        int res = getRes(n, m, nums);
        System.out.println(res);
        sc.close();
    }

    private static int getRes(int n, int m, int[] nums) {
        int res = 0;
        for (int i = 0; i < n -2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == m)
                        return sum;
                    if (sum > res && sum < m)
                        res = sum;
                }
            }
        }
        return res;
    }

}
