class Solution {
    
    public int n;
    public int weakCount;
   	public int[] d;
    public int[] w;
    public int answer;
    public boolean[] visited;
    
    public void dfs(int index, int count, int selectCount) {
        if (weakCount <= count) {
            answer = Math.min(answer, selectCount);
            return;
        }
        
        for (int i = 0; i < d.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int next = nextIndex(index, i);
                dfs(next, count + (next - index), selectCount + 1);
                visited[i] = false;
            }
        }
    }
    
    public int nextIndex(int index, int selectIndex) {
        int nextPosition = w[index] + d[selectIndex];
        
        for (int i = index + 1; i < w.length; i++) {
            if (nextPosition < w[i]) {
                return i;
            }
        }
       
        return 0;
    }
    
    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weakCount = weak.length;
        this.d = dist;
        this.w = new int[weakCount * 2 + 1];
        this.answer = Integer.MAX_VALUE;
        this.visited = new boolean[dist.length];
        
        for (int i = 0; i < weakCount; i++) {
            w[i] = weak[i];
        }
        
        for (int i = weakCount; i < 2 * weakCount; i++) {
            w[i] = weak[i - weakCount] + n;
        }
        
        w[w.length - 1] = Integer.MAX_VALUE;
        
        for (int i = 0; i < weakCount; i++) {
            dfs(i, 0, 0);
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}