import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.List;

public class Main {
    static int N,K;
    static BigInteger max;
    static String[] arr;
    static String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ",str="";
    static Map<Character,BigInteger> dic = new HashMap<Character,BigInteger>();
    static BigInteger thirtysix = new BigInteger("36");
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new String[N];
        for (int n=0;n<N;n++){
            arr[n] = br.readLine();
        }
        K = Integer.parseInt(br.readLine());
        if (K>0){
            check(arr);
            List<Map.Entry<Character,BigInteger>> list = new LinkedList<>(dic.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character, BigInteger>>() {
                @Override
                public int compare(Map.Entry<Character, BigInteger> o1, Map.Entry<Character, BigInteger> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            int idx =0;
            for (Map.Entry<Character,BigInteger> entry:list){
                if (idx>=K){
                    break;
                } else{
                    Character c = entry.getKey();
                    str+=c;
                    idx++;
                }
            }
        }
        max = sum(arr);
        
        String answer = change36(max);
        for (int i=answer.length()-1; i>=0;i--){
            System.out.print(answer.charAt(i));
        }
    }

    public static void check(String[] arr){
        BigInteger bnum = new BigInteger("0");
        for(int n=0;n<N;n++){
            for(int j=0;j<arr[n].length();j++){
                BigInteger pow = thirtysix.pow(arr[n].length()-j-1);
                bnum = BigInteger.valueOf(35);
                bnum = bnum.multiply(pow);
                BigInteger original = pow.multiply(BigInteger.valueOf(dchar.indexOf(arr[n].charAt(j))));
                bnum = bnum.subtract(original);
                Character c = arr[n].charAt(j);
                if (!dic.containsKey(c)){
                    dic.put(c,bnum);
                } else{
                    dic.replace(c,dic.get(c).add(bnum));
                }
            }
        }
    }
    
    public static BigInteger sum(String[] arr){
        BigInteger result=new BigInteger("0");
        for(int i=0;i<N;i++){
            for(int j=0;j<arr[i].length();j++){
                String c = Character.toString(arr[i].charAt(j));
                if (str.contains(c)){
                    BigInteger pow = thirtysix.pow(arr[i].length()-j-1);
                    BigInteger num = pow.multiply(BigInteger.valueOf(35));
                    result=result.add(num);
                }else{
                    BigInteger pow = thirtysix.pow(arr[i].length()-j-1);
                    BigInteger num = pow.multiply(BigInteger.valueOf(dchar.indexOf(c)));
                    result=result.add(num);
                }
            }
        }
        return result;
    }
    
    public static String change36(BigInteger num){
        String result= "";
        BigInteger zero = new BigInteger("0");
        if (num.equals(BigInteger.valueOf(0))){
            result +="0";
        }else{
            while (num.compareTo(zero) !=0){
                result+= dchar.charAt(num.remainder(thirtysix).intValue());
                num = num.divide(thirtysix);
            }
        }
        return result;
    }
}