import java.util.*;
import java.io.*;

// 1822 : 차집합

/**
 * Example
 * 3 5
 * 2 5 4
 * 1 2 3 4 5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1822_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            set2.add(Integer.parseInt(st.nextToken()));
        }

        for (Integer v : set1) {
            if (!set2.contains(v)) {
                list.add(v);
            }
        }

        if (list.size() == 0) {
            bw.write("0");
        } else {
            list.sort((o1, o2) -> o1 - o2);
            bw.write(list.size() + "\n");
            for (Integer v : list) {
                bw.write(v + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}
