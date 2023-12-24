import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 17212 : 달나라 토끼를 위한 구매대금 지불 도우미

/**
 * Example
 * 12
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_17212_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] coin = new int[] {0, 1, 2, 5 ,7};
        int[][] dp = new int[5][N + 1];
        final int INF = 1_000_000;

        for (int i = 0; i < 5; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= N; j++) {
                if (j - coin[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin[i]] + 1);
            }
        }

        System.out.println(dp[4][N]);
    }
}