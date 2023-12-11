import java.util.*;
import java.io.*;

// 17202 : 핸드폰 번호 궁합

/**
 * Example
 * 74759336
 * 36195974
 */
public class Main {

    public static String getCombinationString(String s1, String s2) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            sb.append(s1.charAt(i)).append(s2.charAt(i));
        }

        return sb.toString();
    }

    public static String getCalculateString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ;i < s.length() - 1; i++) {
            String ss = Integer.toString((s.charAt(i) - '0') + (s.charAt(i + 1) - '0'));

            if (ss.length() == 2) {
                sb.append(ss.charAt(1));
                continue;
            }

            sb.append(ss);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_17202_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String result = getCombinationString(s1, s2);

        while (result.length() != 2) {
            result = getCalculateString(result);
        }

        System.out.println(result);
    }

}