import java.util.*;
import java.io.*;

// 15483 : 최소 편집

/**
 * Example
 * abc
 * ab
 */
public class Main {

    public static String s1;
    public static String s2;
    public static final int INF = 1_000_000_000;
    public static int[][] dp;

    public static int dfs(int i1, int i2) {
        if (i1 == s1.length() && i2 == s2.length()) {
            return 0;
        }

        if (s1.length() <= i1 && i2 < s2.length()) { // i1 만 나간 경우, 이 경우네느 삽입을 통해서 해결
            return s2.length() - i2;
        }

        if (s2.length() <= i2 && i1 < s1.length()) { // i2 만 나간 경우 - 이 경우는 삭제를 통해서 해결
            return s1.length() - i1;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        dp[i1][i2] = INF;

        if (s1.charAt(i1) == s2.charAt(i2)) {
            dp[i1][i2] = Math.min(dp[i1][i2], dfs(i1 + 1, i2 + 1));
        } else {
            dp[i1][i2] = Math.min(dp[i1][i2], dfs(i1 + 1, i2 + 1) + 1);
        }

        dp[i1][i2] = Math.min(dp[i1][i2], dfs(i1, i2 + 1) + 1);
        dp[i1][i2] = Math.min(dp[i1][i2], dfs(i1 + 1, i2) + 1);
        return dp[i1][i2];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_15483_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s1 = br.readLine();
        s2 = br.readLine();
        dp = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }


        System.out.println(dfs(0, 0));
    }
}