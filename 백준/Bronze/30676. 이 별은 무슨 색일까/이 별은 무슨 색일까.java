import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(620 <= n && n <= 780) {
			System.out.println("Red");
		}else if(590 <= n && n < 620) {
			System.out.println("Orange");
		}else if(570 <= n && n < 590) {
			System.out.println("Yellow");
		}else if(495 <= n && n < 570) {
			System.out.println("Green");
		}else if(450 <= n && n < 495) {
			System.out.println("Blue");
		}else if(425 <= n && n < 450) {
			System.out.println("Indigo");
		}else if(380 <= n && n < 425) {
			System.out.println("Violet");
		}
		sc.close();
	}
}