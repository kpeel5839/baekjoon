import java.util.*;
import java.io.*;

// 11052 : 카드 구매하기

/**
 * Example
 * 4
 * 1 5 6 7
 */
public class Main {

    public static int N;
    public static int[] dp;
    public static int[] arr;
    public static final int INF = -1_000_000_000;

    public static int dfs(int cardCount) {
        if (N <= cardCount) {
            if (N == cardCount) {
                return 0;
            }

            return INF;
        }

        if (dp[cardCount] != -1) {
            return dp[cardCount];
        }

        dp[cardCount] = 0;

        for (int i = 0; i < N; i++) {
            dp[cardCount] = Math.max(dp[cardCount], dfs(cardCount + i + 1) + arr[i]);
        }

        return dp[cardCount];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11052_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        arr = new int[N];
        Arrays.fill(dp, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(0));
    }
}