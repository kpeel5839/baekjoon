import java.util.*;
import java.io.*;

// 2161 : 카드1

/**
 * Example
 * 7
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2161_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> l = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            l.addLast(i);
        }

        for (int i = 0; i < N - 1; i++) {
            bw.write(l.pollFirst() + " ");
            l.addLast(l.pollFirst());
        }

        bw.write(l.poll() + "");
        bw.flush();
        bw.close();
    }
}