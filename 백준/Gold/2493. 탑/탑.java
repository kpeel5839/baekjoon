import java.util.*;
import java.io.*;

// 2493 : 탑

/**
 * Example
 * 5
 * 6 9 5 7 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2493_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        st = new StringTokenizer(br.readLine());
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < N; i++) {
            int nn = a[i];

            while (!s.isEmpty() && a[s.peek()] < nn) {
                s.pop();
            }

            if (!s.isEmpty()) {
                bw.write((s.peek() + 1) + " ");
            } else {
                bw.write(0 + " ");
            }

            s.push(i);
        }

        bw.flush();
        bw.close();
    }
}