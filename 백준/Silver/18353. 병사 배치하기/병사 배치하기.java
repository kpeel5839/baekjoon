import java.util.*;
import java.io.*;

// 18353 : 병사 배치하기

/**
 * Example
 * 7
 * 15 11 4 8 5 2 4
 */
public class Main {

    public static int N;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_18353_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int max = 0;

            for (int j = i - 1; 0 <= j; j--) {
                if (arr[j] > arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(N - answer);
    }
}