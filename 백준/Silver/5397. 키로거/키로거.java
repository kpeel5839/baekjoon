import java.util.*;
import java.io.*;

// 5397 : 키로거

/**
 * 2
 * <<BP<A>>Cd-
 * ThIsIsS3Cr3t
 */
public class Main {
    static class Node {
        char v;
        Node n;
        Node p;

        Node(char v) {
            this.v = v;
            this.n = null;
            this.p = null;
        }

        void insert(char c) {
            Node node = new Node(c);
            Node pNode = this.p;

            node.n = this;
            node.p = pNode;
            this.p = node;

            if (pNode != null) {
                pNode.n = node;
            }
        }

        void delete() {
            Node pNode = this.p;
            Node ppNode = null;

            if (pNode != null) {
                ppNode = pNode.p;
                this.p = ppNode;
            }

            if (ppNode != null) {
                ppNode.n = this;
            }
        }

        Node pre() {
            if (this.p != null) {
                return this.p;
            }

            return this;
        }

        Node next() {
            if (this.n != null) {
                return this.n;
            }

            return this;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_5397_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Node c = new Node('-');
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                char cc = s.charAt(i);

                if (cc == '<') {
                    c = c.pre();
                } else if (cc == '>') {
                    c = c.next();
                } else if (cc == '-') {
                    c.delete();
                } else {
                    c.insert(cc);
                }
            }

            while (c.p != null) {
                c = c.pre();
            }

            StringBuilder sb = new StringBuilder();

            while (c.n != null) {
                sb.append(c.v);
                c = c.next();
            }

            System.out.println(sb);
        }

    }
}