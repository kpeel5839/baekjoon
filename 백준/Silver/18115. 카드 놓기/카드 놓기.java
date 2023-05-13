import java.util.*;
import java.io.*;

// 18115 : 카드 놓기

/**
 * Example
 * 5
 * 2 3 3 2 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_18115_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            q.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());

            if (v == 1) {
                a[q.pollFirst()] = N - i;
            } else if (v == 2) {
                int b = q.pollFirst();
                a[q.pollFirst()] = N - i;
                q.addFirst(b);
            } else {
                a[q.pollLast()] = N - i;
            }
        }

        for (int i = 0; i < a.length; i++) {
            bw.write(a[i] + " ");
        }

        bw.flush();
    }
}