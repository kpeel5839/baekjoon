class Solution {
    
    public int H;
    public int W;
    public int[][] b;
    public int[][] sum;
    
    public void execute(int r1, int c1, int r2, int c2, int damage) {
        sum[r1][c1] += damage;
        sum[r2 + 1][c1] -= damage;
        sum[r1][c2 + 1] -= damage;
        sum[r2 + 1][c2 + 1] += damage;
    }
    
    public void print() {
        for (int i = 0; i < H + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("===========");
    }
    
    public int solution(int[][] board, int[][] skill) {
        this.H = board.length;
        this.W = board[0].length;
        this.b = board;
        this.sum = new int[H + 1][W + 1];
        
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0] == 1 ? -1 : 1;
            execute(skill[i][1], skill[i][2], skill[i][3], skill[i][4], type * skill[i][5]);
            // print();
        }
        
        int add = 0;
        
        for (int i = 0; i < W + 1; i++) {
            int value = 0;
            for (int j = 0; j < H + 1; j++) {
                value += sum[j][i];
                sum[j][i] = value;
            }
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W + 1; j++) {
                add += sum[i][j];
                
                if (j != W) {
                    b[i][j] += add;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (0 < b[i][j]) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}