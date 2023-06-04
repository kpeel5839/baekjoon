import java.util.*;
import java.io.*;

// 11507 : 카드 셋트

/**
 * Example
 * P01K02H03H04
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11507_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[] {13, 13, 13, 13};
        Set<String> set = new HashSet<>();
        Map<Character, Integer> map = Map.of(
                'P', 0,
                'K', 1,
                'H', 2,
                'T', 3
        );

        String s = br.readLine();
        for (int i = 0; i < s.length(); i += 3) {
            String substring = s.substring(i, i + 3);

            if (set.contains(substring)) {
                System.out.println("GRESKA");
                return;
            }

            set.add(substring);
            count[map.get(substring.charAt(0))]--;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
    }
}