import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);        
        int h=scanner.nextInt();
        int w=scanner.nextInt();
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}