/*
 *   Sehan Munir
 *   Day Three {2024-12-03}
 *   Mull It Over
 */
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class DayThree {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    DayThree z = new DayThree();
    Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
    Pattern doPattern = Pattern.compile("do\\(\\)");
    Pattern dontPattern = Pattern.compile("don't\\(\\)");
    // Actual Code Part One
    /*
      int total = 0;
      String cur;
      while (true){
        cur = z.readLine();
        if (cur.equals("-1")){
            break;
        }
        Matcher matcher = pattern.matcher(cur);
        while (matcher.find()) {
          int a = Integer.parseInt(matcher.group(1));
          int b = Integer.parseInt(matcher.group(2));
          total += a*b;
        }
      }
      System.out.println(total);
    */
    // Actual Code Part Two
    /*
      boolean mulEnabled = true;
      int total = 0;
      String cur;
      while (true){
        cur = z.readLine();
        if (cur.equals("-1")){
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