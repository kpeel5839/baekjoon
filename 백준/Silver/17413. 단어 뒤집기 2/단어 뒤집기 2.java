import javax.swing.plaf.synth.SynthMenuBarUI;
import java.util.*;
import java.io.*;

// 17413 : 단어 뒤집기

/**
 * Example
 * <int><max>2147483647<long long><max>9223372036854775807
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17413_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine() + " ";
        StringBuilder sb = new StringBuilder();
        boolean is = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!is && c == ' ') {
                bw.write(sb.reverse() + " ");
                sb = new StringBuilder();
            } else if (c == '<') {
                bw.write(sb.reverse() + "");
                sb = new StringBuilder();
                is = true;
            } else if (c == '>') {
                bw.write("<" + sb + ">");
                sb = new StringBuilder();
                is = false;
            } else {
                sb.append(c);
            }
        }

        bw.flush();
        bw.close();
    }
}