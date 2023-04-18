import java.util.*;
import java.io.*;

// 9933 : 민균이의 비밀번호

/**
 * Example
 * 4
 * las
 * god
 * psala
 * sal
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9933_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> s = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringBuilder ss = new StringBuilder(br.readLine());
            s.add(ss.toString());

            if (s.contains(ss.reverse().toString())) {
                System.out.println(ss.length() + " " + ss.charAt(ss.length() / 2));
                break;
            }
        }
    }
}