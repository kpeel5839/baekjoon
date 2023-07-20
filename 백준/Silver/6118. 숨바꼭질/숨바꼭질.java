import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<Integer> list[];
    static boolean isVisited[];
    static int destination,distance,cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //헛간의 개수
        M = Integer.parseInt(st.nextToken()); //M개의 양방향 길

       list = new ArrayList[N+1];
       isVisited = new boolean[N+1];

        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }
        
        bfs();
        System.out.println(destination+" "+distance+" "+cnt);
    }

    private static void bfs() {
        Queue<int []> q = new LinkedList<>();
        isVisited[1] = true;
        q.offer(new int[]{1,0});

        while(!q.isEmpty()){
            int arr[] = q.poll();
            int now = arr[0];
            int next = arr[1];

            if(next > distance){
                distance = next;
                destination = now;
                cnt = 1;
            }
            else if(next == distance){
                if(destination > now) destination = now;
                cnt++;
            }

            for(int i=0;i<list[now].size();i++){
                int next_next = list[now].get(i);
                if(!isVisited[next_next]){
                    isVisited[next_next] = true;
                    q.offer(new int[]{next_next,next+1});
                }
            }
        }
    }

}