import java.util.*;
import java.io.*;

// 9991 : Auto-Complete

/**
 * Example
 * 10 3
 * dab
 * ba
 * ab
 * daa
 * aa
 * aaa
 * aab
 * abc
 * ac
 * dadba
 * 4 a
 * 2 da
 * 4 da
 */
public class Main {

    public static class Word {
        int p;
        String w;

        Word(int p, String w) {
            this.p = p;
            this.w = w;
        }

        @Override
        public String toString() {
            return p + ":" + w;
        }
    }

    public static Word[] ss;

    public static int lowerBound(String s, int l, int r) {
        int idx = 0;

        while (l <= r) {
            int m = (l + r) / 2;

            if (0 <= compare(ss[m].w, s) ) {
                idx = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return idx;
    }

    public static int compare(String word, String s) {
        for (int i = 0; i < Math.min(word.length(), s.length()); i++) {
            int c = word.charAt(i) - '0';
            int cc = s.charAt(i) - '0';

            if (c != cc) {
                return c - cc;
            }
        }

        if (word.length() < s.length()) {
            return -1;
        }

        return 0;
    }

    public static boolean equals(String word, String s) {
        if (word.length() < s.length()) {
            return false;
        }

        return word.startsWith(s);
    }

    public static class Request {
        int i;
        String s;

        Request(int i, String s) {
            this.i = i;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Request request = (Request) o;
            return i == request.i && Objects.equals(s, request.s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, s);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9991_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Request, Integer> m = new HashMap<>();

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        ss = new Word[W];

        for (int i = 1; i <= W; i++) {
            ss[i - 1] = new Word(i, br.readLine());
        }

        Arrays.sort(ss, (o1, o2) -> o1.w.compareTo(o2.w));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int nn = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            Request request = new Request(nn, s);

            if (m.containsKey(request)) {
                bw.write(m.get(request) + "\n");
                continue;
            }

            int a = lowerBound(s, 0, ss.length - 1);
            a += (nn - 1);

            if (ss.length <= a || !equals(ss[a].w, s)) {
                bw.write(-1 + "\n");
                m.put(request, -1);
            } else {
                bw.write(ss[a].p + "\n");
                m.put(request, ss[a].p);
            }
        }

        bw.flush();
        bw.close();
    }
}