import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		if(h == 9) {
			System.out.println(m);
		}else {
			System.out.println((h - 9) * 60 + m);
		}
		sc.close();
	}
}