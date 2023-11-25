import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int length = w * 2 + 1;
        
        for (int i = 0; i < stations.length; i++) {
            if (i == 0) {
                answer += Math.max(0, ceil((stations[i] - w - 1), length));
            } else {
                answer += Math.max(0, ceil((stations[i] - w - (stations[i - 1] + w) - 1), length)); 
            }
        }
        answer += Math.max(0, ceil((n - (stations[stations.length - 1] + w)), length));
        return answer;
    }
    
    public int ceil(int number, int length) {
        if (number < 0) {
            return 0;
        }
        
        if (number % length == 0) {
            return number / length;
        }
        
        return (number / length) + 1;
    }
                                   
}