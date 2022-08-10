package c25_graph.p9_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] v;
    static int cnt = 0;
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = chars[j] - '0';
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!v[i][j] && arr[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                }
            }
        }
        System.out.println(arr[N-1][M-1]);
    }

    private static void dfs(int r, int c) {
        v[r][c] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});

        while (queue.size() > 0) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int curR = point[0] + dirX[i];
                int curC = point[1] + dirY[i];
                if (curR >= 0 && curR < N && curC >= 0 && curC < M && !v[curR][curC] && arr[curR][curC] == 1) {
                    v[curR][curC] = true;
                    queue.add(new int[]{curR, curC});
                    arr[curR][curC] = arr[point[0]][point[1]] + 1;
                }
            }
        }
    }
}
