import java.util.*;
import java.io.*;

// 1058 : 친구

/**
 * Example
 * 3
 * NYY
 * YNY
 * YYN
 */
public class Main {

    public static char[][] m;
    public static boolean[] visited;
    public static int N;

    public static int bfs(int c) {
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;
        visited = new boolean[N];
        q.add(new int[]{c, 0});
        visited[c] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (3 <= point[1]) {
                continue;
            }

            ans++;

            for (int i = 0; i < N; i++) {
                if (m[point[0]][i] == 'Y' && !visited[i]) {
                    q.add(new int[]{i, point[1] + 1});
                    visited[i] = true;
                }
            }
        }

        return ans - 1;
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream(
               // "/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1058_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        m = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                m[i][j] = s.charAt(j);
            }
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            bfs(i);
            ans = Math.max(ans, bfs(i));
        }

        System.out.println(ans);
    }
}