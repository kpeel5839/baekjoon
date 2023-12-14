import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int number= input.nextInt();
        int temp_number=number;
        int start = number / 5;
        int five_Count;
        int three_Count;
        double min = 5000000000.0;
        for(int i = start; i+1 != 0; i--){
            temp_number = number;
            temp_number -= i*5;
            five_Count = i;
            if(temp_number % 3 == 0) {
                three_Count=temp_number / 3;
                if(min >= five_Count + three_Count){
                    min = five_Count + three_Count;
                }
            }
        }
        if(min == 5000000000.0){
            System.out.println(-1);
        }
        else{
            System.out.println((int)min);
        }
    }
}