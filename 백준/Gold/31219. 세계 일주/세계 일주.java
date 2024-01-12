import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// E : 세계 일주

/**
 * Example
 * 4
 * 0 1
 * 0 -1
 * 2 0
 * -2 0
 */
public class Main {

    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long angle = ((x1 * y2) + (x2 * y3) + (x3 * y1)) - ((y1 * x2) + (y2 * x3) + (y3 * x1));

        return (int) (angle < 0 ? -1 : (angle > 0 ? 1 : angle));
    }

    public static boolean isCross(
            int[] p1,
            int[] p2,
            int[] p3,
            int[] p4
    ) {
        int p123 = ccw(p1[1], p1[0], p2[1], p2[0], p3[1], p3[0]);
        int p124 = ccw(p1[1], p1[0], p2[1], p2[0], p4[1], p4[0]);
        int p341 = ccw(p3[1], p3[0], p4[1], p4[0], p1[1], p1[0]);
        int p342 = ccw(p3[1], p3[0], p4[1], p4[0], p2[1], p2[0]);

        boolean compare1 = Math.min(p1[1], p2[1]) < Math.max(p3[1], p4[1]);
        boolean compare2 = Math.min(p3[1], p4[1]) < Math.max(p1[1], p2[1]);
        boolean compare3 = Math.min(p1[0], p2[0]) < Math.max(p3[0], p4[0]);
        boolean compare4 = Math.min(p3[0], p4[0]) < Math.max(p1[0], p2[0]);

        if ((p123 == 0 && p124 == 0) && (p341 == 0 && p342 == 0)) {
            if((compare1 && compare2) && (compare3 && compare4)) {
                return true;
            }
        } else if (((p123 * p124) < 0) && ((p341 * p342) < 0)) {
            return true;
        }

        return false;
    }

    public static boolean isCrossLines(int start, int end, List<int[]> edges) {
        for (int[] p : edges) {
            boolean result = isCross(points[start], points[end], points[p[0]], points[p[1]]);

            if (result) {
                return true;
            }
        }

        return false;
    }

    public static int n;
    public static boolean[] visited;
    public static int[][] points;
    public static double answer = Double.MAX_VALUE;

    public static void dfs(int nowIndex, int first, int count, List<int[]> edges, double value) {
        if (count == n) {
            if (isCrossLines(nowIndex, first, edges)) {
                return;
            }

            double diffY = points[nowIndex][0] - points[first][0];
            double diffX = points[nowIndex][1] - points[first][1];
            value += Math.sqrt(diffY * diffY + diffX * diffX);
            answer = Math.min(answer, value);
        }

        for (int i = 0; i < n; i++) {
            if (nowIndex == i || visited[i]) {
                continue;
            }

            if (isCrossLines(nowIndex, i, edges)) {
                continue;
            }

            visited[i] = true;
            double diffY = points[nowIndex][0] - points[i][0];
            double diffX = points[nowIndex][1] - points[i][1];
            List<int[]> newEdge = new ArrayList<>(edges);
            newEdge.add(new int[] {nowIndex, i});
            dfs(i, first, count + 1, newEdge, value + Math.sqrt(diffY * diffY + diffX * diffX));
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_2024_1_7_boj_contest/_E_2024_1_7/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        points = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 1, new ArrayList<>(), 0);
            visited[i] = false;
        }

        System.out.println(answer == Double.MAX_VALUE ? -1 : answer);
    }
}