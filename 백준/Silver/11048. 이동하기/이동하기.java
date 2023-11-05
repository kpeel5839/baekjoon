import java.util.*;
import java.io.*;

// 11048 : 이동하기

/**
 * Example
 * 3 4
 * 1 2 3 4
 * 0 0 0 5
 * 9 8 7 6
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11048_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        int[][] dp = new int[H + 1][W + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])) + map[i - 1][j - 1];
            }
        }

        System.out.println(dp[H][W]);
    }
}