import java.util.*;
import java.io.*;

// 24482 : 알고리즘 수업 - 깊이 우선 탐색 4

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
    public static List<List<Integer>> list = new ArrayList<>();
    public static int[] depth;
    public static void dfs(int index, int d) {
        for (Integer next : list.get(index)) {
            if (depth[next] == -1) {
                depth[next] = d;
                dfs(next, d + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_24482_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        depth = new int[N + 1];
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

        for (List<Integer> list : list) {
            Collections.sort(list, (o1, o2) -> o2 - o1);
        }

        depth[R] = 0;
        dfs(R, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(depth[i]).append("\n");
        }

        System.out.println(sb);
    }
}