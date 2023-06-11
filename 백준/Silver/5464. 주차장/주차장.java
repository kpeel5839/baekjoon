import java.util.*;
import java.io.*;

// 5464 : 주차장

/**
 * Example
 * 3 4
 * 2
 * 3
 * 5
 * 200
 * 100
 * 300
 * 800
 * 3
 * 2
 * -3
 * 1
 * 4
 * -4
 * -2
 * -1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_5464_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] park = new int[N];
        int[] car = new int[M];
        int[] insideCar = new int[M];
        Queue<Integer> carQ = new LinkedList<>();
        PriorityQueue<Integer> parkQ = new PriorityQueue<>();
        int ans = 0;

        for (int i = 0; i < N; i++) {
            park[i] = Integer.parseInt(br.readLine());
            parkQ.add(i);
        }

        for (int i = 0; i < M; i++) {
            car[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2 * M; i++) {
            int carNumber = Integer.parseInt(br.readLine());

            if (carNumber < 0) {
                carNumber = (carNumber * -1) - 1;
                parkQ.add(insideCar[carNumber]);

                if (!carQ.isEmpty()) {
                    int insideCarNumber = carQ.poll();
                    int parkNumber = parkQ.poll();
                    ans += (park[parkNumber] * car[insideCarNumber]);
                    insideCar[insideCarNumber] = parkNumber;
                }
            } else {
                carNumber = carNumber - 1;
                carQ.add(carNumber);

                if (!parkQ.isEmpty()) {
                    int insideCarNumber = carQ.poll();
                    int parkNumber = parkQ.poll();
                    ans += (park[parkNumber] * car[insideCarNumber]);
                    insideCar[insideCarNumber] = parkNumber;
                }
            }
        }

        System.out.println(ans);
    }
}