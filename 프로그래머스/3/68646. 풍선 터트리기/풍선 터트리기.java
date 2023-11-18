class Solution {
    public int solution(int[] a) {
        int[] leftToRight = new int[a.length];
        int[] rightToLeft = new int[a.length];
        leftToRight[0] = a[0];
        rightToLeft[a.length - 1] = a[a.length - 1];
        int answer = 0;
        
        for (int i = 1; i < a.length; i++) {
            leftToRight[i] = Math.min(leftToRight[i - 1], a[i]);
        }
        
        for (int i = a.length - 2; 0 <= i; i--) {
            rightToLeft[i] = Math.min(rightToLeft[i + 1], a[i]);
        }
        
        for (int i = 0; i < a.length; i++) { // 나보다 작은애 둘만 아니면 됨
            int left = (i == 0 ? Integer.MAX_VALUE : leftToRight[i - 1]);
            int right = (i == a.length - 1 ? Integer.MAX_VALUE : rightToLeft[i + 1]);
            
            if (left < a[i] && right < a[i]) {
                continue;
            }
            
            answer++;
        }
        
        return answer;
    }
}