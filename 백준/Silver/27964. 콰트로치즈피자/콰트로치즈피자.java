import java.util.*;
import java.io.*;

// 27964 : 콰트로 치즈 피자

/**
 * Example
 * 4
 * CheddarCheese MozzarellaCheese GoudaCheese GranaPadanoCheese
 */
public class Main {

    public static boolean isCheese(String s) {
        if (s.length() < 6) {
            return false;
        }

        return s.substring(s.length() - 6, s.length()).equals("Cheese");
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_27964_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = st.nextToken();

            if (isCheese(s)) {
                set.add(s);
            }
        }

        if (set.size() < 4) {
            System.out.println("sad");
        } else {
            System.out.println("yummy");
        }
    }
}