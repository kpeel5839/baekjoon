import java.util.*;
import java.io.*;

// 2776 : 암기왕

/**
 * Example
 * 1
 * 5
 * 4 1 5 2 3
 * 5
 * 1 3 7 9 5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2776_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Set<Integer> set = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int i1 = Integer.parseInt(st.nextToken());

                if (set.contains(i1)) {
                    bw.write("1" + "\n");
                } else {
                    bw.write("0" + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}