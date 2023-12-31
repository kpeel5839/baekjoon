import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2281 : 데스노트

/**
 * Example
 * 11 20
 * 7
 * 4
 * 2
 * 3
 * 2
 * 5
 * 1
 * 12
 * 7
 * 5
 * 6
 */
public class Main {

    public static int N;
    public static int W;
    public static int[] arr;
    public static int[][] dp;
    public static int INF = 1_000_000_000;

    public static int dfs(int i, int index) {
        if (i == arr.length - 1) {
            return 0;
        }

        if (dp[i][index] != INF) {
            return dp[i][index];
        }

        int nextIndex = index + arr[i] + 1;
        int remain = (W - 1) - (index + arr[i] - 1);

        if (W <= nextIndex + arr[i + 1] - 1) {
            dp[i][index] = Math.min(dp[i][index], dfs(i + 1, 0) + remain * remain);
            return dp[i][index];
        }

        dp[i][index] = Math.min(dfs(i + 1, nextIndex), dfs(i + 1, 0) + remain * remain);
        return dp[i][index];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_2281_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N][W];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(0, 0));
    }
}