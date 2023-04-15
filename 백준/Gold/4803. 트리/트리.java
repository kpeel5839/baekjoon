import java.util.*;
import java.io.*;

// 4803 : 트리

/**
 * Example
 * 6 3
 * 1 2
 * 2 3
 * 3 4
 * 6 5
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 5 6
 * 6 6
 * 1 2
 * 2 3
 * 1 3
 * 4 5
 * 5 6
 * 6 4
 * 0 0
 */
public class Main {

    public static List<ArrayList<Integer>> g;
    public static boolean[] v;
    public static boolean isTree;

    public static void dfs(int p, int c) {
        if (v[c]) {
            isTree = false;
            return;
        }

        v[c] = true;

        for (Integer next : g.get(c)) {
            if (next != p) {
                dfs(c, next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_4803_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int index = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            g = new ArrayList<>();
            v = new boolean[N + 1];

            for (int i = 0; i <= N; i++) {
                g.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int index1 = Integer.parseInt(st.nextToken());
                int index2 = Integer.parseInt(st.nextToken());
                g.get(index1).add(index2);
                g.get(index2).add(index1);
            }

            int count = 0;
            for (int i = 1; i <= N; i++) {
                isTree = true;

                if (!v[i]) {
                    dfs(-1, i);

                    if (isTree) {
                        count++;
                    }
                }
            }

            if (count == 0) {
                bw.write("Case " + index + ": No trees.\n");
            } else if (count == 1) {
                bw.write("Case " + index + ": There is one tree.\n");
            } else {
                bw.write("Case " + index + ": A forest of " + count + " trees.\n");
            }

            index++;
        }

        bw.flush();
        bw.close();
    }
}
