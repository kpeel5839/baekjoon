import java.util.*;
import java.io.*;

// 8394 : 약수

/**
 * Example
 * 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_8394_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[0] = 1;

        for (int i = 1; i <= N; i++) {
            arr[i] = (arr[i - 1] + (i - 2 < 0 ? 0 : arr[i - 2])) % 10;
        }

        System.out.println(arr[N]);
    }
}