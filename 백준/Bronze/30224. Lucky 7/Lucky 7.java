import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(bf.readLine());
		
		if(check(num)) { // 7이 포함된다면
			if(num % 7 != 0) { // 7로 나뉘지 않는다면
				bw.write(2 + "\n");
			} else { // 나뉜다면
				bw.write(3 + "\n");
			}
		} else { // 포함 안된다면
			if(num % 7 != 0) {
				bw.write(0 + "\n");
			} else {
				bw.write(1 + "\n");
			}
		}


		bw.flush();
		bw.close();

	}
	
	public static boolean check(int num) {
		return Integer.toString(num).contains("7");
	} // 숫자 -> 문자열 변환 뒤, 7 포함 여부를 반환

}