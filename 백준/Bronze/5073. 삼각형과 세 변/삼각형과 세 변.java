import java.util.*;
import java.io.*;

// 5073 : 삼각형과 세변

/**
 * Example
 7 7 7
 6 5 4
 3 2 5
 6 2 6
 0 0 0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_5073_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder ans = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s.charAt(0) == '0') {
                break;
            }

            Set<Integer> set = new HashSet<>();
            int sum = 0;
            int max = 0;
            st = new StringTokenizer(s);

            for (int i = 0; i < 3; i++) {
                int length = Integer.parseInt(st.nextToken());
                max = Math.max(max, length);
                sum += length;
                set.add(length);
            }

            if (sum - max <= max) {
                ans.append("Invalid").append("\n");
                continue;
            }

            if (set.size() == 1) {
                ans.append("Equilateral").append("\n");
            } else if (set.size() == 2) {
                ans.append("Isosceles").append("\n");
            } else {
                ans.append("Scalene").append("\n");
            }
        }

        System.out.println(ans);
    }
}