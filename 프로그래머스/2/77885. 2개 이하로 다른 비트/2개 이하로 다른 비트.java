class Solution {
    
    public long pow(int exp) {
        long result = (long) Math.pow(2, exp);
       
        return Math.max(result, 0);
    }
    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;
        
        while (index != answer.length) {
            long number = numbers[index];
            long ans = Long.MAX_VALUE;
            long minNumber = Long.MAX_VALUE;
            
            if (number == 0 || number == 1) {
                answer[index++] = number + 1;
                continue;
            }
            
            int digit = 0;
            
            for (int i = 0; (1l << i) <= number; i++) {
                if (((1l << i) & number) != 0) {
                    digit = i;
                    minNumber = number - (1l << i);
                } else {
                    if (minNumber != Long.MAX_VALUE) {
                        ans = Math.min(ans, minNumber + (1l << i));
                    }
                    
                    ans = Math.min(ans, number + (1l << i));
                }
            }
            
            ans = Math.min(ans, number - (1l << digit) + (1l << (digit + 1)));
            answer[index++] = ans;
        }
        
        return answer;
    }
}