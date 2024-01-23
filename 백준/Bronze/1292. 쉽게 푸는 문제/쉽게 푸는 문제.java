import java.util.*;
import java.io.*;

// 1292 : 쉽게 푸는 문제

/**
 * Example
 * 3 7
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1292_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int number = 1;
        int count = 0;
        int answer = 0;

        for (int i = 1; i <= e; i++) {
            count++;

            if (s <= i) {
                answer += number;
            }

            if (number == count) {
                number++;
                count = 0;
            }
        }

        System.out.println(answer);
    }
}
