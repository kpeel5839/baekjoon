import java.util.*;
import java.io.*;

//  1535 : 안녕

/**
 * Example
 * 8
 * 100 26 13 17 24 33 100 99
 * 34 56 21 1 24 34 100 99
 */
public class Main {

    public static int N;
    public static int[] L;
    public static int[] J;
    public static int[][] dp;

    public static int dfs(int health, int index) {
        if (health <= 0) {
            return Integer.MIN_VALUE;
        }

        if (index == N) {
            return 0;
        }

        if (dp[health][index] != -1) {
            return dp[health][index];
        }

        dp[health][index] = Math.max(dfs(health, index + 1), dfs(health - L[index], index + 1) + J[index]);
        return dp[health][index];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1535_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        L = new int[N];
        J = new int[N];
        dp = new int[101][N];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(100, 0));
    }
}