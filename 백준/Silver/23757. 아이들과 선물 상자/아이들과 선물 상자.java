import java.util.*;
import java.io.*;

// 23757 : 아이들과 선물 상자

/**
 * Example
 * 4 4
 * 4 3 2 1
 * 3 1 2 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_23757_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int count = Integer.parseInt(st.nextToken());

            if (q.isEmpty() || q.peek() < count) {
                System.out.println(0);
                return;
            }

            q.add(q.poll() - count);
        }

        System.out.println(1);
    }
}