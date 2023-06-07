import java.util.*;
import java.io.*;

// 17225 : 세훈이의 선물 가게

/**
 * Example
 * 0 0 3
 * 1 B 3
 * 4 R 2
 * 7 R 2
 */
public class Main {
    public static class Gift {

        String color;
        int time;

        public Gift(final String color, final int time) {
            this.color = color;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Gift{" +
                    "color='" + color + '\'' +
                    ", time=" + time +
                    '}';
        }

    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17225_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> index = Map.of("B", 0, "R", 1);
        int[] time = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int N = Integer.parseInt(st.nextToken());
        List<Gift> list = new ArrayList<>();
        List<ArrayList<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            answer.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            String color = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                list.add(new Gift(color, t + (j * time[index.get(color)])));
            }
        }

        list.sort((o1, o2) -> o1.time - o2.time);

        for (int i = 0; i < list.size(); i++) {
            Gift gift = list.get(i);
            answer.get(index.get(gift.color)).add(i + 1);
        }

        for (int i = 0; i < 2; i++) {
            bw.write(answer.get(i).size() + "\n");

            for (Integer v : answer.get(i)) {
                bw.write(v + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
