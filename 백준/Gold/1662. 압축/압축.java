import java.util.*;
import java.io.*;

// 1662 : 압축

/**
 * Example
 * 33(562(71(9)))
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1662_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<int[]> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                int count = 0;

                while (!stack.isEmpty()) {
                    int[] ss = stack.pop();
                    char cc = s.charAt(ss[0]);

                    if (cc == '(') {
                        break;
                    }

                    count += ss[1];
                }

                int[] ss = stack.pop();
                stack.push(new int[] {ss[0], count * (s.charAt(ss[0]) - '0')});

            } else {
                stack.push(new int[] {i, 1});
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop()[1];
        }

        System.out.println(res);
    }
}