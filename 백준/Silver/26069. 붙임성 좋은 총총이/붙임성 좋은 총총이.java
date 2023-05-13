import java.util.*;
import java.io.*;

// 26069 : 붙임성 좋은 총총이

/**
 * Example
 * 12
 * bnb2011 chansol
 * chansol chogahui05
 * chogahui05 jthis
 * jthis ChongChong
 * jthis jyheo98
 * jyheo98 lms0806
 * lms0806 pichulia
 * pichulia pjshwa
 * pjshwa r4pidstart
 * r4pidstart swoon
 * swoon tony9402
 * tony9402 bnb2011
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_26069_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>(Set.of("ChongChong"));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String s1 = st.nextToken();
            String s2 = st.nextToken();

            if (set.contains(s1) || set.contains(s2)) {
                set.add(s1);
                set.add(s2);
            }
        }

        System.out.println(set.size());
    }
}