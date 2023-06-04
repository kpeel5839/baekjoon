import java.util.*;
import java.io.*;

// 1835 : 카드

/**
 * Example
 * 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1835_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++) {
            q.addLast(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                q.addLast(q.pollFirst());
            }

            sequence[q.pollFirst()] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            bw.write(sequence[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
