import java.util.*;
import java.io.*;

// 1421 : 나무꾼 이다솜

/**
 * Example
 * 3 1 10
 * 26
 * 103
 * 59
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1421_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());

        long[] arr = new long[(int) N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long ans = 0;

        for (long i = 1; i <= max; i++) {
            long sum = 0;

            for (long j = 0; j < N; j++) {
                long a = arr[(int) j] / i; // 6 / 3 이면 2, 7 / 3 이면 3 이잖아..
                long b = arr[(int) j] % i != 0 ? a + 1 : a;

                if (i * a * W < (b - 1) * C) {
                    continue;
                }

                sum += (i * a * W);
                sum -= ((b - 1) * C);
                ans = Math.max(ans, sum);
            }
        }

        System.out.println(ans);
    }
}