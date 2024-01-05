import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 20303 : 할로윈 양아치

/**
 * Example
 * 10 6 6
 * 9 15 4 4 1 5 19 14 20 5
 * 1 3
 * 2 5
 * 4 9
 * 6 2
 * 7 8
 * 6 10
 */
public class Main {

    public static int n;
    public static int m;
    public static int k;
    public static int[] parent;
    public static int[] value;
    public static List<Map.Entry<Integer, Integer>> list;
    public static int[][] dp;

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        value[a] += value[b];
        parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_20303_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        value = new int[n + 1];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = find(Integer.parseInt(st.nextToken()));
            int b = find(Integer.parseInt(st.nextToken()));

            if (a != b) {
                union(a, b);
            }
        }

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            m.put(find(i), m.getOrDefault(find(i), 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            list.add(entry);
        }

        dp = new int[list.size()][k];

        for (int i = 0; i < list.size(); i++) {
            Integer key = list.get(i).getKey();
            Integer value1 = list.get(i).getValue();
            for (int j = 0; j < k; j++) {
                if (value1 <= j) {
                    dp[i][j] = value[key] + ((i == 0) ? 0 : dp[i - 1][j - value1]);
                }

                dp[i][j] = Math.max(dp[i][j], Math.max(i == 0 ? 0 : dp[i - 1][j], j == 0 ? 0 : dp[i][j - 1]));
            }
        }

        System.out.println(dp[list.size() - 1][k - 1]);
    }

}