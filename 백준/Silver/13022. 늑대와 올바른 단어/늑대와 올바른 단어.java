import java.util.*;
import java.io.*;

// 13022 : 늑대와 올바른 단어

/**
 * Example
 * wwolfolf
 */
public class Main {

    public static class Wolf {
        char c;
        int count;

        public Wolf(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Wolf{" +
                    "c=" + c +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13022_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        List<Wolf> list = new ArrayList<>();
        char prev = '1';
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i == 0) {
                count++;
                prev = c;
                continue;
            }

            if (prev != c) {
                list.add(new Wolf(prev, count));
                prev = c;
                count = 1;
            } else {
                count++;
            }
        }

        list.add(new Wolf(prev, count));

        if (list.size() % 4 != 0) {
            System.out.println(0);
            return;
        }

        char[] cc = new char[] {'w', 'o', 'l', 'f'};
        int index = 0;
        count = 0;

        for (Wolf wolf : list) {
            if (index == 0) {
                count = wolf.count;
            }

            if (wolf.c != cc[index] || wolf.count != count) {
                System.out.println(0);
                return;
            }

            index = (index + 1) % 4;
        }

        System.out.println(1);
    }
}