import java.util.*;
import java.io.*;

// 21937 : 작업

/**
 * Example
 * 6 4
 * 1 6
 * 2 4
 * 4 6
 * 4 5
 * 5
 */
public class Main {
    public static List<List<Integer>> list = new ArrayList<>();
    public static boolean[] visited;
    public static int N;
    public static int count;

    public static void dfs(int index) {
        count++;
        for (Integer next : list.get(index)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_21937_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }

        int X = Integer.parseInt(br.readLine());
        dfs(X);

        System.out.println(count - 1);
    }
}