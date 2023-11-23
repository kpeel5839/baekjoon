import java.util.*;

class Solution {
    
    public int n;
   	public int[] count;
    
    public boolean isPossible(int index) {
        for (int i = 1; i <= index + 1; i++) {
            if (count[index - i + 1] < i) {
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        this.n = A.length;
        this.count = new int[n];
        int index = n - 1;
        int l = 0;
        int r = n - 1;
        
        for (int i = n - 1; 0 <= i; i--) {
            while (0 <= index && A[i] < B[index]) {
                index--;
            }
            
            count[i] = n - 1 - index;
        }
        
        int ans = 0;
        
        while (l <= r) {
            int m = (l + r) / 2;
            
            if (isPossible(m)) {
                ans = m + 1;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return ans;
    }
}