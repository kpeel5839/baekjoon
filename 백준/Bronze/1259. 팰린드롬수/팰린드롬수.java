import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder ans = new StringBuilder();

    while (true) {
      String s = br.readLine();
      boolean isP = true;

      if (s.equals("0")) {
        break;
      }

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        char cc = s.charAt(s.length() - 1 - i);

        if (c != cc) {
          isP = false;
          break;
        }
      }

      if (isP) {
        ans.append("yes").append("\n");
      } else {
        ans.append("no").append("\n");
      }
    }

    System.out.println(ans);
  }
}
