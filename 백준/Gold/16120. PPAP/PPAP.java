import java.util.*;
import java.io.*;

// 16120 : PPAP

/**
 * Example
 * PPPAPAP
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16120_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);

            if (c == 'A') {
                ++i;

                if (i < s.length() && 3 <= stack.size()) {
                    StringBuilder sb = new StringBuilder();

                    for (int j = 0; j < 3; j++) {
                        sb.append(stack.pop());
                    }

                    if (sb.reverse().append(s.charAt(i)).toString().equals("PPAP")) {
                        stack.push('P');
                    } else {
                        System.out.println("NP");
                        return;
                    }
                } else {
                    System.out.println("NP");
                    return;
                }
            }
        }

        System.out.println((stack.size() == 1 && stack.peek() == 'P') ? "PPAP" : "NP");
    }
}