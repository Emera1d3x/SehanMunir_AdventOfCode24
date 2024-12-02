/*
 *   Sehan Munir
 *   Day One {2024-12-01}
 *   Historia Hysteria
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class DayOne {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    DayOne z = new DayOne();
    // Actual Code Part One
    /*
      ArrayList<Integer> setOne = new ArrayList<>();
      ArrayList<Integer> setTwo = new ArrayList<>();
      int dist = 0;
      int size;
      int numOne;
      int numTwo;
      while (true){
        numOne = z.readInt();
        if (numOne == -1){
          break;
        }
        numTwo = z.readInt();
        setOne.add(numOne);
        setTwo.add(numTwo);
      }
      Collections.sort(setOne);
      Collections.sort(setTwo);
      size = setOne.size();
      for (int i = 0; i < size; i++){
        dist+=Math.abs(setOne.get(i)-setTwo.get(i));
      }
      System.out.println(dist);
    */
    // Actual Code Part Two
    /*
      ArrayList<Integer> setOne = new ArrayList<>();
      HashMap<Integer, Integer> setTwo = new HashMap<Integer, Integer>();
      int ans = 0;
      int numOne;
      int numTwo;
      while (true){
        numOne = z.readInt();
        if (numOne == -1){
          break;
        }
        numTwo = z.readInt();
        setOne.add(numOne);
        if (!setTwo.containsKey(numTwo)){
          setTwo.put(numTwo, 1);
        } else {
          setTwo.put(numTwo, setTwo.get(numTwo)+1);
        }
      }
      for (int num : setOne) {
        if (setTwo.containsKey(num)) {
            ans += Math.abs(num * setTwo.get(num));
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