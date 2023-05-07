import java.util.*;
import java.io.*;

// 10546 : 배부른 마라토너

/**
 * Example
 * 3
 * leo
 * kiki
 * eden
 * eden
 * kiki
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_10546_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> m = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String s = br.readLine();
            int v = m.get(s) - 1;
            m.put(s, v);
            if (v == 0) {
                m.remove(s);
            }
        }

        m.keySet().forEach(System.out::println);
    }
}