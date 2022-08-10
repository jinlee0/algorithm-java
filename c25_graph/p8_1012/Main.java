package c25_graph.p8_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static boolean[][] v;
    static int cnt = 0;
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[M][N];
            v = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            cnt = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (!v[j][k] && arr[j][k] == 1) {
                        cnt++;
                        dfs(j, k);
                    }
                }
            }
            sb.append(cnt).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void dfs(int r, int c) {
        v[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int curR = dirX[i] + r;
            int curC = dirY[i] + c;
            if (curR >= 0 && curR < M && curC >= 0 && curC < N && !v[curR][curC] && arr[curR][curC] == 1) {
                dfs(curR, curC);
            }
        }
    }
}
