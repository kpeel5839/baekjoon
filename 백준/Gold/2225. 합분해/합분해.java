import java.util.*;
import java.io.*;

// 2225 : 합분해

/**
 *
 * 예제
 *
 * 20 2
 */

// 해맸던 점 : 이미 0 점에 도달했더라도 다 0만 선택하는 경우가 있는데, 내가 그 경우를 아얘 막아버려서 자꾸 다른 답이 나왔었음

public class Main {
    static int N;
    static int K;
    static int[][] dp;
    static int MOD = 1_000_000_000;

    static int dfs(int depth, int remain) { // depth == 현재까지 선택한 숫자의 개수, remain == 앞으로 K 까지 도달하기 위해 남은 값
        if (depth == K) {
            if (remain == 0) { // 완벽히 맞춘 경우
                return 1;
            } else { // 맞추지 못한 경우
                return 0;
            }
        }

        if (dp[depth][remain] != -1) {
            return dp[depth][remain];
        }

        dp[depth][remain] = 0;

        for (int i = 0; i <= N; i++) {
            if (remain - i >= 0) { // remain 에서 i 를 빼면, 음수가 되는 경우, 즉 하면 안된다.
                int res = dfs(depth + 1, remain - i);

                dp[depth][remain] = (dp[depth][remain] + res) % MOD;
            }
        }

        return (dp[depth][remain] % MOD);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2225_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K + 1][N + 1];

        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, N));
    }
}