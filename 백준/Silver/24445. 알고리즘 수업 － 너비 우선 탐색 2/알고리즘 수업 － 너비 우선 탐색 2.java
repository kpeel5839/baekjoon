import java.util.*;
import java.io.*;

// 24445 : 알고리즘 수업 - 너비 우선 탐색 2

/**
 * Example
 * 5 5 1
 * 1 4
 * 1 2
 * 2 3
 * 2 4
 * 3 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_24444_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.get(a).add(b);
            g.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(g.get(i), (o1, o2) -> o2 - o1);
        }

        int[] visited = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        visited[X] = ++count;
        q.add(X);

        while (!q.isEmpty()) {
            int point = q.poll();

            for (Integer next : g.get(point)) {
                if (visited[next] == 0) {
                    visited[next] = ++count;
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}