package c09_recursion.p4_2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] res = new char[N][N];
        res = solution(res, N, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) sb.append(res[i][j]);
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
        br.close();
    }

    private static char[][] solution(char[][] arr, int N, int r, int c) {
        if (N == 1) {
            arr[r][c] = '*';
        } else {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    int nextR = r + i * N / 3;
                    int nextC = c + j * N / 3;
                    if (i != 1 || j != 1) {
                        solution(arr, N / 3, nextR, nextC);
                    } else { // set blank block
                        for (int a = nextR; a < nextR + N / 3; a++) {
                            for (int b = nextC; b < nextC + N / 3; b++) {
                                arr[a][b] = ' ';
                            }
                        }
                    }
                }
        }
        return arr;
    }
}
