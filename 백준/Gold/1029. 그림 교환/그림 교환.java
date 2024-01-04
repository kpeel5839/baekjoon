import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1029 : 그림 교환

/**
 * Example
 * 3
 * 022
 * 101
 * 110
 */
public class Main {

    public static int n;
    public static int[][][] dp;
    public static int[][] arr;

    public static int dfs(int bit, int index, int now) {
        if (dp[bit][index][now] != -1) {
            return dp[bit][index][now];
        }

        dp[bit][index][now] = 1;

        for (int i = 0; i < n; i++) {
            if (index != i && (bit & (1 << i)) == 0 && now <= arr[index][i]) {
                dp[bit][index][now] = Math.max(dp[bit][index][now], dfs(bit | (1 << i), i, arr[index][i]) + 1);
            }
        }

        return dp[bit][index][now];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1029_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[1 << n][n][10];

        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(dfs(1, 0, 0));
    }
}