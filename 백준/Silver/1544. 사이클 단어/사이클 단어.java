import java.util.*;
import java.io.*;

// 1544 : 사이클 단어

/**
 * Example
 * 5
 * picture
 * turepic
 * icturep
 * word
 * ordw
 */
public class Main {

    public static String[] cycle(String s) {
        String[] ss = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ss[i] = s;
            char b = s.charAt(s.length() - 1);
            s = b + s.substring(0, s.length() - 1);
        }

        return ss;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1544_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] cycle = cycle(s);
            boolean contains = false;

            for (int j = 0; j < cycle.length; j++) {
                if (set.contains(cycle[j])) {
                    contains = true;
                    break;
                }
            }

            if (!contains) {
                ans++;
                set.addAll(List.of(cycle));
            }
        }

        System.out.println(ans);
    }
}