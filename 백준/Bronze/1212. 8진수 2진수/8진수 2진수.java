import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int len = s.length();
        if(s.equals("0") && len == 1) bw.write("0");
        else {
            for(int i = 0; i < len; i++){
                if(i == 0) bw.write(first(s.charAt(i))); //맨 앞 자리
                else bw.write(change(s.charAt(i)));
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
    
    public static String change(char a) {
        String result;
        switch(a){
            case '0': result="000"; break;
            case '1': result="001"; break;
            case '2': result="010"; break;
            case '3': result="011"; break;
            case '4': result="100"; break;
            case '5': result="101"; break;
            case '6': result="110"; break;
            default: result="111";
        }
        return result;
    }

    public static String first(char a) {
        String result;
        switch(a){
            case '1': result="1"; break;
            case '2': result="10"; break;
            case '3': result="11"; break;
            case '4': result="100"; break;
            case '5': result="101"; break;
            case '6': result="110"; break;
            default: result="111";
        }
        return result;
    }
}