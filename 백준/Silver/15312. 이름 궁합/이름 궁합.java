import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// 15312 : 이름 궁합

/**
 * Example
 * CJM
 * HER
 */
public class Main {

    public static int[] count = new int[] {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static String A;
    public static String B;
    public static StringBuilder sb = new StringBuilder();

    public static StringBuilder combination(StringBuilder s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            result.append(((s.charAt(i) - '0') + (s.charAt(i + 1) - '0')) % 10);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_15312_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();

        for (int i = 0; i < A.length(); i++) {
            sb.append(count[A.charAt(i) - 'A']).append(count[B.charAt(i) - 'A']);
        }

        while (sb.length() != 2) {
            sb = combination(sb);
        }

        System.out.println(sb);
    }
}