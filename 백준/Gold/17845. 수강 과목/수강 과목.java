import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17845 : 수강 과목

/**
 * Example
 * 80 3
 * 650 40
 * 700 60
 * 60 40
 */
public class Main {

    public static int N;
    public static int HEALTH;
    public static int[][] dp;
    public static int[][] study;

    public static int dfs(int remainHealth, int index) {
        if (N == index) {
            return 0;
        }

        if (dp[remainHealth][index] != -1) {
            return dp[remainHealth][index];
        }

        if (study[index][1] <= remainHealth) {
            dp[remainHealth][index] = Math.max(dp[remainHealth][index], dfs(remainHealth - study[index][1], index + 1) + study[index][0]);
        }

        dp[remainHealth][index] = Math.max(dp[remainHealth][index], dfs(remainHealth, index + 1));

        return dp[remainHealth][index];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_17845_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HEALTH = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        study = new int[N][2];
        dp = new int[HEALTH + 1][N];

        for (int i = 0; i <= HEALTH; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            study[i][0] = Integer.parseInt(st.nextToken());
            study[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(HEALTH, 0));
    }
}