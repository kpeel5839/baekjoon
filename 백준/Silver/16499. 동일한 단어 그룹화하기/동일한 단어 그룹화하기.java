import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// 16499 : 동일한 단어 그룹화하기

/**
 * Example 4 cat dog god tca
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream(
                //"/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16499_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<List<Character>> list = new ArrayList<>();
        int ans = 0;

        Loop:
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            List<Character> cList = new ArrayList<>();
            for (char cc : c) {
                cList.add(cc);
            }
            Collections.sort(cList);

            for (List<Character> ll : list) {
                if (ll.size() != cList.size()) {
                    continue;
                }

                boolean equals = true;

                for (int j = 0; j < ll.size(); j++) {
                    if (!Objects.equals(ll.get(j), cList.get(j))) {
                        equals = false;
                        break;
                    }
                }

                if (equals) {
                    continue Loop;
                }
            }

            list.add(cList);
            ans++;
        }

        System.out.println(ans);
    }
}