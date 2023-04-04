import java.util.*;
import java.io.*;

// 3986 : 좋은 단어

/**
 * Example
 * 3
 * ABAB
 * AABB
 * ABBA
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_3986_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.size() == 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}