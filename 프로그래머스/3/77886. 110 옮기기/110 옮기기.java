import java.util.*;

class Solution {
    
    public String execute(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int sixCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i) - '0');
            
            while (isGood(stack)) {
                sixCount++;
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        sb = sb.reverse();
        StringBuilder ans = new StringBuilder();
        int zeroCount = 0;
        int lastZeroIndex = 0;
        int firstThreeOneIndex = -1;
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                zeroCount++;
               	lastZeroIndex = i;
            }
        }
        
        if (zeroCount == 0) {
            ans.append("110".repeat(sixCount)).append(sb);
            return ans.toString();
        }
        
        // 111이 없다면 ?? 가장 마지막에 발견된 0 뒤에다가 넣는다.
        // 111이 있다면 ?? 111 앞에 집어넣는다.
        for (int i = 0; i + 2 < sb.length(); i++) {
            String ss = "";
            for (int j = 0; j < 3; j++) {
                ss += sb.charAt(i + j);
            }
            if (ss.equals("111")) {
                firstThreeOneIndex = i;
                break;
            }
        }
        
        if (firstThreeOneIndex != -1) {
            for (int i = 0; i < firstThreeOneIndex; i++) {
                ans.append(sb.charAt(i));
            }
            
            ans.append("110".repeat(sixCount));
            
            for (int i = firstThreeOneIndex; i < sb.length(); i++) {
                ans.append(sb.charAt(i));
            }
            
            return ans.toString();
        }
        
        for (int i = 0; i <= lastZeroIndex; i++) {
            ans.append(sb.charAt(i));
        }
        
        ans.append("110".repeat(sixCount));
        
        for (int i = lastZeroIndex + 1; i < sb.length(); i++) {
            ans.append(sb.charAt(i));
        }
        
        return ans.toString();
    }
    
    public boolean isGood(Stack<Integer> stack) {
        if (stack.size() < 3) {
            return false;
        }
        
        String s = "";
        for (int i = 0; i < 3; i++) {
            s = stack.pop() + s;
        }
        
        if (s.equals("110")) {
            return true;
        }
        
        for (int i = 0; i < 3; i++) {
            stack.push(s.charAt(i) - '0');
        }
        
        return false;
    }
    
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            answer[i] = execute(s[i]);
        }
        return answer;
    }
    
}