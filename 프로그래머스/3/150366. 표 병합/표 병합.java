import java.util.*;

class Solution {
    
    public int index = 0;
    public String[][] map;
    public int[][] group;
    public List<String> answer;
    public int H = 50;
    public int W = 50;
    
    public void init() {
        map = new String[H][W];
        group = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = "EMPTY";
                group[i][j] = ++index;
            }
        }
    }
    
    public void change(int r, int c, String s) {
        int groupNumber = group[r][c];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (groupNumber == group[i][j]) {
                    map[i][j] = s;
                }
            }
        }
    }
    
    public void allChange(String value1, String value2) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j].equals(value1)) {
                    map[i][j] = value2;
                }
            }
        }
    }
    
    public void merge(int r1, int c1, int r2, int c2) {
        // merge 할 떄에는 r1, c1, r2, c2 값을 본다.
      	String fillString = "EMPTY";
        
        if (!map[r1][c1].equals("EMPTY") && !map[r2][c2].equals("EMPTY")) {
            fillString = map[r1][c1];
        } else if (!map[r1][c1].equals("EMPTY")) {
            fillString = map[r1][c1];
        } else if (!map[r2][c2].equals("EMPTY")) {
            fillString = map[r2][c2];
        }
        
        int g1 = group[r1][c1];
        int g2 = group[r2][c2];
        int newGroupNumber = ++index;
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (group[i][j] == g1 || group[i][j] == g2) {
                    group[i][j] = newGroupNumber;
                    map[i][j] = fillString;
                }
            }
        }
    }
    
    public void unmerge(int r, int c) {
        int groupNumber = group[r][c];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (groupNumber == group[i][j] && !(i == r && j == c)) {
                    group[i][j] = ++index;
                    map[i][j] = "EMPTY";
                }
            }
        }
    }
    
    public void print() {
        for (int i = 0; i < Math.min(4, H); i++) {
            for (int j = 0; j < Math.min(4, H); j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===========");
    }
    
    public String[] solution(String[] commands) {
        init();
        answer = new ArrayList<>();
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = "EMPTY";
            }
        }
        
        for (String command : commands) {
            String[] s = command.split(" ");
            
            if (s[0].equals("UPDATE")) {
                if (s.length == 3) { // 해당 cell 에다가 집어넣음
                    allChange(s[1], s[2]);
                } else {
                    change(
                        Integer.parseInt(s[1]) - 1, 
                        Integer.parseInt(s[2]) - 1, 
                        s[3]
                    );
                }
            } else if (s[0].equals("MERGE")) {
                merge(
                    Integer.parseInt(s[1]) - 1,
                    Integer.parseInt(s[2]) - 1,
                    Integer.parseInt(s[3]) - 1,
                    Integer.parseInt(s[4]) - 1
                );
            } else if (s[0].equals("UNMERGE")) {
                unmerge(Integer.parseInt(s[1]) - 1, Integer.parseInt(s[2]) - 1);
            } else { // PRINT
                answer.add(map[Integer.parseInt(s[1]) - 1][Integer.parseInt(s[2]) - 1]);
            }
            
            // print();
        }
        
        String[] ans = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
    
}