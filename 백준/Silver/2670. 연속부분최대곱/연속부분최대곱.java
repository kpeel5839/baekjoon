import java.util.*;
import java.io.*;

// 2670 : 연속부분최대곱

/**
 * Example
 * 8
 * 1.1
 * 0.7
 * 1.3
 * 0.9
 * 1.4
 * 0.8
 * 0.7
 * 1.4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2670_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double answer = 0;
        double sum = 1;

        for (int i = 0; i < N; i++) {
            sum *= Double.parseDouble(br.readLine());
            answer = Math.max(answer, sum);

            if (sum < 1) {
                sum = 1;
            }
        }

        System.out.println(String.format("%.3f", answer));
    }
}