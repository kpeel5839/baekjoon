import java.util.*;
import java.io.*;

// 7662 : 이중 우선 순위 큐

/**
 * Example
 * 2
 * 7
 * I 16
 * I -5643
 * D -1
 * D 1
 * D 1
 * I 123
 * D -1
 * 9
 * I -45
 * I 653
 * D 1
 * I -642
 * I 45
 * I 97
 * D 1
 * D -1
 * I 333
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_7662_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> min = new PriorityQueue<>((Long::compare));
            PriorityQueue<Long> max = new PriorityQueue<>((o1, o2) -> -Long.compare(o1, o2));
            Map<Long, Integer> m = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                String oper = st.nextToken();
                Long number = Long.parseLong(st.nextToken());

                if (oper.equals("I")) {
                    min.add(number);
                    max.add(number);
                    m.put(number, m.getOrDefault(number, 0) + 1);
                } else {
                    if (number == -1) { // min
                        // m 에 있는지 확인해야함, 있으면 뽑아도 됨
                        while (!min.isEmpty()) {
                            Long poll = min.poll();

                            if (m.get(poll) <= 0) {
                                continue;
                            }

                            m.put(poll, m.get(poll) - 1);
                            break;
                        }
                    } else { // max
                        while (!max.isEmpty()) {
                            Long poll = max.poll();

                            if (m.get(poll) <= 0) {
                                continue;
                            }

                            m.put(poll, m.get(poll) - 1);
                            break;
                        }
                    }
                }
            }

            Long maxValue = null;
            Long minValue = null;

            while (!max.isEmpty()) {
                Long poll = max.poll();

                if (m.get(poll) <= 0) {
                    continue;
                }

                maxValue = poll;
                break;
            }

            while (!min.isEmpty()) {
                Long poll = min.poll();

                if (m.get(poll) <= 0) {
                    continue;
                }

                minValue = poll;
                break;
            }

            if (maxValue == null && minValue == null) {
                bw.write("EMPTY" + "\n");
            } else {
                bw.write(maxValue + " " + minValue + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}