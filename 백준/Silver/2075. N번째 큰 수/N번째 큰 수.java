import java.util.*;
import java.io.*;

// 2075 : N 번째 큰 수

/**
 * Example
 * 5
 * 12 7 9 15 5
 * 13 8 11 19 6
 * 21 10 26 31 16
 * 48 14 28 35 25
 * 52 20 32 41 49
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2075_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N * N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i * N + j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int j = 0; j < N; j++) {
            q.add(new int[] {arr[(N - 1) * N + j], (N - 1) * N + j});
        }

        int count = 0;
        int ans = 0;
        while (true) {
            int[] poll = q.poll();
            ans = poll[0];
            count++;
            
            if (count == N) {
                break;
            }
            
            q.add(new int[] {arr[poll[1] - N], poll[1] - N});
        }

        System.out.println(ans);
    }
}