import java.util.*;
import java.io.*;

// 3182 : 한동이는 공부가 하기 싫어!

/**
 * Example
 * 3
 * 3
 * 3
 * 1
 */
public class Main {
    public static int N;
    public static int[] point;

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(start);
        visited[start] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int p = q.poll();
            cnt++;

            if (!visited[point[p]]) {
                visited[point[p]] = true;
                q.add(point[p]);
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_3182_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        point = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        int[] ans = new int[N + 1];
        int max = -1;
        for (int i = 1; i <= N; i++) {
            ans[i] = bfs(i);
            max = Math.max(max, ans[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (max == ans[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}