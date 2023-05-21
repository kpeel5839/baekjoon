import java.util.*;
import java.io.*;

// 1972 : 놀라운 문자열

/**
 * Example
 * ZGBG
 * X
 * EE
 * AAB
 * AABA
 * AABB
 * BCBABCC
 * *
 */
public class Main {

    public static boolean isPossible(String s, int distance) {
        distance = distance + 1;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length() - distance; i++) {
            String ss = s.charAt(i) + "" + s.charAt(i + distance);

            if (set.contains(ss)) {
                return false;
            }

            set.add(ss);
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1972_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();

            if (s.equals("*")) {
                break;
            }

            boolean success = true;

            for (int i = 0; i < s.length() - 1; i++) {
                if (!isPossible(s, i)) {
                    success = false;
                }
            }

            if (success) {
                bw.write(s + " is surprising.\n");
            } else {
                bw.write(s + " is NOT surprising.\n");
            }
        }

        bw.flush();
        bw.close();
    }
}