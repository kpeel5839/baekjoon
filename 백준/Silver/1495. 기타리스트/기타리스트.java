import java.util.*;
import java.io.*;

// 1495 : 기타리스트

/**
 * Example
 * 3 5 10
 * 5 3 7
 */
public class Main {

    public static int[][] dp;
    public static int INF = -1_000_000_000;
    public static int[] v;
    public static int N;
    public static int M;
    public static int S;

    public static int dfs(int index, int nowVolume) {
        if (nowVolume < 0 || M < nowVolume) {
            return INF;
        }

        if (index == N) {
            return nowVolume;
        }

        if (dp[index][nowVolume] != -1) {
            return dp[index][nowVolume];
        }

        dp[index][nowVolume] = Math.max(
                dfs(index + 1, nowVolume + v[index]),
                dfs(index + 1, nowVolume - v[index])
        );

        return dp[index][nowVolume];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1495_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new int[N];
        dp = new int[N][M + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < v.length; i++) {
            Arrays.fill(dp[i], -1);
            v[i] = Integer.parseInt(st.nextToken());
        }

        int result = dfs(0, S);

        if (result == INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}