class Solution {
    
    public long sliding(int[] arr) {
        // 현재 left ~ right 까지 더해줄건데
        // 이 더한 값이 음수인 가정하에 계속해서 left 를 증가시켜줌
        long ans = 0;
        long sum = 0;
        int left = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans = Math.max(ans, sum);
            
            if (sum <= 0) {
                left = i + 1;
                sum = 0;
            } 
        }
        
        return ans;
    }
        
    public long solution(int[] sequence) {
        int[] arr1 = new int[sequence.length];
       	int[] arr2 = new int[sequence.length];
        
        for (int i = 0; i < sequence.length; i++) {
            arr1[i] = sequence[i] * (i % 2 == 0 ? 1 : -1);
            arr2[i] = sequence[i] * (i % 2 == 0 ? -1 : 1);
        } // 펄스 수열을 구함
        
        return Math.max(sliding(arr1), sliding(arr2));
    }
}