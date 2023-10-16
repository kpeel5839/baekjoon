import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 9095 : 1, 2, 3 더하기

/**
 * Example
 * 3
 * 4
 * 7
 * 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9095_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[0] = 1;

        for (int i = 1; i < 12; i++) {
            for (int j = 1; j <= 3;j ++) {
                dp[i] += i - j < 0 ? 0 : dp[i - j];
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            ans.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(ans);
    }
}