import java.util.*;
import java.io.*;

// 2605 : 줄 세우기

/**
 * Example
 * 5
 * 0 1 1 3 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2605_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> l = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            l.add(l.size() - Integer.parseInt(st.nextToken()), i);
        }

        l.forEach(e -> System.out.print(e + " "));
    }
}