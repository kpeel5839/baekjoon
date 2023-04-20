import java.util.*;
import java.io.*;

// 10216 : Count Circle Groups

/**
 * Example
 * 2
 * 2
 * 0 0 1
 * 1 0 1
 * 3
 * 0 0 1
 * 2 0 1
 * 10 0 5
 */
public class Main {
    public static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] v;
    public static class Point {
        int y;
        int x;
        int r;

        Point(int y, int x, int r) {
            this.y = y;
            this.x = x;
            this.r = r;
        }
    }

    public static void dfs(int c) {
        if (v[c]) {
            return;
        }

        v[c] = true;

        for (Integer next : graph.get(c)) {
            dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_10216_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            graph = new ArrayList<>();
            v = new boolean[N];
            List<Point> points = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        continue;
                    }

                    Point a = points.get(i);
                    Point b = points.get(j);
                    double d = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));

                    if (d <= a.r + b.r) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                if (!v[i]) {
                    ans++;
                    dfs(i);
                }
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
    }
}