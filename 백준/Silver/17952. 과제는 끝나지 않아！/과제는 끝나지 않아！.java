import java.util.*;
import java.io.*;

// 17952 : 과제는 끝나지 않아.

/**
 * Example
 * 3
 * 1 100 3
 * 0
 * 0
 */
public class Main {
    public static class Assign {
        int score;
        int time;

        public Assign(int score, int time) {
            this.score = score;
            this.time = time;
        }

        public boolean isEnd() {
            return time == 0;
        }

        public void decrease() {
            time--;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17952_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        Stack<Assign> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                stack.push(new Assign(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            if (!stack.isEmpty()) {
                Assign a = stack.pop();
                a.decrease();

                if (a.isEnd() ) {
                    ans += a.score;
                } else {
                    stack.push(a);
                }
            }
        }

        System.out.println(ans);
    }
}