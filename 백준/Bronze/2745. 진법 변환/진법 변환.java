import java.util.*;
import java.io.*;

// 2745 : 진법 변환

/**
 * Example
 * ZZZZZ 36
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_2745_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = s.length() - 1; 0 <= i; i--) {
            char c = s.charAt(i);
            int pow = s.length() - 1 - i;

            if (Character.isAlphabetic(c)) {
                int number = c - 'A' + 10;
                answer += (number * (int) Math.pow(n, pow));
            } else {
                int number = c - '0';
                answer += (number * (int) Math.pow(n, pow));
            }
        }

        System.out.println(answer);
    }
}
