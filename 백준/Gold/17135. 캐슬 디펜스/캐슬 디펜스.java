import java.util.*;
import java.io.*;

// 17135 : 캐슬 디펜스

/*
-- 전제조건
캐슬 디펜스는 성을 향해 몰려오는 적을 잡는 턴 방식의 게임이고
n번 행 바로 아래인 n + 1번행에 성기사가 있다.
근데 해당 성은 무조건 궁수를 3명을 배치할 수가 있다.
그리고 이 궁수는 같은 칸에 위치할 수 없고 , 본인이 쏠 수 있는 거리 내에 가장 가까운놈을 때린다.
근데 만약 그런넘이 여럿이라면 가장 왼쪽에 있는놈을 때린다.

그리고 적이 성까지 내려오면 걔는 게임에서 제외된다.
이 때 제거할 수 있는 적이 게임 오버까지 몇마리 제거 가능한가?
-- 틀 설계
일단 map 배열을 만든다.
down 함수를 만들어서 적들을 1칸 전진하는 함수를 만든다.
dfs를 이용해서 궁수를 3명을 배치하도록 하고 그 archer 배열을 만들어서 위치를 관리한다.
1차원 배열로 관리해서 , [0 , 2 , 4] 라고 하면 얘내들은 그냥 (n - 1 , 0) (n - 1 , 2) ... 이렇게 관리한다.
그 다음에 거리를 계산하는데 그냥 d + 1 을 해주면 가능한 위치가 나온다. 그래서 궁수 3명을 다 그렇게 계산한다.
그러고서 적을 제거하고 (동시에 공격한다는 점이 중요하다)
check() 를 해준다. (게임이 끝났는지 안끝났는지 , 그리고 궁수가 공격할 때 ans++를 해주어야 함)
그러고서 게임이 끝나면 답을 출력한다.

-- 해맸던 점
5 5 5
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
 */
public class Main {
    public static int[][] map , useMap;
    public static int[] archer = new int[3];
    public static int[] alreadyAssign;
    public static int w , h , d , ans = 0 , max = 0;
    public static Queue<Point> queue;
    public static class Point{
        int y;
        int x;
        public Point(int y , int x){
            this.y = y;
            this.x = x;
        }
    }
    public static boolean check(){
        /*
        더 이상 map에 1이 존재하지 않는지 확인
         */
        for(int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (useMap[i][j] == 1) return false;
            }
        }
        return true;
    }
    public static void gameStart(){
        /*
        dfs에서 gameStart를 호출하고
        얘는 이것을 반복해야함 while(true) 로 해주고
        계속 attack() , down() , check() 를 반복해야함

         */
        max = 0;
        useMap = new int[h][w];

        for(int i = 0; i < h; i++){
            System.arraycopy(map[i] , 0 , useMap[i] , 0 , map[i].length);
        }

        while(true){
            attack();
//            mapPrint();
            down();
//            mapPrint();
            if(check()) break;
        }

        ans = Math.max(ans , max);
    }
    public static void mapPrint(){
        System.out.println("------next--------");
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(useMap[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void attack(){
        /*
        궁수의 위치로 현재 map의 제거할 수 있는 놈들을 찾아서 가장 최적의 적을
        queue 에다가 집어넣는다.
        archer 3명을 그것을 반복해서 queue 에다가 집어넣고 , queue 에 있는
        것들을 0으로 만든다 , 근데 queue 에 있는 것을 지울 때 map[point.y][point.x]가
        0이라면 ans++ 을 하지는 않는다.
         */
        queue = new LinkedList<>();
        for(int i = 0; i < 3; i++){ // 궁수 3명으로
            Point archerPoint = new Point(h - 1 , archer[i]);
            int min = Integer.MAX_VALUE;
            Point result = null;
            for(int j = 0; j < w; j++){
                for(int c = 0; c < h; c++){ //c가 행이다 , 위에서 아래로 내려오는 식으로 루프를 구성하여서 , x가 작은 값 순으로 탐색이 되게 list의 첫번째 인덱스가 가장 작으면서 x 값도 작도록 설정
                    if(useMap[c][j] == 1) {
                        int distance = Math.abs(archerPoint.y - c) + Math.abs(archerPoint.x - j);
                        if (distance > d) continue;
                        if (min > distance) {
//                            System.out.println(" y : " + c + " x: " + j);
                            min = distance;
                            result = new Point(c, j);
                        }
                    }
                }
            }
//            System.out.println("result y : " + result.y + " x : " + result.x + " min distance : " + min);
            queue.add(result);
        }

        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(point == null) continue;
            if(useMap[point.y][point.x] == 1){
                max++;
                useMap[point.y][point.x] = 0;
            }
        }
    }
    public static void down(){
        /*
        적들을 한칸씩 내려준다 즉 , 행들을 다 올려준다.
        그래서 queue에다가 다 담은 다음에 다시 map을 선언해서
        다시 그려준다.
         */
        queue = new LinkedList<>();

//        mapPrint(map);

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(useMap[i][j] == 1) queue.add(new Point(i , j));
            }
        }

        useMap = new int[h][w];

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if(point.y + 1 != h) { // point.y 에다가 + 1 을 하였을 때 h와 동일해지지 않는 것들만 실행 , 아니면 범위를 벗어나는 것이니까
                useMap[point.y + 1][point.x] = 1;
            }
        } //이러면 down 끝

//        mapPrint(map);
    }
    public static void dfs(int depth){
        /*
        궁수의 위치를 정해서 gameStart를 한다.
         */
        if(depth == 3){
//            System.out.println(Arrays.toString(archer));
            gameStart();
            return;
        }

        for(int i = 0; i < w; i++){// depth 가 1 이상이라면 archer[depth - 1] 보다 archer의 위치가 커야한다.
            if(depth == 0 || (alreadyAssign[i] == 0 && archer[depth - 1] < i)) {
                archer[depth] = i;
                alreadyAssign[i] = 1; // 사용처리
                dfs(depth + 1);
                alreadyAssign[i] = 0; // 복구
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()) - 1; // 그냥 궁수가 n - 1 행에 있다고 가정하기 때문에 그냥 distance 를 낮춘다.

        map = new int[h][w];
        alreadyAssign = new int[w];
        for(int i = 0; i < h; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < w; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(ans);
    }
}
