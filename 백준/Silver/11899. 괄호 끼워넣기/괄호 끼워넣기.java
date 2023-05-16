import java.util.*;
import java.io.*;

// 11899 : 괄호 끼워넣기

/**
 * Example
 * )))()
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11899_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (stack.isEmpty()) {
                    ans++;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(1);
            }
        }

        System.out.println(ans + stack.size());
    }
}

