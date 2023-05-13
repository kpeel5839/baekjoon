import java.util.*;
import java.io.*;

// 4158 : CD

/**
 * Example
 * 3 3
 * 1
 * 2
 * 3
 * 1
 * 2
 * 4
 * 0 0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_4158_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0) {
                break;
            }

            Set<Integer> s = new HashSet<>();
            int ans = 0;

            for (int i = 0; i < A; i++) {
                s.add(Integer.parseInt(br.readLine()));
            }

            for (int i = 0; i < B; i++) {
                if (s.contains(Integer.parseInt(br.readLine()))) {
                    ans++;
                }
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
    }
}