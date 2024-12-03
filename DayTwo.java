/*
 *   Sehan Munir
 *   Day Two {2024-12-02}
 *   Red-Nosed Reports
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class DayTwo {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    DayTwo z = new DayTwo();
    // Actual Code Part One
    /*
      int safe = 0;
      String cur;
      while (true){
        cur = z.readLine();
        if (cur.equals("-1")){
            break;
        }
        String[] values = cur.split(" ");
        int[] intValues = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
        int size = intValues.length;
        boolean increasing = false;
        boolean decreasing = false;
        for (int i = 1; i < size; i++){
            int difference = intValues[i-1]-intValues[i];
            if (!(Math.abs(difference)>=1&&Math.abs(difference)<=3)){
                break;
            }
            if (intValues[i-1]<intValues[i]){
                increasing = true;
            }
            if (intValues[i-1]>intValues[i]){
                decreasing = true;
            }
            if (increasing&&decreasing){
                break;
            }
            if (i == size - 1){
                safe++;
            }
        }
      }
      System.out.println(safe);
    */
    // Actual Code Part Two
    /*
      int safe = 0;
      String cur;
      while (true){
        cur = z.readLine();
        if (cur.equals("-1")){
            break;
        }
        String[] values = cur.split(" ");
        int[] intValues = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
        int size = intValues.length;
        boolean increasing = false;
        boolean decreasing = false;
        boolean works = false;
        for (int i = 1; i < size; i++){
            int difference = intValues[i-1]-intValues[i];
            if (!(Math.abs(difference)>=1&&Math.abs(difference)<=3)){
                break;
            }
            if (intValues[i-1]<intValues[i]){
                increasing = true;
            }
            if (intValues[i-1]>intValues[i]){
                decreasing = true;
            }
            if (increasing&&decreasing){
                break;
            }
            if (i == size - 1){
                works=true;
            }
        }
        if (works){
            safe++;
        } else {
            for (int x = 0; x < size; x++) {
                works = true;
                increasing = false;
                decreasing = false;
                for (int i = 1; i < size; i++) {
                    int one, two;
                    if ((i - 1) == x) {
                        if ((i - 2) < 0) continue;
                        one = intValues[i - 2];
                        two = intValues[i];
                    } else if (i == x) {
                        if ((i + 1) >= size) continue;
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
                    if (one < two) increasing = true;
                    if (one > two) decreasing = true;
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