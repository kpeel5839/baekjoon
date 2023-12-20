import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 12026 : BOJ 거리

/**
 * Example
 * 9
 * BOJBOJBOJ
 */
public class Main {

    public static int N;
    public static int[] dp;
    public static char[] c;
    public static final int INF = 1_000_000_000;
    public static Map<Character, Integer> converter = new HashMap<>(
            Map.of('B', 0, 'O', 1,'J', 2)
    );

    public static int dfs(int index) {
        if (index == N - 1) {
            return 0;
        }

        if (dp[index] != INF) {
            return dp[index];
        }

        int findValue = (converter.get(c[index]) + 1) % 3;

        for (int i = index + 1; i < N; i++) {
            if (findValue == converter.get(c[i])) {
                dp[index] = Math.min(dp[index], dfs(i) + (i - index) * (i - index));
            }
        }

        return dp[index];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_12026_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        c = br.readLine().toCharArray();
        dp = new int[N];
        Arrays.fill(dp, INF);
        int result = dfs(0);
        System.out.println(result == INF ? -1 : result);
    }

}