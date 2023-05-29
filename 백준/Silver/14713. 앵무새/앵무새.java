import java.util.*;
import java.io.*;

// 14713 : 앵무새

/**
 * Example
 * 2
 * i found
 * an interesting cave
 * i found an cave interesting
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_14713_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque[] deques = new Deque[N];
        int countToken = 0;

        for (int i = 0; i < N; i++) {
            deques[i] = new LinkedList<Integer>();
            st = new StringTokenizer(br.readLine());
            countToken += st.countTokens();

            while (st.hasMoreTokens()) {
                deques[i].addLast(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        if (countToken != st.countTokens()) {
            System.out.println("Impossible");
            return;
        }

        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            boolean find = false;

            for (int i = 0; i < N; i++) {
                if (!deques[i].isEmpty() && deques[i].peekFirst().equals(s)) {
                    deques[i].pollFirst();
                    find = true;
                    break;
                }
            }

            if (!find) {
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");
    }
}