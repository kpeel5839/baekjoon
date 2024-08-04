import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int x, y, d, t;

    double distFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
    }

    double time() {
        double dist = distFromOrigin();
        if (t >= d) return dist;
        int jump = (int) Math.floor(dist / d);
        double time;
        if (jump == 0) {
            time = t + (d - dist);
            if (2 * t < time) time = 2 * t;
            if (dist < time) time = dist;
            return time;
        }
        time = t * jump + (dist - d * jump);
        if (t * (jump + 1) < time)
            time = t * (jump + 1);
        return time;
    }

    void solution() throws IOException {
        input();
        System.out.println(time());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
