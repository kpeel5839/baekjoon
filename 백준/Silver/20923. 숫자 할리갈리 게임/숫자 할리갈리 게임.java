import java.util.*;
import java.io.*;

// 20923 : 숫자 할리갈리 게임

/**
 * Example
 * 10 12
 * 1 2
 * 2 2
 * 1 2
 * 2 3
 * 3 1
 * 2 2
 * 2 5
 * 2 1
 * 5 1
 * 2 3
 */
public class Main {

    public static Deque<Integer>[] cards = new Deque[2];
    public static Deque<Integer>[] grounds = new Deque[2];
    public static int DO_WIN = 0;
    public static int SU_WIN = 1;
    public static int NOT_YET = 2;

    public static int winner() {
        if (!grounds[0].isEmpty() && grounds[0].peekLast() == 5) {
            return DO_WIN;
        }

        if (!grounds[1].isEmpty() && grounds[1].peekLast() == 5) {
            return DO_WIN;
        }

        if (!grounds[0].isEmpty() && !grounds[1].isEmpty() &&  grounds[0].peekLast() + grounds[1].peekLast() == 5) {
            return SU_WIN;
        }

        return NOT_YET;
    }

    public static String cardCountIsZero() {
        if (cards[0].isEmpty()) {
            return "su";
        }

        if (cards[1].isEmpty()) {
            return "do";
        }

        return "NOT_YET";
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_20923_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 2; i++) {
            cards[i] = new LinkedList<>();
            grounds[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cards[0].addLast(Integer.parseInt(st.nextToken()));
            cards[1].addLast(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            if (i % 2 == 0) {
                grounds[0].addLast(cards[0].pollLast());
            } else {
                grounds[1].addLast(cards[1].pollLast());
            }

            String whoEmpty = cardCountIsZero();

            if (!whoEmpty.equals("NOT_YET")) {
                System.out.println(whoEmpty);
                return;
            }

            int result = winner();

            if (result == DO_WIN) {
                while (!grounds[1].isEmpty()) {
                    cards[0].addFirst(grounds[1].pollFirst());
                }

                while (!grounds[0].isEmpty()) {
                    cards[0].addFirst(grounds[0].pollFirst());
                }
            }

            if (result == SU_WIN) {
                while (!grounds[0].isEmpty()) {
                    cards[1].addFirst(grounds[0].pollFirst());
                }

                while (!grounds[1].isEmpty()) {
                    cards[1].addFirst(grounds[1].pollFirst());
                }
            }
        }

        if (cards[0].size() < cards[1].size()) {
            System.out.println("su");
        } else if (cards[0].size() > cards[1].size()) {
            System.out.println("do");
        } else {
            System.out.println("dosu");
        }
    }
}