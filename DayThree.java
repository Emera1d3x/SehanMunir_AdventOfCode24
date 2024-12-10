/*
 *   Sehan Munir
 *   Day Three {2024-12-03}
 *   Mull It Over
 */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {
  static Scanner scan = new Scanner(System.in);
  static Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
  static Pattern doPattern = Pattern.compile("do\\(\\)");
  static Pattern dontPattern = Pattern.compile("don't\\(\\)");
  public static void main(String[] args) {
    DayThree z = new DayThree();
    System.out.println("Type \"-1\" after input is done: ");
    // z.partOne();
    // z.partTwo();
  }
  // PART ONE
  static void partOne() {
    int total = 0;
    String cur;
    while (true) {
      cur = scan.nextLine();
      if (cur.equals("-1")) {
        break;
      }
      Matcher matcher = pattern.matcher(cur);
      while (matcher.find()) {
        int a = Integer.parseInt(matcher.group(1));
        int b = Integer.parseInt(matcher.group(2));
        total += a * b;
      }
    }
    System.out.println(total);

  }
  // PART TWO
  static void partTwo() {
    boolean mulEnabled = true;
    int total = 0;
    String cur;
    while (true) {
      cur = scan.nextLine();
      if (cur.equals("-1")) {
        break;
      }
      String[] parts = cur.split("(?=d)");
      for (String part : parts) {
        Matcher mulMatcher = pattern.matcher(part);
        Matcher doMatcher = doPattern.matcher(part);
        Matcher dontMatcher = dontPattern.matcher(part);
        if (doMatcher.find()) {
          mulEnabled = true;
        }
        if (dontMatcher.find()) {
          mulEnabled = false;
        }
        if (mulEnabled) {
          while (mulMatcher.find()) {
            int a = Integer.parseInt(mulMatcher.group(1));
            int b = Integer.parseInt(mulMatcher.group(2));
            total += a * b;
          }
        }
      }
    }
    System.out.println(total);
  }
}
