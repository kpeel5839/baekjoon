import java.util.*;

class Solution {
    
    public int H;
    public int W;
    public int[][] b;
    public int[][] t;
    
    public int parsing(int number) {
        int count = 0;
        int[][] c = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                c[i][j] = b[i][j];
            }
        }
        
        for (int i = 0; (1 << i) <= number; i++) {
            if ((number & (1 << i)) != 0) {
                count++;
                change(c, i);
            }
        }
        
        if (equal(c)) {
            return count;
        }
        
        return Integer.MAX_VALUE;
    }
    
    public void change(int[][] c, int digit) {
        if (digit < H) {
            changeRow(c, digit);
        } else {
            changeCol(c, digit - H);
        }
    }
    
    public boolean equal(int[][] c) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (c[i][j] != t[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void changeRow(int[][] c, int row) {
        for (int i = 0; i < W; i++) {
            c[row][i] = (c[row][i] + 1) % 2;
        }
    }
    
    public void changeCol(int[][] c, int col) {
        for (int i = 0; i < H; i++) {
            c[i][col] = (c[i][col] + 1) % 2;
        }
    }
    
    public int solution(int[][] beginning, int[][] target) {
        this.H = beginning.length;
        this.W = beginning[0].length;
        this.b = beginning;
        this.t = target;
        
        int total = (int) Math.pow(2, H) * (int) Math.pow(2, W);
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < total; i++) {
            answer = Math.min(answer, parsing(i));
        }
       
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}