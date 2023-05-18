import java.util.*;
import java.io.*;

// 13417 : 카드 문자열

/**
 * Example
 * 3
 * 3
 * M K U
 * 5
 * A S D F G
 * 7
 * B A C A B A C
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13417_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Deque<Character> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                char c = st.nextToken().charAt(0);
                if (q.isEmpty()) {
                    q.add(c);
                } else {
                    char cc = q.peekFirst();

                    if (c <= cc) {
                        q.addFirst(c);
                    } else {
                        q.addLast(c);
                    }
                }
            }

            while (!q.isEmpty()) {
                bw.write(q.pollFirst());
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}