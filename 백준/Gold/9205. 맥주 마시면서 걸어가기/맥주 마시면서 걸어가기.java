import java.util.*;
import java.io.*;

// 9205 : 맥주 마시면서 걸어가기

/**
 * Example
 * 2
 * 2
 * 0 0
 * 1000 0
 * 1000 1000
 * 2000 1000
 * 2
 * 0 0
 * 1000 0
 * 2000 1000
 * 2000 2000
 */
public class Main {
    public static int N;
    public static boolean[] visited;
    public static List<List<Integer>> graph;
    public static int calculateDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
    public static boolean dfs(int index) { // 0 = start, N - 1 == destination
        if (N - 1 == index) {
            return true;
        }

        if (visited[index]) {
            return false;
        }

        visited[index] = true;

        for (Integer next : graph.get(index)) {
            if (dfs(next)) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9205_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine()) + 2;
            visited = new boolean[N];
            graph = new ArrayList<>();
            int[][] position = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                position[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }

            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (calculateDistance(position[i], position[j]) <= 1000) {
                        graph.get(i).add(j);
                    }
                }
            }

            if (dfs(0)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }
}