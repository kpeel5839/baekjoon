import java.util.*;
import java.io.*;

// 25757 : 임스와 함께하는 미니게임

/**
 * Example
 * 12 O
 * lms0806
 * mageek2guanaah
 * jthis
 * lms0806
 * exponentiale
 * lms0806
 * leo020630
 * lms0806
 * powergee
 * lms0806
 * skeep194
 * lms0806
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_25757_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> m = Map.of("Y", 2, "F", 3, "O", 4);

        int N = Integer.parseInt(st.nextToken());
        int M = m.get(st.nextToken()) - 1;
        int count = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (set.contains(s)) {
                continue;
            }

            set.add(s);
            count++;
        }
        
        System.out.println(count / M);
    }
}