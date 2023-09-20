import java.util.*;
import java.io.*;

// 14567 : 선수과목 (prerequisite)

/**
 * 예제
 * 3 2
 * 2 3
 * 1 2
 */
public class Main {
    static int V;
    static int E;
    static int[] entry;
    static int[] dp;
    static List<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_14567_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        entry = new int[V + 1];
        dp = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            entry[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= V; i++) {
            if (entry[i] == 0) {
                queue.add(i);
                dp[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (Integer next : graph.get(v)) {
                entry[next]--;
                dp[next] = Math.max(dp[next], dp[v] + 1);

                if (entry[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            bw.write(dp[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
