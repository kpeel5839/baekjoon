import java.util.*;
import java.io.*;

// 2257 : 화학식량

/**
 * Example
 * ((CH)2(OH2H)(C(H))O)3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2257_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'C') {
                stack.add(12);
            } else if (c == 'H') {
                stack.add(1);
            } else if (c == 'O') {
                stack.add(16);
            } else if (c == '(') {
                stack.add(-1);
            } else if (c == ')') {
                int number = 0;

                while (stack.peek() != -1) {
                    number += stack.pop();
                }

                stack.pop();
                stack.push(number);
            } else { // 숫자
                stack.push(stack.pop() * (c - '0'));
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        System.out.println(ans);
    }
}