import java.util.*;
import java.io.*;

// 13975 : 파일 합치기 3

/**
 * Example
 * 2
 * 4
 * 40 30 30 50
 * 15
 * 1 21 3 4 5 35 5 4 3 5 98 21 14 17 32
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13975_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long ans = 0;
            PriorityQueue<Long> q = new PriorityQueue<>(Long::compare);

            for (int i = 0; i < N; i++) {
                q.add(Long.parseLong(st.nextToken()));
            }

            while (1 < q.size()) {
                long a = q.poll();
                long b = q.poll();

                ans += (a + b);
                q.add(a + b);
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
    }
}