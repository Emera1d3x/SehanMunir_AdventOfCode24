/*
 *   Sehan Munir
 *   Day Five {2024-12-05}
 *   Print Queue
 */
import java.io.*;
import java.util.*;

public class DayFive {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static boolean isValidUpdate(String[] upd, ArrayList<int[]> rules) {
    HashMap<Integer, Integer> positions = new HashMap<>();
    for (int i = 0; i < upd.length; i++) {
        positions.put(Integer.parseInt(upd[i]), i);
    }
    for (int[] rule : rules) {
        int x = rule[0], y = rule[1];
        if (positions.containsKey(x) && positions.containsKey(y)) {
            if (positions.get(x) >= positions.get(y)) {
                return false;
            }
        }
    }
    return true;
  }
  static int orderedReturnMiddle(String[] upd, ArrayList<int[]> rules) {
    ArrayList<Integer> updList = new ArrayList<>();
    for (String page : upd) {
        updList.add(Integer.parseInt(page));
    }
    updList.sort((a, b) -> {
        for (int[] rule : rules) {
            int x = rule[0];
            int y = rule[1];
            if (a == x && b == y) return -1;
            if (a == y && b == x) return 1;
        }
        return 0;
    });
    return updList.get(updList.size() / 2);
  }
  public static void main(String[] args) throws IOException {
    DayFive z = new DayFive();
    // Actual Code Part One
    /*
      int total = 0;
      String cur;
      ArrayList<int[]> rule = new ArrayList<>();
      while (true){
        cur = z.readLine();
        if (cur.equals("-1")){
            break;
        }
        String[] parts = cur.split("\\|");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        rule.add(new int[]{x, y});
      }
      while (true){
        cur = z.readLine();
        if (cur.equals("-1")){
            break;
        }
        boolean checker;
        String[] pages = cur.split(",");
        if (z.isValidUpdate(pages, rule)) {
            total += Integer.parseInt(pages[(pages.length)/2]);
        }
      }
      System.out.println(total);
    */
    // Actual Code Part Two
    /*
    int total = 0;
    String cur;
    ArrayList<int[]> rule = new ArrayList<>();
    while (true){
      cur = z.readLine();
      if (cur.equals("-1")){
          break;
      }
      String[] parts = cur.split("\\|");
      int x = Integer.parseInt(parts[0]);
      int y = Integer.parseInt(parts[1]);
      rule.add(new int[]{x, y});
    }
    while (true){
      cur = z.readLine();
      if (cur.equals("-1")){
          break;
      }
      boolean checker;
      String[] pages = cur.split(",");
      if (!z.isValidUpdate(pages, rule)) {
          total += z.orderedReturnMiddle(pages,rule);
      }
    }
    System.out.println(total);
    */
  }
  static String next() throws IOException {
    while (st == null || !st.hasMoreTokens())
      st = new StringTokenizer(br.readLine().trim());
    return st.nextToken();
  }
  static long readLong() throws IOException {return Long.parseLong(next());}
  static int readInt() throws IOException {return Integer.parseInt(next());}
  static double readDouble() throws IOException {return Double.parseDouble(next());}
  static char readCharacter() throws IOException {return next().charAt(0);}
  static String readLine() throws IOException {return br.readLine().trim();}
}