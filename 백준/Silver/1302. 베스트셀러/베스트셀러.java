import java.util.*;
import java.io.*;

// 1302 : 베스트 셀러

/**
 * Example
 * 5
 * top
 * top
 * top
 * top
 * kimtop
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1302_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(m.entrySet());
        entries.sort((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }

            return o2.getValue() - o1.getValue();
        });

        System.out.println(entries.get(0).getKey());
    }
}