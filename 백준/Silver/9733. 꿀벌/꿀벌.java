import java.util.*;
import java.io.*;
import java.util.Map.Entry;

// 9733 : 꿀벌

/**
 * Example
 * Cc Pt Pt Re Tb Re Cm Cm Re Pt Pt Re Ea Ea Pt Pt
 * Pt Re Re Cb Cb Pt Pt Cb
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9733_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(Map.of(
                "Re", 0,
                "Pt", 0,
                "Cc", 0,
                "Ea", 0,
                "Tb", 0,
                "Cm", 0,
                "Ex", 0
        ));
        String[] strings = new String[] {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};

        int total = 0;

        while (true) {
            String s = br.readLine();

            if (s == null) {
                break;
            }

            st = new StringTokenizer(s);

            while (st.hasMoreTokens()) {
                String work = st.nextToken();

                if (map.containsKey(work)) {
                    map.put(work, map.get(work) + 1);
                }

                total++;
            }
        }

        for (int i = 0; i < strings.length; i++) {
            Integer integer = map.get(strings[i]);

            System.out.println(strings[i] + " " + integer + " " + String.format("%.2f", (double) integer / (double) total));
        }

        System.out.println("Total " + total + " 1.00");
    }
}