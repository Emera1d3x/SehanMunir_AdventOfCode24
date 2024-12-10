
/*
 *   Sehan Munir
 *   Day Five {2024-12-05}
 *   Print Queue
 */
import java.util.*;

public class DayFive {
  static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
    DayFive z = new DayFive();
    System.out.println("Type \"-1\" after input is done: ");
    // z.partOne();
    // z.partTwo();
  }
  // PART ONE
  static void partOne() {
    int total = 0;
    String cur;
    ArrayList<int[]> rule = new ArrayList<>();
    while (true) {
      cur = scan.nextLine();
      if (cur.equals("-1")) {
        break;
      }
      String[] parts = cur.split("\\|");
      int x = Integer.parseInt(parts[0]);
      int y = Integer.parseInt(parts[1]);
      rule.add(new int[] { x, y });
    }
    while (true) {
      cur = scan.nextLine();
      if (cur.equals("-1")) {
        break;
      }
      String[] pages = cur.split(",");
      if (isValUpd(pages, rule)) {
        total += Integer.parseInt(pages[(pages.length) / 2]);
      }
    }
    System.out.println(total);
  }
  static boolean isValUpd(String[] upd, ArrayList<int[]> rules) {
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
  // PART TWO
  static void partTwo() {
    int total = 0;
    String cur;
    ArrayList<int[]> rule = new ArrayList<>();
    while (true) {
      cur = scan.nextLine();
      if (cur.equals("-1")) {
        break;
      }
      String[] parts = cur.split("\\|");
      int x = Integer.parseInt(parts[0]);
      int y = Integer.parseInt(parts[1]);
      rule.add(new int[] { x, y });
    }
    while (true) {
      cur = scan.nextLine();
      if (cur.equals("-1")) {
        break;
      }
      String[] pages = cur.split(",");
      if (!isValUpd(pages, rule)) {
        total += orderedMid(pages, rule);
      }
    }
    System.out.println(total);
  }
  static int orderedMid(String[] upd, ArrayList<int[]> rules) {
    ArrayList<Integer> updList = new ArrayList<>();
    for (String page : upd) {
      updList.add(Integer.parseInt(page));
    }
    updList.sort((a, b) -> {
      for (int[] rule : rules) {
        int x = rule[0];
        int y = rule[1];
        if (a == x && b == y)
          return -1;
        if (a == y && b == x)
          return 1;
      }
      return 0;
    });
    return updList.get(updList.size() / 2);
  }
}
