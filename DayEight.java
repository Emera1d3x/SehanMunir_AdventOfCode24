/*
 *   Sehan Munir
 *   Day Eight {2024-12-08}
 *   Resonant Collinearity
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class DayEight {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static String[] ar;
  static String[] effectMap;
  static int ans;
  public static void main(String[] args) throws IOException {
    DayEight z = new DayEight();
    // Actual Code Part One
    /*
      ans = 0;
      ar = new String [50];
      effectMap = new String [50];
      for (int i = 0; i < ar.length; i++){
        String cur = z.readLine();
        ar[i] = cur;
        effectMap[i] = "..................................................";
      }
      HashMap<Character, ArrayList<int[]>> points = new HashMap<>();
      for (int i = 0; i < 50; i++) {
        for (int j = 0; j < 50; j++) {
          if (ar[i].charAt(j) != '.') {
            points.putIfAbsent(ar[i].charAt(j), new ArrayList<>());
            points.get(ar[i].charAt(j)).add(new int[] { i, j });
          }
        }
      }
      for (char freq : points.keySet()) {
        ArrayList<int[]> stuff = points.get(freq);
        int size = stuff.size();
        for (int i = 0; i < size; i++) {
          for (int j = i + 1; j < size; j++) {
            int[] a1 = stuff.get(i);
            int[] a2 = stuff.get(j);
            int dx = a2[0] - a1[0];
            int dy = a2[1] - a1[1];
            int antinode1X = a1[0] - dx;
            int antinode1Y = a1[1] - dy;
            int antinode2X = a2[0] + dx;
            int antinode2Y = a2[1] + dy;
            z.marker(antinode1X, antinode1Y);
            z.marker(antinode2X, antinode2Y);
          }
        }
      }
      for (int i = 0; i < 50; i++){
        for (int j = 0; j < 50; j++){
          if (effectMap[i].charAt(j)=='#'){
            ans++;
          }
        }
      }
      System.out.println(ans);
    */
    // Actual Code Part Two
    /*
      ans = 0;
      ar = new String [50];
      effectMap = new String [50];
      for (int i = 0; i < ar.length; i++){
        String cur = z.readLine();
        ar[i] = cur;
        effectMap[i] = "..................................................";
      }
      HashMap<Character, ArrayList<int[]>> points = new HashMap<>();
      for (int i = 0; i < 50; i++) {
        for (int j = 0; j < 50; j++) {
          if (ar[i].charAt(j) != '.') {
            points.putIfAbsent(ar[i].charAt(j), new ArrayList<>());
            points.get(ar[i].charAt(j)).add(new int[] { i, j });
          }
        }
      }
      for (char freq : points.keySet()) {
        List<int[]> antennas = points.get(freq);
        int size = antennas.size();
        if (size < 2) continue;
        for (int[] antenna : antennas) {
          z.marker(antenna[0], antenna[1]);
        }
        for (int i = 0; i < size; i++) {
          for (int j = i + 1; j < size; j++) {
            int[] a1 = antennas.get(i);
            int[] a2 = antennas.get(j);
            int dx = a2[0] - a1[0];
            int dy = a2[1] - a1[1];
            int gcd = z.gcd(Math.abs(dx), Math.abs(dy));
            dx /= gcd;
            dy /= gcd;
            z.markerLine(a1, a2, dx, dy);
          }
        }
      }
      for (int i = 0; i < 50; i++){
        for (int j = 0; j < 50; j++){
          if (effectMap[i].charAt(j)=='#'){
            ans++;
          }
        }
      }
      System.out.println(ans);
    */
  }
  static void marker(int x, int y) {
    if (x >= 0 && x < 50 && y >= 0 && y < 50) {
      char[] row = effectMap[x].toCharArray();
      row[y] = '#';
      effectMap[x] = new String(row);
    }
  }
  static void markerLine(int[] a1, int[] a2, int dx, int dy) {
    int x = a1[0];
    int y = a1[1];
    while (x >= 0 && x < 50 && y >= 0 && y < 50) {
      marker(x, y);
      x += dx;
      y += dy;
    }
    x = a1[0];
    y = a1[1];
    while (x >= 0 && x < 50 && y >= 0 && y < 50) {
      marker(x, y);
      x -= dx;
      y -= dy;
    }
  }
  static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
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