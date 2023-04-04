import java.util.*;
import java.io.*;

// 7785 : 회사에 있는 사람

/**
 * Example
 * 4
 * Baha enter
 * Askar enter
 * Baha leave
 * Artem enter
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_7785_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            if (s2.equals("enter")) {
                set.add(s1);
            } else {
                set.remove(s1);
            }
        }

        List<String> strings = new ArrayList<>(set);
        strings.sort((o1, o2) -> o2.compareTo(o1));
        for (String name : strings) {
            bw.write(name + "\n");
        }

        bw.flush();
        bw.close();
    }
}