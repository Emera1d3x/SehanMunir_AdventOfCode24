/*
 *   Sehan Munir
 *   Day Seven {2024-12-07}
 *   Bridge Repair
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class DaySeven {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    DaySeven z = new DaySeven();
    // Actual Code Part One
    /*
      long ans = 0;
      while (true){
        String cur = z.readLine();
        if (cur.equals("-1")){
            break;
        }
        String[] operation = cur.split(": ");
        long res = Long.parseLong(operation[0]);
        String[] nums = operation[1].split(" ");
        long[] ns = new long[nums.length];
        for (int i = 0; i < nums.length; i++){
            ns[i] = Long.parseLong(nums[i]);
        }
        boolean works = false;
        for (int mask = 0; mask < (int) Math.pow(2, ns.length - 1); mask++) {
            long result = ns[0];
            for (int i = 0; i < ns.length - 1; i++) {
                if ((mask / (int) Math.pow(2, i)) % 2 == 0) { 
                    result += ns[i + 1];
                } else { 
                    result *= ns[i + 1];
                }
            }
            if (result == res) {
                ans += res;
                break;
            }
        }
      }
      System.out.println(ans);
    */
    // Actual Code Part Two
    /*
      long ans = 0;
      while (true){
        String cur = z.readLine();
        if (cur.equals("-1")){
            break;
        }
        String[] operation = cur.split(": ");
        long res = Long.parseLong(operation[0]);
        String[] nums = operation[1].split(" ");
        long[] ns = new long[nums.length];
        for (int i = 0; i < nums.length; i++){
            ns[i] = Long.parseLong(nums[i]);
        }
        boolean works = false;
        for (int combID = 0; combID < (int) Math.pow(2, ns.length - 1); combID++) {
            long result = ns[0];
            for (int i = 0; i < ns.length - 1; i++) {
                if ((combID / (int) Math.pow(2, i)) % 2 == 0) { 
                    result += ns[i + 1];
                } else { 
                    result *= ns[i + 1];
                }
            }
            if (result == res) {
                ans += res;
                works = true;
                break;
            }
        }
        if(!works){
            for (int combID = 0; combID < (int) Math.pow(3, ns.length - 1); combID++) {
                long result = ns[0];
                for (int i = 0; i < ns.length - 1; i++) {
                    int op = combID % 3;
                    combID /= 3;
                    if (op == 0) { 
                        result += ns[i + 1];
                    } else if (op == 1) {
                        result *= ns[i + 1];
                    } else if (op == 2) {
                        result = Long.parseLong(result + "" + ns[i + 1]);
                    }
                }
                if (result == res) {
                    ans += res;
                    break;
                }
            }
        }
      }
      System.out.println(ans);
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