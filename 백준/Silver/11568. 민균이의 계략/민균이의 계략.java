import java.util.*;
import java.io.*;

// 11568 : 민균이의 계략

/**
 * Example
 * 5
 * 8 9 1 2 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_11568_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = i - 1; 0 <= j; j--) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}