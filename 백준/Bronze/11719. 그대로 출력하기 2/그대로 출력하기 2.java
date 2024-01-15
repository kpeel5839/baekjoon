import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s == null) {
                break;
            }

            sb.append(s).append("\n");
        }

        System.out.println(sb);
	}
}