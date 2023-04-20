import java.util.*;
import java.io.*;

// 4889 : 안정적인 문자열

/**
 * Example
 * }{
 * {}{}{}
 * {{{}
 * ---
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_4889_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int index = 1;
        while (true) {
            String s = br.readLine();

            if (s.charAt(0) == '-') {
                break;
            }

            Queue<Integer> q = new LinkedList<>();
            int ans = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '{') {
                    q.add(1);
                } else {
                    if (q.isEmpty()) {
                        ans++;
                        q.add(1);
                    } else {
                        q.poll();
                    }
                }
            }

            ans += (q.size() / 2);
            bw.write(index + ". " + ans + "\n");
            index++;
        }

        bw.flush();
        bw.close();
    }
}
