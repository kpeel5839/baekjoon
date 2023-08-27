import java.util.*;
import java.io.*;

// 16568 : 엔비스카의 영혼

/**
 * Example
 * 5 1 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16568_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {1, 0, 0};

        int N = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        dx[1] = Integer.parseInt(st.nextToken()) + 1;
        dx[2] = Integer.parseInt(st.nextToken()) + 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == N) {
                System.out.println(p[1]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int newValue = p[0] + dx[i];

                if (newValue < 0 || newValue > N || visited[newValue]) {
                    continue;
                }

                q.add(new int[] {newValue, p[1] + 1});
                visited[newValue] = true;
            }
        }
    }
}