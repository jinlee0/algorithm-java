package c09_recursion.p5_11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        Hanoi hanoi = new Hanoi(N, 1, 3, 2);
        StringBuilder sb = new StringBuilder();
        sb.append(hanoi.cnt).append(System.lineSeparator());
        hanoi.moves.forEach(m -> sb.append(m[0]).append(" ").append(m[1]).append(System.lineSeparator()));
        System.out.println(sb);
    }

    static class Hanoi {
        int cnt;
        ArrayList<int[]> moves;

        Hanoi(int N, int from, int to, int via) {
            moves = new ArrayList<>();
            hanoi(N, from, to, via, 0);
        }

        private void hanoi(int N, int from, int to, int via, int cnt) {
            if(N==1) {
                move(1, from, to);
            }
            else {
                hanoi(N-1, from, via, to, cnt);
                move(N, from, to);
                hanoi(N-1, via, to, from, cnt);
            }
        }

        private void move(int N, int from, int to) {
            moves.add(new int[]{from, to});
            cnt++;
        }
    }
}
