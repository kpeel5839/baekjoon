import java.util.*;
import java.io.*;

public class Main {
    public static char[][] tempCube = new char[6][9] , cube = new char[6][9];
    public static int[] insLen;
    public static String[] insStr;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(input.readLine());
        insLen = new int[n];
        insStr = new String[n]; //지시들 다 크기 만들어놓고

        for(int i =0; i < n; i++){
            insLen[i] = Integer.parseInt(input.readLine());
            insStr[i] = input.readLine();
        }

        init();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(insStr[i]);
            for(int j = 0; j < insLen[i]; j++){
                String instructString = st.nextToken();
                instruct(instructString.charAt(0) , instructString.charAt(1) == '-' ? -1 : 1);
            }//한 테스트 케이스 끝낸 것
            for(int j = 0; j < 9; j++){
                output.write(cube[1][j]);
                if(j % 3 == 2){
                    output.write("\n");
                }
            }
            init();
        }
        output.flush();
        output.close();
    }

    public static void instruct(char face , int dir){
        if(face == 'U'){
            roll(1 , new int[]{0 , 2 , 1 , 0} , new int[]{5 , 0 , 3 , 6} , new int[]{2 , 2 , 1 , 0} , new int[]{4 , 8 , 5 , 2} , dir);
        }
        else if(face == 'D'){
            roll(3 , new int[]{0 , 6 , 7 , 8} , new int[]{4 , 0 , 3 , 6} , new int[]{2 , 6 , 7 , 8} , new int[]{5 , 8 , 5 , 2} , dir);
        }
        else if(face == 'B'){
            roll(0 , new int[]{1 , 0 , 1 , 2} , new int[]{4 , 0 , 1 , 2} , new int[]{3 , 0 , 1 , 2} , new int[]{5 , 0 , 1 , 2} , dir);
        }
        else if(face == 'F'){
            roll(2 , new int[]{1 , 6 , 7 , 8} , new int[]{5 , 6 , 7 , 8} , new int[]{3 , 6 , 7 , 8} , new int[]{4 , 6 , 7 , 8} , dir);
        }
        else if(face == 'L'){
            roll(4 , new int[]{0 , 8 , 5 , 2} , new int[]{1 , 0 , 3 , 6} , new int[]{2 , 0 , 3 , 6} , new int[]{3 , 8 , 5 , 2} , dir);
        }
        else if(face == 'R'){
            roll(5 , new int[]{0 , 0 , 3 , 6} , new int[]{3 , 0 , 3 , 6} , new int[]{2 , 8 , 5 , 2} , new int[]{1 , 8 , 5 , 2} , dir);
        }
        copy();
    }

    public static void roll(int mainFace , int[] fi , int[] se , int[] th , int[] fo , int dir){
        int[] side = new int[4];
        int[][] sector = new int[4][3];
        side[0] = fi[0];
        side[1] = se[0];
        side[2] = th[0];
        side[3] = fo[0];
        for(int i = 0; i < 3; i++){
            sector[0][i] = fi[i + 1];
            sector[1][i] = se[i + 1];
            sector[2][i] = th[i + 1];
            sector[3][i] = fo[i + 1];
        } //전처리 완료
        int end = (dir == 1) ? 9 : -1;
        int start = (dir == 1) ? 6 : 2;
        int index = 0;

        for(int i = start; i != end; i+= dir){ //메인 부분 돌리는 거 완료
            int innerIndex = i;
            for(int j = 0; j < 3; j++){
                cube[mainFace][index++] = tempCube[mainFace][innerIndex];
                innerIndex += -3 * dir;
            }
        }
        //이제 사이드만 돌리면 됨
        for(int i = 0; i < 3; i++){
            cube[side[((0 + dir) % 4) < 0 ? 3 : (0 + dir) % 4]][sector[((0 + dir) % 4) < 0 ? 3 : (0 + dir) % 4][i]] = tempCube[side[0]][sector[0][i]];
            cube[side[((1 + dir) % 4) < 0 ? 3 : (1 + dir) % 4]][sector[((1 + dir) % 4) < 0 ? 3 : (1 + dir) % 4][i]] = tempCube[side[1]][sector[1][i]];
            cube[side[((2 + dir) % 4) < 0 ? 3 : (2 + dir) % 4]][sector[((2 + dir) % 4) < 0 ? 3 : (2 + dir) % 4][i]] = tempCube[side[2]][sector[2][i]];
            cube[side[((3 + dir)) % 4 < 0 ? 3 : (3 + dir) % 4]][sector[((3 + dir) % 4) < 0 ? 3 : (3 + dir) % 4][i]] = tempCube[side[3]][sector[3][i]];
        }

    }
    public static void copy(){ //이거는 그거이다
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 9; j++){
                tempCube[i][j] = cube[i][j];
            }
        }
    }
    public static void init(){
        for(int i =0; i < 6; i++){
            for(int j = 0; j < 9; j++){
                if(i == 0){cube[i][j] = 'o';}
                else if(i == 1){cube[i][j] = 'w';}
                else if(i == 2){cube[i][j] = 'r';}
                else if(i == 3){cube[i][j] = 'y';}
                else if(i == 4){cube[i][j] = 'g';}
                else if(i == 5){cube[i][j] = 'b';}
                tempCube[i][j] = cube[i][j];
            }
        }
    }
}