import java.util.*;
import java.io.*;

// 25497 : 기술 연계 마스터 임스
/**
 * Example
 * 5
 * S12K2
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_25497_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int cntL = 0;
        int cntS = 0;
        boolean fail = false;
        String s = br.readLine();

        for (int i = 0; !fail && (i < N); i++) {
            fail = false;
            char c = s.charAt(i);

            if (c == 'L') {
                cntL++;
            } else if (c == 'S') {
                cntS++;
            } else if (c == 'R') {
                if (cntL == 0) {
                    fail = true;
                } else {
                    ans++;
                    cntL--;
                }
            } else if (c == 'K') {
                if (cntS == 0) {
                    fail = true;
                } else {
                    ans++;
                    cntS--;
                }
            } else {
                ans++;
            }
        }

        System.out.println(ans);
    }
}