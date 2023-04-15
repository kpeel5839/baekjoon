import java.util.*;
import java.io.*;

// 2841 : 외계인의 기타 연주

/**
 * Example
 * 5 15
 * 2 8
 * 2 10
 * 2 12
 * 2 10
 * 2 5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2841_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stacks = new Stack[7];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }
        int ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            while (!stacks[number].isEmpty() && v < stacks[number].peek()) {
                stacks[number].pop();
                ans++;
            }

            if (!stacks[number].isEmpty() && stacks[number].peek() == v) {
                continue;
            }

            ans++;
            stacks[number].push(v);
        }

        System.out.println(ans);
    }
}