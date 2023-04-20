import java.util.*;
import java.io.*;

// 12605 : 단어 순서 뒤집기

/**
 * Example
 * 3
 * this is a test
 * foobar
 * all your base
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_12605_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            bw.write("Case #" + i + ": ");

            for (int j = s.length - 1; 0 <= j; j--) {
                bw.write(s[j] + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}