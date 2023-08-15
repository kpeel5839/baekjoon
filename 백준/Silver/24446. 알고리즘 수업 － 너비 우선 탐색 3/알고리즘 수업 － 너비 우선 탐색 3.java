import java.util.*;
import java.io.*;

// 24446 : 알고리즘 수업 - 너비 우선 탐색 3

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
        //System.setIn(new FileInputStream(
        //        "/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_24446_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        int[] depth = new int[N + 1];
        Arrays.fill(depth, -1);
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {R, 0});
        depth[R] = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (Integer next : list.get(p[0])) {
                if (depth[next] == -1) {
                    depth[next] = p[1] + 1;
                    q.add(new int[] {next, depth[next]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(depth[i]).append("\n");
        }

        System.out.println(sb);
    }
}