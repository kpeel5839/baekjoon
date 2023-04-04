import java.util.*;
import java.io.*;

// 17608 : 막대기

/**
 * Example
 * 6
 * 6
 * 9
 * 7
 * 6
 * 4
 * 6
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17608_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = arr.length - 1; i != -1; i--) {
            if (max < arr[i]) {
                ans++;
                max = arr[i];
            }
        }

        System.out.println(ans);
    }
}