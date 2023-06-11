import java.util.*;
import java.io.*;

// 9575 : 행운의 수
/**
 * Example
 * 2
 * 6
 * 100 1 10 100 1 1
 * 7
 * 3 53 53 53 53 53 53
 * 6
 * 4 54 4 54 4 54
 * 1
 * 47
 * 1
 * 500
 * 1
 * 33
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9575_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int aCount = Integer.parseInt(br.readLine());
            int[] a = new int[aCount];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < aCount; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int bCount = Integer.parseInt(br.readLine());
            int[] b = new int[bCount];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < bCount; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int cCount = Integer.parseInt(br.readLine());
            int[] c = new int[cCount];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cCount; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }

            Set<String> set = new HashSet<>();
            for (int i = 0; i < aCount; i++) {
                for (int j = 0; j < bCount; j++) {
                    for (int k = 0; k < cCount; k++) {
                        String result = Integer.toString(a[i] + b[j] + c[k]);
                        boolean isGood = true;

                        for (int cc = 0; cc < result.length(); cc++) {
                            char ccc = result.charAt(cc);
                            if (ccc != '8' && ccc != '5') {
                                isGood = false;
                            }
                        }

                        if (isGood) {
                            set.add(result);
                        }
                    }
                }
            }

            bw.write(set.size() + "\n");
        }

        bw.flush();
        bw.close();
    }
}