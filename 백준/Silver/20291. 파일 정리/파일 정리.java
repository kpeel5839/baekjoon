import java.sql.Array;
import java.util.*;
import java.io.*;

// 20291 : 파일 정리

/**
 * Example
 * 8
 * sbrus.txt
 * spc.spc
 * acm.icpc
 * korea.icpc
 * sample.txt
 * hello.world
 * sogang.spc
 * example.txt
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_20291_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> m = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\.");
            m.put(split[1], m.getOrDefault(split[1], 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(m.entrySet());
        entries.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        StringBuilder ans = new StringBuilder();
        entries.forEach(v -> ans.append(v.getKey() + " " + v.getValue() + "\n"));
        System.out.println(ans.toString());
    }
}