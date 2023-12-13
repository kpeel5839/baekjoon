import java.util.*;
import java.io.*;

// 4883 : 삼각그래프

/**
 * Example
 * 4
 * 13 7 5
 * 7 13 6
 * 14 3 12
 * 15 6 16
 * 0
 */
public class Main {
    public static int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_4883_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dx = {-1, 0, 1, -1};
        int[] dy = {-1, -1, -1, 0};

        int N = -1;
        int index = 0;
        StringBuilder ans = new StringBuilder();
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int[][] graph = new int[N][3];
            int[][] dp = new int[N][3];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(dp[i], INF);
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = graph[0][1];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int dir = 0; dir < 4; dir++) {
                        int ny = i + dy[dir];
                        int nx = j + dx[dir];

                        if (ny < 0 || nx < 0 || nx >= 3) {
                            continue;
                        }

                        dp[i][j] = Math.min(dp[i][j], dp[ny][nx] + graph[i][j]);
                    }
                }
            }

            ans.append(++index)
                    .append(". ")
                    .append(dp[N - 1][1])
                    .append("\n");
        }

        System.out.println(ans);
    }
}