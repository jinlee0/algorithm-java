package c25_graph.p13_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] v;
    static int[][] dNodes = {
            {1, 0, 0}, {-1, 0, 0},
            {0, 1, 0}, {0, -1, 0},
            {0, 0, 1}, {0, 0, -1},
    };
    static List<Node> startNodes = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        v = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    v[i][j][k] = Integer.parseInt(st.nextToken());
                    if(v[i][j][k] == 1) startNodes.add(new Node(i, j, k));
                    if(v[i][j][k] == 0) cnt++;
                }
            }
        }

        int res = bfs();
        System.out.println(res);
    }

    private static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        for (Node startNode : startNodes) {
            queue.add(startNode);
        }
        int max = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            for (int[] dNode : dNodes) {
                Node next = new Node(cur.h + dNode[0], cur.r + dNode[1], cur.c + dNode[2]);
                if (next.isInRange() && v[next.h][next.r][next.c] == 0) {
                    int val = v[next.h][next.r][next.c] = v[cur.h][cur.r][cur.c] + 1;
                    max = Math.max(val, max);
                    queue.add(next);
                    cnt--;
                }
            }
        }
        return cnt == 0 ? max - 1 : -1;
    }

    static class Node {
        int h;
        int r;
        int c;
        Node(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }

        public boolean isInRange() {
            return h >= 0 && h < H &&
                    r >= 0 && r < N &&
                    c >= 0 && c < M;
        }
    }
}
