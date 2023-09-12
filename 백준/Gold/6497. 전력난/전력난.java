import java.util.*;
import java.io.*;

// 6497 : 전력난

/**
 * Example
 * 7 11
 * 0 1 7
 * 0 3 5
 * 1 2 8
 * 1 3 9
 * 1 4 7
 * 2 4 5
 * 3 4 15
 * 3 5 6
 * 4 5 8
 * 4 6 9
 * 5 6 11
 * 0 0
 */
public class Main {
    public static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_6497_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (N == 0 && K == 0) {
                break;
            }

            parent = new int[N];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            List<int[]> edges = new ArrayList<>();
            long totalCost = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                
                totalCost += c;
                edges.add(new int[] {a, b, c});
            }

            Collections.sort(edges, (o1, o2) -> o1[2] - o2[2]);
            long ans = 0;

            for (int[] next : edges) {
                int a = find(next[0]);
                int b = find(next[1]);

                if (a != b) {
                    ans += next[2];
                    union(a, b);
                }
            }

            sb.append(totalCost - ans).append("\n");
        }

        System.out.println(sb);
    }
}