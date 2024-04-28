import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(Character.toUpperCase(s.charAt(i)));           
        }
        System.out.println(sb);
    }
}