import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

// 1935 : 후위 표기식 2

/**
 * Example
 * 5
 * ABC*+DE/-
 * 1
 * 2
 * 3
 * 4
 * 5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1935_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        double[] n = new double[N];
        String ss = br.readLine();
        Stack<Double> s = new Stack<>();
        BiFunction<Double, Double, Double> mul = (o1, o2) -> o1 * o2;
        BiFunction<Double, Double, Double> add = (o1, o2) -> o1 + o2;
        BiFunction<Double, Double, Double> sub = (o1, o2) -> o1 / o2;
        BiFunction<Double, Double, Double> min = (o1, o2) -> o1 - o2;
        Map<Character, BiFunction<Double, Double, Double>> m = Map.of(
                '*', mul,
                '/', sub,
                '+', add,
                '-', min
        );

        for (int i = 0; i < N; i++) {
            n[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < ss.length(); i++) {
            char c = ss.charAt(i);

            if (m.containsKey(c)) {
                Double a = s.pop();
                Double b = s.pop();

                s.push(m.get(c).apply(b, a));
            } else {
                s.push(n[(c - 'A')]);
            }
        }

        System.out.printf("%.2f", s.peek());
    }
}