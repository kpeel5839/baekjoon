import java.util.*;
import java.io.*;

// 11060 : 점프 점프

/**
 * Example
 * 10
 * 1 2 0 1 3 2 1 5 4 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11060_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList<>();
        visited[0] = true;
        q.add(new int[] {0, 0});

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[0] == N - 1) {
                System.out.println(point[1]);
                return;
            }

            for (int i = 1; i <= arr[point[0]]; i++) {
                if (point[0] + i < N && !visited[point[0] + i]) {
                    q.add(new int[] {point[0] + i, point[1] + 1});
                    visited[point[0] + i] = true;
                }
            }
        }

        System.out.println(-1);
    }
}