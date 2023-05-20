import java.util.*;
import java.io.*;

// 23253 : 자료구조는 정말 최고야

/**
 * Example
 * 4 2
 * 2
 * 3 1
 * 2
 * 4 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_23253_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int max = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (max <= num) {
                    System.out.println("No");
                    return;
                }
                max = num;
            }
        }

        System.out.println("Yes");
    }
}
