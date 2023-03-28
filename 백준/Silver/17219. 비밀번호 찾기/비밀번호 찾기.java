import java.util.*;
import java.io.*;

// 17219 : 비밀번호 찾기

/**
 * Example
 * 16 4
 * noj.am IU
 * acmicpc.net UAENA
 * startlink.io THEKINGOD
 * google.com ZEZE
 * nate.com VOICEMAIL
 * naver.com REDQUEEN
 * daum.net MODERNTIMES
 * utube.com BLACKOUT
 * zum.com LASTFANTASY
 * dreamwiz.com RAINDROP
 * hanyang.ac.kr SOMEDAY
 * dhlottery.co.kr BOO
 * duksoo.hs.kr HAVANA
 * hanyang-u.ms.kr OBLIVIATE
 * yd.es.kr LOVEATTACK
 * mcc.hanyang.ac.kr ADREAMER
 * startlink.io
 * acmicpc.net
 * noj.am
 * mcc.hanyang.ac.kr
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17219_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> m = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            m.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            bw.write(m.get(br.readLine()) + "\n");
        }

        bw.flush();
        bw.close();
    }
}