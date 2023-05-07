import java.util.*;
import java.io.*;

// 1235 : 학생 번호

/**
 * Example
 * 3
 * 1212345
 * 1212356
 * 0033445
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1235_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashSet<String> ss;
        String[] s = new String[N];

        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }

        int ans = s[0].length();

        for (int i = 1; i < s[0].length(); i++) {
            ss = new HashSet<>();

            for (int j = 0; j < s.length; j++) {
                ss.add(s[j].substring(i));
            }

            if (ss.size() != s.length) {
                break;
            } else {
                ans = s[0].length() - i;
            }
        }

        System.out.println(ans);
    }
}