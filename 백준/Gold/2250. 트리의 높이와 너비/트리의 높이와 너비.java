import java.util.*;
import java.io.*;
import java.util.Map.Entry;

// 2250 : 트리의 높이와 너비

/**
 * Example
 * 19
 * 1 2 3
 * 2 4 5
 * 3 6 7
 * 4 8 -1
 * 5 9 10
 * 6 11 12
 * 7 13 -1
 * 8 -1 -1
 * 9 14 15
 * 10 -1 -1
 * 11 16 -1
 * 12 -1 -1
 * 13 17 -1
 * 14 -1 -1
 * 15 18 -1
 * 16 -1 -1
 * 17 -1 19
 * 18 -1 -1
 * 19 -1 -1
 */
public class Main {

    public static int N;
    public static Map<Integer, DepthInfo> ans = new HashMap<>();
    public static Map<Integer, Tree> treeMap = new HashMap<>();
    public static Map<Integer, Integer> indexes = new HashMap<>();

    public static int getChildCount(Tree cur) {
        int leftChildCount = 0;
        int rightChildCount = 0;

        if (cur.left != null) {
            leftChildCount = getChildCount(cur.left);
        }

        if (cur.right != null) {
            rightChildCount = getChildCount(cur.right);
        }

        cur.leftChildCount = leftChildCount;
        cur.rightChildCount = rightChildCount;
        return leftChildCount + rightChildCount + 1;
    }

    public static void dfs(Tree cur, int left, int right, int depth) {
        DepthInfo depthInfo = ans.getOrDefault(depth, new DepthInfo());
        int nowIndex = left + cur.leftChildCount;
        depthInfo.set(nowIndex);
//        indexes.put(cur.value, nowIndex);
        ans.put(depth, depthInfo);

        if (cur.left != null) {
            dfs(cur.left, left, nowIndex - 1, depth + 1);
        }

        if (cur.right != null) {
            dfs(cur.right, nowIndex + 1, right, depth + 1);
        }
    }

    public static class Tree {
        int value;
        Tree left;
        Tree right;
        int leftChildCount;
        int rightChildCount;

        public Tree(int value) {
            this.value = value;
            left = null;
            right = null;
            leftChildCount = 0;
            rightChildCount = 0;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "value=" + value +
                    ", leftChildCount=" + leftChildCount +
                    ", rightChildCount=" + rightChildCount +
                    '}';
        }
    }

    public static class DepthInfo {
        int min;
        int max;

        public DepthInfo() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }

        public void set(int value) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        public int distance() {
            return max - min + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2250_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Set<Integer> root = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            treeMap.put(i, new Tree(i));
            root.add(i);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            treeMap.get(a).left = treeMap.getOrDefault(b, null);
            treeMap.get(a).right = treeMap.getOrDefault(c, null);
            boolean ignored1 = root.contains(b) ? root.remove(b) : false;
            boolean ignored2 = root.contains(c) ? root.remove(c) : false;
        }

        getChildCount(treeMap.get(new ArrayList<>(root).get(0)));
        dfs(treeMap.get(new ArrayList<>(root).get(0)), 1, N, 1);

//        for (int i = 1; i <= N; i++) {
//            System.out.println(treeMap.get(i) + ", index : " + indexes.get(i));
//        }

        int max = 0;
        int maxIndex = 0;
        List<Entry<Integer, DepthInfo>> entries = new ArrayList<>(ans.entrySet());

        Collections.sort(entries, (o1, o2) -> o1.getKey() - o2.getKey());

        for (Entry<Integer, DepthInfo> v : entries) {
            if (max < v.getValue().distance()) {
                max = v.getValue().distance();
                maxIndex = v.getKey();
            }
        }

        System.out.println(maxIndex + " " + max);
    }
}