import java.time.LocalDate;
import java.util.*;
import java.io.*;

// 1924 : 2007년

/**
 * Example
 * 3 14
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1924_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        LocalDate day = LocalDate.of(
                2007,
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );

        System.out.println(day.getDayOfWeek().toString().substring(0, 3));
    }
}