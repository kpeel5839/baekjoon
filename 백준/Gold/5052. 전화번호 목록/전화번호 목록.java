import java.util.*;
import java.io.*;

// 5052 : 전화번호 목록

/**
 * Example
 * 2
 * 3
 * 911
 * 97625999
 * 91125426
 * 5
 * 113
 * 12340
 * 123440
 * 12345
 * 98346
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_5052_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            boolean possible = true;
            Set<Integer> set1 = new HashSet<>();
            Set<String> set2 = new HashSet<>();
            String[] ss = new String[N];

            for (int i = 0; i < N; i++) {
                ss[i] = br.readLine();
                set1.add(ss[i].length());
                set2.add(ss[i]);
            }

            for (int i = 0; i < N; i++) {
                String s = ss[i];

                for (Integer digit : set1) {
                    if (digit < s.length()) {
                        String substring = s.substring(0, digit);

                        if (set2.contains(substring)) {
                            possible = false;
                        }
                    }
                }
            }

            if (possible) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
    }
}