package c25_graph.p7_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] v;
    static int cnt = 0;
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = chars[j] - '0';
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!v[i][j] && arr[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append(System.lineSeparator());
        for(int i : list) sb.append(i).append(System.lineSeparator());
        System.out.println(sb);
    }

    private static void dfs(int r, int c) {
        v[r][c] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int curR = dirX[i] + r;
            int curC = dirY[i] + c;
            if (curR >= 0 && curR < N && curC >= 0 && curC < N && !v[curR][curC] && arr[curR][curC] == 1) {
                dfs(curR, curC);
            }
        }
    }
}
