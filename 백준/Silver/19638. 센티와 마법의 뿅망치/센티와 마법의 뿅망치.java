import java.util.*;
import java.io.*;

// 19638 : 세티와 마법의 뽕망치

/**
 * Example
 * 1 10 1
 * 20
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_19638_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        if (q.peek() < M) {
            System.out.println("YES\n" + 0);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (q.peek() == 1) {
                continue;
            }

            q.add(q.poll() / 2);

            if (q.peek() < M) {
                System.out.println("YES\n" + (i + 1));
                return;
            }
        }

        System.out.println("NO\n" + q.peek());
    }
}