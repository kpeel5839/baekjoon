import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14430 : 자원 캐기

/**
 * Example
 * 5 4
 * 0 1 0 0
 * 0 0 1 0
 * 1 1 0 0
 * 1 0 1 0
 * 1 1 0 0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_14430_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H + 1][W + 1];
        int[][] dp = new int[H + 1][W + 1];

        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }

        System.out.println(dp[H][W]);
    }
}