/*
 *   Sehan Munir
 *   Day Four {2024-12-04}
 *   Ceres Search
 */
import java.util.*;

public class DayFour {
  static Scanner scan = new Scanner(System.in);
  static String[] grid = new String[140];
  static final String word = "XMAS";
  static int total;
  public static void main(String[] args) {
    DayFour z = new DayFour();
    // z.partOne();
    // z.partTwo();
  }
  // PART ONE
  static void partOne() {
    total = 0;
    for (int i = 0; i < 140; i++) {
      grid[i] = scan.nextLine();
    }
    for (int i = 0; i < 140; i++) {
      for (int j = 0; j < 140; j++) {
        if (grid[i].charAt(j) == word.charAt(0)) {
          partOneHelper(word, 0, i, j, 1, 0, 140, 140);
          partOneHelper(word, 0, i, j, -1, 0, 140, 140);
          partOneHelper(word, 0, i, j, 0, -1, 140, 140);
          partOneHelper(word, 0, i, j, 0, 1, 140, 140);
          partOneHelper(word, 0, i, j, 1, -1, 140, 140);
          partOneHelper(word, 0, i, j, -1, -1, 140, 140);
          partOneHelper(word, 0, i, j, 1, 1, 140, 140);
          partOneHelper(word, 0, i, j, -1, 1, 140, 140);
        }
      }
    }
    System.out.println(total);
  }
  static void partOneHelper(String w, int i, int y, int x, int cx, int cy, int r, int c) {
    if (y < 0 || y >= r || x < 0 || x >= c)
      return;
    if (!(grid[y].charAt(x) == w.charAt(i))) {
      return;
    }
    if (i == w.length() - 1) {
      total++;
      return;
    }
    if (grid[y].charAt(x) == w.charAt(i)) {
      partOneHelper(w, i + 1, y + cy, x + cx, cx, cy, r, c);
    }
    return;
  }
  // PART TWO
  static void partTwo() {
    total = 0;
    for (int i = 0; i < 140; i++) {
      grid[i] = scan.nextLine();
    }
    for (int i = 1; i < 139; i++) {
      for (int j = 1; j < 139; j++) {
        if (grid[i].charAt(j) == 'A') {
          if (partTwoHelper(i, j)) {
            total++;
          }
        }
      }
    }
    System.out.println(total);
  }
  static boolean partTwoHelper(int y, int x) {
    if ((grid[y - 1].charAt(x - 1) == 'M' && grid[y + 1].charAt(x + 1) == 'S'
        || grid[y - 1].charAt(x - 1) == 'S' && grid[y + 1].charAt(x + 1) == 'M')
        && (grid[y - 1].charAt(x + 1) == 'M' && grid[y + 1].charAt(x - 1) == 'S'
            || grid[y - 1].charAt(x + 1) == 'S' && grid[y + 1].charAt(x - 1) == 'M')) {
      return true;
    }
    return false;
  }
}
