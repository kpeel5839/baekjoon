import java.util.*;
import java.io.*;

// 1068 : 트리

/**
 * Example
 * 5
 * -1 0 0 1 1
 * 2
 */
public class Main {
    public static int N;
    public static int ban;
    public static int ans = 0;
    public static List<List<Integer>> tree = new ArrayList<>();
    public static void dfs(int parent, int now) {
        if (now == ban) {
            return;
        }

        int count = 0;

        for (Integer next : tree.get(now)) {
            if (parent != next && ban != next) {
                count++;
                dfs(now, next);
            }
        }

        if (count == 0) {
            ans++;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1068_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        int[] entry = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (a != -1) {
                tree.get(a).add(i);
                entry[i]++;
            }
        }

        ban = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if (entry[i] == 0 && i != ban) {
                dfs(-1, i);
            }
        }
        System.out.println(ans);
    }
}