import java.util.*;
import java.io.*;

// 3186 : 소변기

/**
 * Example
 * 1 1 3
 * 101
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_3186_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int goal = K - 1; // 목표시간을 계속해서 갱신, 해당 목표시간에 도달하면 현재 상태를 반대로 만들어줘야함
        boolean status = false; // false 인 경우는 소변기가 사용중이지 않은 상태

        // 3 2 -> 3 초 동안 소변기 앞에 사용자가 서 있으면 사용중
        // 2 초 동안 소변기 앞에 사용자가 없으면 플러쉬
        char[] c = br.readLine().toCharArray();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) { // 1
            // 011101001101110001
            if (status && c[i] == '1') { // 소변기가 사용중인 경우
                goal = i + L;
            }

            if (!status && c[i] == '0') { // 소변기가 사용중이지 않은 경우
                goal = i + K;
            }

            if (!status && i == goal) { // 소변기가 사용중이지 않으면서 내가 연속적으로 점유하고 있는 시간이 목표시간에 다다랐을 때
                status = true; // 소변기가 사용중인 상태로 만들어줘야 됨
                goal += L; // goal 에 L 만큼 더해주면서 소변기가 사용중이지 않은 상태로 가는 시간을 결정
            }

            if (status && i == goal) { // 소변기가 사용중인 상태에서 사용중이지 않은 상태로 바뀌는 경우
                status = false;
                goal += K; // 그래서 골 시간이 K 만큼 늘어남 (K 만큼 사람이 앞에 서 있어야함)
                ans.add(i + 1); // 그러면서 소변기가 사용중에서 사용 x 로 바뀌었으니까 ans 에다가 더해줌
            }
        }

        if (status) {
            ans.add(goal + 1);
        }

        StringBuilder sb = new StringBuilder();
        if (ans.isEmpty()) {
            sb.append("NIKAD").append("\n");
        } else {
            for (int i = 0; i < ans.size(); i++) {
                sb.append(ans.get(i)).append("\n");
            }
        }

        System.out.println(sb);
    }

}