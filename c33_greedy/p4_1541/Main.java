package c33_greedy.p4_1541;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = (br.readLine() + "+").toCharArray();

        String readingVal = "";
        char parentOp = '+';
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='0' && readingVal.isEmpty()) continue;
            else if (arr[i] >= '0' && arr[i] <= '9') {
                readingVal += arr[i];
            }
            else {
                int value = Integer.parseInt(readingVal);
                if (parentOp == '-') {
                    sum -= value;
                } else {
                    sum += value;
                }
                if(arr[i] == '-') parentOp = '-';
                readingVal = "";
            }
        }

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
