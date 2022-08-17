package c25_graph.p12_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] v;
    static int[][] dNodes = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<Node> startNodes = new ArrayList<>();
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        v = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                v[i][j] = Integer.parseInt(st.nextToken());
                if(v[i][j] == 1) startNodes.add(new Node(i, j));
                else if(v[i][j] == 0) cnt++;
            }
        }
        br.close();

        int max = bfs();
        System.out.println(max);
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
                Node next = new Node(cur.row + dNode[0], cur.col + dNode[1]);
                if (next.row >= 0 && next.row < N && next.col >= 0 && next.col < M && v[next.row][next.col] == 0) {
                    v[next.row][next.col] = v[cur.row][cur.col] + 1;
                    max = Math.max(v[next.row][next.col], max);
                    queue.add(next);
                    cnt--;
                }
            }
        }
        return cnt == 0 ? max - 1 : -1;
    }

    static class Node {
        int row;
        int col;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
