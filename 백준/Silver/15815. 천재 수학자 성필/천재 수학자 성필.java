import java.util.*;
import java.io.*;
import java.util.function.BiFunction;

// 15815 : 천재 수학자 성필

/**
 * Example
 * 123*+
 */
public class Main {

    public static void calculate(Stack<Integer> stack, BiFunction<Integer, Integer, Integer> function) {
        Integer a = stack.pop();
        Integer b = stack.pop();
        stack.add(function.apply(b, a));
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15815_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '*') {
                calculate(stack, (o1, o2) -> o1 * o2);
            } else if (c == '+') {
                calculate(stack, (o1, o2) -> o1 + o2);
            } else if (c == '/') {
                calculate(stack, (o1, o2) -> o1 / o2);
            } else if (c =='-') {
                calculate(stack, (o1, o2) -> o1 - o2);
            } else {
                stack.add(c - '0');
            }
        }

        System.out.println(stack.peek());
    }
}