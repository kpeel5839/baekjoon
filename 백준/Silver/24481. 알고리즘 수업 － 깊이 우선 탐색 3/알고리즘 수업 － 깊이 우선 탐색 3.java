import java.util.*;
import java.io.*;

// 24481 : 알고리즘 수업 - 깊이 우선 탐색 3

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
    public static int[] visited;
    public static List<List<Integer>> list = new ArrayList<>();
    public static void dfs(int index, int depth) {
        if (visited[index] != -1) {
            return;
        }

        visited[index] = depth;

        for (Integer next : list.get(index)) {
            dfs(next, depth + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_24481_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (List<Integer> innerList : list) {
            Collections.sort(innerList);
        }

        dfs(R, 0);

        for (int i = 1; i <= N; i++) {
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}