class Solution {
    
    public int getDigit(long number) {
        int index = 1;
        
        while (true) {
            int digit = (int) Math.pow(2, index) - 1;
            long n = (long) Math.pow(2, digit);
            if (number < n) {
                return digit;
            }
            index++;
        }
    }
    
    public String binaryNumber(long number) {
        String result = "";
        int digit = getDigit(number);
        
        while (number != 0) {
            result = (number % 2l) + result;
            number /= 2l;
        }
        
        int resultLength = result.length();
        for (int j = 0; j < digit - resultLength; j++) {
            result = "0" + result;
        }
        
        return result;
    }
    
    public boolean dfs(int l, int r, String s) {
        if (l == r) {
            return true;
        }
        
        int m = (l + r) / 2;
        int c = s.charAt(m) - '0';
        
        if (c == 0) {
            for (int i = l; i <= r; i++) {
                int cc = s.charAt(i) - '0';
                if (cc == 1) {
                    return false;
                }
            }
            return true;
        }
        
        return dfs(l, m - 1, s) && dfs(m + 1, r, s);
    }
    
    public int[] solution(long[] numbers) {
        int[] ans = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String number = binaryNumber(numbers[i]);
            ans[i] = dfs(0, number.length() - 1, number) ? 1 : 0;
        }
        
        return ans;
    }
}