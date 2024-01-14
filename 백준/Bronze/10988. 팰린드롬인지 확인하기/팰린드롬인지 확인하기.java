import java.util.*;
import java.io.*;

// 10988 : 팰린드롬인지 확인하기

/**
 * Example
 * baekjoon
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_10988_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}