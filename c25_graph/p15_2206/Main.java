package c25_graph.p15_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] dNodes = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        int res = bfs();
        System.out.println(res);

    }

    private static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, true));
        visited[0][0][0] = true;
        visited[1][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if(cur.r == N - 1 && cur.c == M - 1) return cur.cnt;
            for (int[] dNode : dNodes) {
                int r = cur.r + dNode[0];
                int c = cur.c + dNode[1];
                if(r < 0 || r >= N || c < 0 || c >= M) continue;
                if (map[r][c] == 0) {
                    if (cur.destroyable && !visited[0][r][c]) {
                        queue.add(new Node(r, c, cur.cnt+1, true));
                        visited[0][r][c] = true;
                    } else if (!cur.destroyable && !visited[1][r][c]) {
                        queue.add(new Node(r, c, cur.cnt+1,false));
                        visited[1][r][c] = true;
                    }
                } else {
                    if (cur.destroyable) {
                        queue.add(new Node(r, c, cur.cnt+1,false));
                        visited[1][r][c] = true;
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int r, c;
        int cnt;
        boolean destroyable;

        public Node(int r, int c, int cnt, boolean destroyable) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.destroyable = destroyable;
        }
    }
}
