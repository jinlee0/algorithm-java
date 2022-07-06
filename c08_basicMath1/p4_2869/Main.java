package c08_basicMath1.p4_2869;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] inputs = line.split(" ");
        int A = Integer.parseInt(inputs[0]);
        int B = Integer.parseInt(inputs[1]);
        int V = Integer.parseInt(inputs[2]);

        int res = solution(A, B, V);
        bw.write(Integer.toString(res));
        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(int A, int B, int V) {
        return (int)Math.ceil((double)(V - B) / (A - B));
    }
}
