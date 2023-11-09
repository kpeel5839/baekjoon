import java.util.*;

class Solution {
    
    public int n;
    public int[][] s;
    public int[] max;
    public int wanho;
    
    public int binary(int l, int value) {
        int r = n - 1;
        int ans = -1;
        value += 1;
        l += 1;
        
        while (l <= r) {
            int m = (l + r) / 2;
            
            if (value <= s[m][0]) { // 기준보다 같거나 크면 게속 ans 에다가 넣고 왼쪽으로
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return ans;
    }
    
    public int solution(int[][] scores) {
        this.n = scores.length;
        this.s = new int[n][];
        this.max = new int[n + 1];
        this.wanho = scores[0][0] + scores[0][1];
        
        for (int i = 0; i < n; i++) {
            s[i] = new int[] {scores[i][0], scores[i][1], i};
        }
        
        Arrays.sort(s, (o1, o2) -> o1[0] - o2[0]);
        
        int m = 0;
        for (int i = n - 1; 0 <= i; i--) {
            m = Math.max(m, s[i][1]);
            max[i] = m;
        }
        
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int index = binary(i, s[i][0]);
            
            if (index != -1 && s[i][1] < max[index]) {
                if (s[i][2] == 0) {
                    return -1;
                }
                continue;
            } 
            
            arr.add(s[i][0] + s[i][1]);
        }
        
        Collections.sort(arr);
        
        for (int i = arr.size() - 1; 0 <= i; i--) {
            if (wanho == arr.get(i)) {
                return arr.size() - i;
            }
        }
        
        return -1;
    }
}