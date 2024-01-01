import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1311 : 할 일 정하기 1

/**
 * Example
 * 3
 * 2 3 3
 * 3 2 3
 * 3 3 2
 */
public class Main {

    public static int n;
    public static int[] dp;
    public static int[][] arr;

    public static int dfs(int bit, int index) {
        if (index == n) {
            return 0;
        }

        if (dp[bit] != Integer.MAX_VALUE) {
            return dp[bit];
        }

        for (int i = 0; i < n; i++) {
            if ((bit & (1 << i)) == 0) {
                dp[bit] = Math.min(dp[bit], dfs(bit | (1 << i), index + 1) + arr[index][i]);
            }
        }

        return dp[bit];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1311_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }
}