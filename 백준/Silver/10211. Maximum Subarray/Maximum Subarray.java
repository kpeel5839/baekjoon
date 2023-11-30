import java.util.*;
import java.io.*;

// 10211 : Maximum Subarray

/**
 * Example
 * 2
 * 5
 * 1 2 3 4 5
 * 5
 * 2 1 -2 3 -5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_10211_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < N; i++) {
                sum += Integer.parseInt(st.nextToken());
                max = Math.max(max, sum);

                if (sum < 0) {
                    sum = 0;
                }
            }

            ans.append(max).append("\n");
        }

        System.out.println(ans);
    }
}