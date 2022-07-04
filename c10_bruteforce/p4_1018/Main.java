package c10_bruteforce.p4_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NMLine = br.readLine();
        String[] NM = NMLine.split(" ");
        final int N = Integer.parseInt(NM[0]);
        final int M = Integer.parseInt(NM[1]);
        final char[][] oBoard = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                oBoard[i][j] = line.charAt(j);
            }
        }

        int min = 64;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int changedCount = getChangedCount(oBoard, i, j);
                min = Math.min(min, changedCount);
            }
        }

        System.out.println(min);
    }

    private static int getChangedCount(final char[][] arr, final int r, final int c) {
        int cw = 0; // changed count when starts with w
        int cb = 0; //              ''           with b
        final char[] wb = {'W', 'B'};
        int wIdx = 0; // idx of wb when starts with w
        int bIdx = 1; //            ''              b

        for (int i = r; i < r + 8; i++) {
            for (int j = c; j < c + 8; j++) {
                if (arr[i][j] != wb[wIdx]) cw++;
                if (arr[i][j] != wb[bIdx]) cb++;
                wIdx = (wIdx + 1) % 2;
                bIdx = (bIdx + 1) % 2;
            }
            wIdx = (wIdx + 1) % 2;
            bIdx = (bIdx + 1) % 2;
        }
        return Math.min(cw, cb);
    }
}
