import java.util.*;
import java.io.*;

// 15903 : 카드 합체 놀이

/**
 * Example
 * 4 2
 * 4 2 3 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15903_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> q = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            Long a = q.poll();
            Long b = q.poll();
            q.add(a + b);
            q.add(a + b);
        }

        long answer = 0;
        while (!q.isEmpty()) {
            answer += q.poll();
        }

        System.out.println(answer);
    }
}