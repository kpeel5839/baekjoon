import java.util.*;
import java.io.*;

// 11721 : 열 개씩 끊어서 출력하기

/**
 * Example
 * BaekjoonOnlineJudge
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_11721_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int count = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            ans.append(s.charAt(i));
            count++;

            if (count == 10) {
                ans.append("\n");
                count = 0;
            }
        }

        System.out.println(ans);
    }
}