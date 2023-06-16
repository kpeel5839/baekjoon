import java.util.*;
import java.io.*;

// 25631 : 마트료시카 합치기

/**
 * Example
 * 7
 * 3 3 4 5 2 2 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_25631_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int ans = N;

        for (int i = 1; i < N; i++) {
            if (arr[left] < arr[i]) {
                left++;
                ans--;
            }
        }

        System.out.println(ans);
    }
}