package c25_graph.p16_1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<List<Integer>> adjList = new ArrayList<>();
            for (int j = 0; j < V; j++) adjList.add(new ArrayList<>());
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
            boolean[][] visited = new boolean[V][2];
            String res = "YES";
            for (int j = 0; j < V; j++) {
                if (!visited[j][0]) {
                    if(!bfs(visited, adjList, j)) {
                        res = "NO"; break;
                    }
                }
            }
            sb.append(res).append(System.lineSeparator());
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean bfs(boolean[][] visited, List<List<Integer>> adjList, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start][0] = true;
        visited[start][1] = true;
        while (!queue.isEmpty()) {
            Integer cur = queue.remove();
            for (Integer next : adjList.get(cur)) {
                if (!visited[next][0]) {
                    visited[next][0] = true;
                    visited[next][1] = !visited[cur][1];
                    queue.add(next);
                } else {
                    if(visited[cur][1] == visited[next][1]) return false;
                }
            }
        }
        return true;
    }

}
