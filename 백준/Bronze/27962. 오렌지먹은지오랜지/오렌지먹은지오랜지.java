import java.util.*;
import java.io.*;

// 27962 : 오렌지먹은지오랜지

/**
 * Example
 * 15
 * orangeateorenge
 */
public class Main {

    public static boolean isSeokjin(String s1, String s2) {
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_27962_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();

        String s1 = "";
        String s2 = "";

        int l = 0;
        int r = c.length - 1;

        for (int i = 0; i < N; i++) {
            s1 = s1 + c[l++];
            s2 = c[r--] + s2;

            if (isSeokjin(s1, s2)) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}