import java.util.*;
import java.io.*;

// 13414 : 수강신청

/**
 * Example
 * 3 8
 * 20103324
 * 20133221
 * 20133221
 * 20093778
 * 20140101
 * 01234567
 * 20093778
 * 20103325
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13414_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> m = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            m.put(s, m.getOrDefault(s, 0) + 1);
            q.add(s);
        }

        while (!q.isEmpty() && N != 0) {
            String poll = q.poll();

            if (1 < m.get(poll)) {
                m.put(poll, m.get(poll) - 1);
            } else {
                bw.write(poll + "\n");
                N--;
            }
        }

        bw.flush();
        bw.close();
    }
}