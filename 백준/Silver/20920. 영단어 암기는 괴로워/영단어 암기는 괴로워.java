import java.util.*;
import java.io.*;

// 20920 : 영단어 암기는 괴로워

/**
 * Example
 * 7 4
 * apple
 * ant
 * sand
 * apple
 * append
 * sand
 * sand
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_20920_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<String> ss = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (!m.containsKey(s)) {
                ss.add(s);
            }
            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        Collections.sort(ss);
        Collections.sort(ss, (o1, o2) -> o2.length() - o1.length());
        Collections.sort(ss, (o1, o2) -> m.get(o2) - m.get(o1));

        for (int i = 0; i < ss.size(); i++) {
            if (k <= ss.get(i).length()) {
                bw.write(ss.get(i) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
