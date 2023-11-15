import java.util.*;
import java.io.*;

// 1890 : 점프

/**
 * Example
 * 4
 * 2 3 3 1
 * 1 2 1 3
 * 1 2 3 1
 * 3 1 1 0
 */
public class Main {

    public static int N;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1890_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N][N];
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int ny = i + arr[i][j];
                int nx = j + arr[i][j];

                if (arr[i][j] == 0) {
                    continue;
                }

                if (ny < N) {
                    dp[ny][j] = dp[ny][j] + dp[i][j];
                }

                if (nx < N) {
                    dp[i][nx] = dp[i][nx] + dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

}