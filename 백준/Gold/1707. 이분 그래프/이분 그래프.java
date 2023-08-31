import java.util.*;
import java.io.*;

// 1707 : 이분 그래프

/**
 * Example
 * 2
 * 3 2
 * 1 3
 * 2 3
 * 4 4
 * 1 2
 * 2 3
 * 3 4
 * 4 2
 */
public class Main {

    public static List<List<Integer>> graph;
    public static int[] visited;

    public static boolean dfs(int group, int index) {
        visited[index] = group;

        for (Integer next : graph.get(index)) {
            if (visited[next] == -1) {
                if (!dfs((group + 1) % 2, next)) {
                    return false;
                }
            } else if (visited[next] == group) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1707_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visited = new int[V + 1];
            graph = new ArrayList<>();

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
                visited[i] = -1;
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean result = true;

            for (int i = 1; i <= V; i++) {
                if (visited[i] == -1) {
                    if (!dfs(0, i)) {
                        result = false;
                        break;
                    }
                }
            }

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
