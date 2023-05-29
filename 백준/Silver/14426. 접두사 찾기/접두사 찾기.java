import java.util.*;
import java.io.*;

// 14426 : 접두사 찾기

/**
 * Example
 * 5 10
 * baekjoononlinejudge
 * startlink
 * codeplus
 * sundaycoding
 * codingsh
 * baekjoon
 * star
 * start
 * code
 * sunday
 * coding
 * cod
 * online
 * judge
 * plus
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_14426_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {
                sb.append(s.charAt(j));
                set.add(sb.toString());
            }
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}