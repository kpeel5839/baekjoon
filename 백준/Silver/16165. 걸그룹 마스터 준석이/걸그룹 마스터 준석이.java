import javax.swing.text.StyleContext;
import java.util.*;
import java.io.*;

// 16165 : 걸그룹 마스터 준석이

/**
 * Example
 * 3 4
 * twice
 * 9
 * jihyo
 * dahyeon
 * mina
 * momo
 * chaeyoung
 * jeongyeon
 * tzuyu
 * sana
 * nayeon
 * blackpink
 * 4
 * jisu
 * lisa
 * rose
 * jenny
 * redvelvet
 * 5
 * wendy
 * irene
 * seulgi
 * yeri
 * joy
 * sana
 * 1
 * wendy
 * 1
 * twice
 * 0
 * rose
 * 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16165_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, List<String>> m = new HashMap<>();
        Map<String, String> mm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int a = Integer.parseInt(br.readLine());
            m.put(s, new ArrayList<>());

            for (int j = 0; j < a; j++) {
                String ss = br.readLine();
                m.get(s).add(ss);
                mm.put(ss, s);
            }
        }

        for (String key :m.keySet()) {
            List<String> strings = m.get(key);
            Collections.sort(strings);
            m.put(key, strings);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            int o = Integer.parseInt(br.readLine());

            if (o == 0) {
                for (String string : m.get(s)) {
                    bw.write(string + "\n");
                }
            } else {
                bw.write(mm.get(s) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}