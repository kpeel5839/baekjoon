import java.util.*;

class Solution {
    
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            
            return o1[1] - o2[1];
        });
        
        int answer = 0;
        for (int i = 0; i < routes.length; i += 0) {
            int end = routes[i][1];
            
            while (++i < routes.length && routes[i][0] <= end) {
            }
            
            answer++;
        }
        
        return answer;
    }
}