import java.util.*;
import java.io.*;

// 2910 : 빈도 정렬

/**
 * Example
 * 5 2
 * 2 1 2 1 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2910_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> m = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int i1 = Integer.parseInt(st.nextToken());
            m.put(i1, m.getOrDefault(i1, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(m.entrySet());
        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            for (int i = 0; i < entry.getValue(); i++) {
                bw.write(entry.getKey() + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}