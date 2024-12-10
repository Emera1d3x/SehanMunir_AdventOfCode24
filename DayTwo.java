/*
 *   Sehan Munir
 *   Day Two {2024-12-02}
 *   Red-Nosed Reports
 */
import java.util.*;

public class DayTwo {
  static Scanner scan = new Scanner(System.in);
  public static void main(String[] args){
    DayTwo z = new DayTwo();
    System.out.println("Type \"-1\" after input is done: ");
    // z.partOne();
    // z.partTwo();
  }
  // PART ONE
  static void partOne() {
    int safe = 0;
    String cur;
    while (true) {
      cur = scan.nextLine();
      if (cur.equals("-1")) {
        break;
      }
      String[] values = cur.split(" ");
      int[] intValues = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
      int size = intValues.length;
      boolean increasing = false;
      boolean decreasing = false;
      for (int i = 1; i < size; i++) {
        int difference = intValues[i - 1] - intValues[i];
        if (!(Math.abs(difference) >= 1 && Math.abs(difference) <= 3)) {
          break;
        }
        if (intValues[i - 1] < intValues[i]) {
          increasing = true;
        }
        if (intValues[i - 1] > intValues[i]) {
          decreasing = true;
        }
        if (increasing && decreasing) {
          break;
        }
        if (i == size - 1) {
          safe++;
        }
      }
    }
    System.out.println(safe);
  }
  // PART TWO
  static void partTwo() {
    int safe = 0;
    String cur;
    while (true) {
      cur = scan.nextLine();
      if (cur.equals("-1")) {
        break;
      }
      String[] values = cur.split(" ");
      int[] intValues = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
      int size = intValues.length;
      boolean increasing = false;
      boolean decreasing = false;
      boolean works = false;
      for (int i = 1; i < size; i++) {
        int difference = intValues[i - 1] - intValues[i];
        if (!(Math.abs(difference) >= 1 && Math.abs(difference) <= 3)) {
          break;
        }
        if (intValues[i - 1] < intValues[i]) {
          increasing = true;
        }
        if (intValues[i - 1] > intValues[i]) {
          decreasing = true;
        }
        if (increasing && decreasing) {
          break;
        }
        if (i == size - 1) {
          works = true;
        }
      }
      if (works) {
        safe++;
      } else {
        for (int x = 0; x < size; x++) {
          works = true;
          increasing = false;
          decreasing = false;
          for (int i = 1; i < size; i++) {
            int one, two;
            if ((i - 1) == x) {
              if ((i - 2) < 0)
                continue;
              one = intValues[i - 2];
              two = intValues[i];
            } else if (i == x) {
              if ((i + 1) >= size)
                continue;
              one = intValues[i - 1];
              two = intValues[i + 1];
            } else {
              one = intValues[i - 1];
              two = intValues[i];
            }
            int difference = one - two;
            if (!(Math.abs(difference) >= 1 && Math.abs(difference) <= 3)) {
              works = false;
              break;
            }
            if (one < two)
              increasing = true;
            if (one > two)
              decreasing = true;
            if (increasing && decreasing) {
              works = false;
              break;
            }
          }
          if (works) {
            safe++;
            break;
          }
        }
      }
    }
    System.out.println(safe);
  }
}
