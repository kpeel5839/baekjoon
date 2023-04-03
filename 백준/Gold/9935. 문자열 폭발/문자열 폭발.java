import java.util.*;
import java.io.*;

// 9935 : 문자열 폭발

/**
 * Example
 * mirkovC4nizCC44
 * C4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9935_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder c = new StringBuilder(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            sb.append(c1);

            if (c.length() <= sb.length()) {
                boolean success = false;
                for (int j = 0; j < c.length(); j++) {
                    if (c.charAt(j) != sb.charAt(sb.length() - c.length() + j)) {
                        break;
                    }

                    if (c.length() - 1 == j) {
                        success = true;
                    }
                }

                if (success) {
                    for (int j = 0; j < c.length(); j++) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}