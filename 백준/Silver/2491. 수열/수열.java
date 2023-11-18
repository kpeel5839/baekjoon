import java.util.*;
import java.io.*;

// 2491 : 수열

/**
 * Example
 * 9
 * 4 1 3 3 2 2 9 2 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2491_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int answer = 1;
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int left = i == 0 ? Integer.MIN_VALUE : arr[i - 1];

            if (left <= arr[i]) {
                count++;
            } else {
                count = 1;
            }

            answer = Math.max(answer, count);
        }

        count = 1;

        for (int i = arr.length - 2; 0 <= i; i--) {
            if (arr[i + 1] <= arr[i]) {
                count++;
            } else {
                count = 1;
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}