import java.util.*;

class Solution {
    
    public Map<Integer, List<Integer>> map;
    public int[] a;
    
    public int execute(int number, List<Integer> list) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        
        for (Integer index : list) {
            int left = index - 1;
            int right = index + 1;
            
            if (0 <= left && a[left] != number && !visited.contains(left)) {
                count++;
                visited.add(left);
                continue;
            }
            
            if (right < a.length && a[right] != number && !visited.contains(right)) {
                count++;
                visited.add(right);
            }
        }
        
        return count * 2;
    }
    
    public int solution(int[] a) {
        this.map = new HashMap<>();
        this.a = a;
        int answer = 0;
        
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], new ArrayList<>());
            }
            
            map.get(a[i]).add(i);
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            answer = Math.max(answer, execute(entry.getKey(), entry.getValue()));
        }
        
        return answer;
    }
}