package c34_backTracking.p1_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        int[] result = new int[M];
        StringBuilder sb = new StringBuilder();
        solution(visited, 0, N, M, result, sb);
        System.out.println(sb);
    }

    private static void solution(boolean[] visited, int depth, int N, int M, int[] result, StringBuilder sb) {
        if (depth == M) {
            for (int i = 0; i < result.length; i++) sb.append(result[i]).append(' ');
            sb.append(System.lineSeparator());
            return;
        }
        for(int i=1; i<=N; i++)
            if(!visited[i]){
                visited[i] = true;
                result[depth] = i;
                solution(visited, depth + 1, N, M, result, sb);
                visited[i] = false;
            }
    }
}
