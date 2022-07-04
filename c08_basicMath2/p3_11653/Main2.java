package c08_basicMath2.p3_11653;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
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
        int num = 2;
        int value = N;
        List<Integer> answer = new ArrayList<>();
        while (value != 1) {
            if (value % num == 0) {
                value /= num;
                answer.add(num);
                if(num * num >= N) break;
            } else {
                num++;
            }
        }
        return answer;
    }

}
