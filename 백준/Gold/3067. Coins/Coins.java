import java.util.*;
import java.io.*;

// 3067 : Coin

/**
 * Example
 * 3
 * 2
 * 1 2
 * 1000
 * 3
 * 1 5 10
 * 100
 * 2
 * 5 7
 * 22
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_3067_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            long[][] dp = new long[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= M; j++) {
                    dp[i][j] = dp[i - 1][j] + (j - arr[i] < 0 ? 0 : dp[i][j - arr[i]]);
                }
            }

            sb.append(dp[N][M]).append("\n");
        }

        System.out.println(sb);
    }
}