import java.util.*;
import java.io.*;

// 17352 : 여러분의 다리가 되어 드리겠습니다.

/**
 * Example
 * 4
 * 1 2
 * 1 3
 */
public class Main {

    public static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17352_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> m = new HashMap<>();
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a = find(a);
            b = find(b);

            if (a != b) {
                union(a, b);
            }
        }

        for (int i = 1; i <= N; i++) {
            int p = find(i);

            m.put(p, i);
        }

        List<Integer> ans = new ArrayList<>(m.values());
        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}
