import java.util.*;
 
public class Main {
 
    static ArrayList<Integer>[] list;
    static int n;
    static boolean[] isCycle;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        n = scan.nextInt();
 
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
 
        for(int i = 0; i < n; i++) {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            list[n1].add(n2);
            list[n2].add(n1);
        }
 
        //싸이클을 찾아 표시해준다.
        isCycle = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            if(checkCycle(i, i, i)) break;
            isCycle = new boolean[n + 1];
        }
 
        int[] result = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(!isCycle[i]) result[i] = bfs(i);
        }
 
        for(int i = 1; i <= n; i++) System.out.print(result[i] + " ");
    }
 
    public static int bfs(int node) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(new Node(node, 0));
        visited[node] = true;
 
        while(!q.isEmpty()) {
            Node current = q.poll();
            if(isCycle[current.v]) return current.count;
 
            for(int i = 0; i < list[current.v].size(); i++) {
                int next = list[current.v].get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(new Node(next, current.count + 1));
                }
            }
        }
        return 0;
    }
 
    public static boolean checkCycle(int prev, int node, int start) {
        isCycle[node] = true;
 
        for(int i = 0; i < list[node].size(); i++) {
            int next = list[node].get(i);
 
            if(!isCycle[next]) {
                if(checkCycle(node, next, start)) return true;
            } else if(next != prev && next == start) return true;
        }
        isCycle[node] = false;
        
        return false;
    }
 
    public static class Node {
        int v;
        int count;
 
        public Node(int v, int count) {
            this.v = v;
            this.count = count;
        }
    }
}
