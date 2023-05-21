import java.util.*;
import java.io.*;

// 22233 : 가희와 키워드

/**
 * Example
 * 5 2
 * map
 * set
 * dijkstra
 * floyd
 * os
 * map,dijkstra
 * map,floyd
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_22233_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Boolean> map = new HashMap<>();
        int count = N;

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), Boolean.FALSE);
        }

        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(",");

            for (int j = 0; j < split.length; j++) {
                String s = split[j];

                if (map.containsKey(s) && map.get(s) == Boolean.FALSE) {
                    count--;
                    map.put(s, Boolean.TRUE);
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}