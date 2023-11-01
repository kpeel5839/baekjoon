import java.util.*;
import java.io.*;

// 15486 : 퇴사 2

/**
 * Example
 * 7
 * 3 10
 * 5 20
 * 1 10
 * 1 20
 * 2 15
 * 4 40
 * 2 200
 */
public class Main {

    public static int N;
    public static int[][] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15486_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        arr = new int[2][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = Math.max(dp[i], i == 0 ? 0 : dp[i - 1]);

            if (i + arr[0][i] <= N) {
                dp[i + arr[0][i]] = Math.max(dp[i + arr[0][i]], dp[i] + arr[1][i]);
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.println(Math.max(ans, dp[N]));
    }
}