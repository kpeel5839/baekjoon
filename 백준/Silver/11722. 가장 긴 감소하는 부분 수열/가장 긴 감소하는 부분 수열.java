import java.util.*;
import java.io.*;

// 11722 : 가장 긴 감소하는 부분 수열

/**
 * Example
 * 6
 * 10 30 10 20 20 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11722_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}