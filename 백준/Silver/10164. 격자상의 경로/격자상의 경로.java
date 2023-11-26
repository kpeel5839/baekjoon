import java.util.*;
import java.io.*;

// 10164 : 격자상의 경로

/**
 * Example
 * 7 11 76
 */
public class Main {

    public static long[][] dp;
    public static int H;
    public static int W;
    public static int K;

    public static void solution(int[] start, int[] destination) {
        for (int i = start[0]; i <= destination[0]; i++) {
            for (int j = start[1]; j <= destination[1]; j++) {
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_10164_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new long[H + 1][W + 1];
        dp[1][1] = 1;

        if (K == 0) {
            solution(new int[] {1, 1}, new int[] {H, W});
        } else {
            int[] 경유지 = new int[] {(int) Math.ceil((double) K / (double) W), ((K - 1) % W) + 1};
            solution(new int[] {1, 1}, 경유지);
            dp[경유지[0]][경유지[1]] = 0;
            solution(경유지, new int[] {H, W});
        }

        System.out.println(dp[H][W]);
    }
}