import java.util.*;
import java.io.*;

// 9465 : 스티커

/**
 * Example
 * 2
 * 5
 * 50 10 100 20 40
 * 30 50 70 10 60
 * 7
 * 10 30 10 50 100 20 40
 * 20 40 30 50 60 20 80
 */
public class Main {

    public static int N;
    public static int[][] arr;
    public static int[][] dp;

    public static int dfs(int prev, int index) {
        if (index == N) {
            return 0;
        }
        if (dp[prev][index] != -1) {
            return dp[prev][index];
        }
        for (int i = 0; i <= 1; i++) {
            if (prev == i) {
                continue;
            }

            dp[prev][index] = Math.max(dp[prev][index], dfs(i, index + 1) + arr[i][index]);
        }
        dp[prev][index] = Math.max(dp[prev][index], dfs(2, index + 1));
        return dp[prev][index];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9465_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[2][N];
            dp = new int[3][N];

            for (int i = 0; i < 3; i++) {
                Arrays.fill(dp[i], -1);
            }

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans.append(dfs(2, 0)).append("\n");
        }

        System.out.println(ans);
    }
}