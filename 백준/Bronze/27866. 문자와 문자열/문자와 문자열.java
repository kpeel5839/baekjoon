import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int index = Integer.parseInt(br.readLine()) - 1;

        System.out.println(s.charAt(index));
	}
}