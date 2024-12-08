/*
 *   Sehan Munir
 *   Day Four {2024-12-04}
 *   Ceres Search
 */
import java.io.*;
import java.util.*;

public class DayFour {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static String[] grid = new String[140];
  static final String word =  "XMAS";
  static int total;
  public void partOne(String w, int i, int y, int x, int cx, int cy, int r, int c){
      if (y < 0 || y >= r || x < 0 || x >= c)
        return;
      if (!(grid[y].charAt(x) == w.charAt(i))){
        return;
      }
      if (i == w.length()-1){
        total++;
        return;
      }
      if (grid[y].charAt(x) == w.charAt(i)){
        partOne(w, i+1, y + cy, x + cx, cx, cy, r, c);
      }
      return;
  }
  public boolean partTwo(int y, int x){
    if((grid[y-1].charAt(x-1)=='M'&&grid[y+1].charAt(x+1)=='S'||grid[y-1].charAt(x-1)=='S'&&grid[y+1].charAt(x+1)=='M')&&(grid[y-1].charAt(x+1)=='M'&&grid[y+1].charAt(x-1)=='S'||grid[y-1].charAt(x+1)=='S'&&grid[y+1].charAt(x-1)=='M')){
        return true;
    }
    return false;
  }
  public static void main(String[] args) throws IOException {
    DayFour z = new DayFour();
    // Actual Code Part One
    /*
      total = 0;
      for (int i = 0; i < 140; i++){
        grid[i] = z.readLine();
      }
      for (int i = 0; i < 140; i++){
        for (int j = 0; j < 140; j++){
            if (grid[i].charAt(j) == word.charAt(0)){
              z.partOne(word, 0, i, j, 1, 0, 140, 140);
              z.partOne(word, 0, i, j, -1, 0, 140, 140);
              z.partOne(word, 0, i, j, 0, -1, 140, 140);
              z.partOne(word, 0, i, j, 0, 1, 140, 140);
              
              
              z.partOne(word, 0, i, j, 1, -1, 140, 140);
              z.partOne(word, 0, i, j, -1, -1, 140, 140);
              z.partOne(word, 0, i, j, 1, 1, 140, 140);
              z.partOne(word, 0, i, j, -1, 1, 140, 140);
            }
        }
      }
      System.out.println(total);
    */
    // Actual Code Part Two
    /*
      total = 0;
      for (int i = 0; i < 140; i++){
        grid[i] = z.readLine();
      }
      for (int i = 1; i < 139; i++){
        for (int j = 1; j < 139; j++){
            if (grid[i].charAt(j)=='A'){
              if (z.partTwo(i,j)){
                total++;
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