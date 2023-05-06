import java.util.*;
import java.io.*;

// 12789 : 도키도키 간식드리미

/**
 * Example
 * 5
 * 5 4 1 3 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_12789_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int n = 1;
        while (st.hasMoreTokens()) {
            stack.push(Integer.parseInt(st.nextToken()));

            while (!stack.isEmpty() && stack.peek() == n) {
                stack.pop();
                n++;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
