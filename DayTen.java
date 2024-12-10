/*
 *   Sehan Munir
 *   Day Nine {2024-12-10}
 *   Hoof It
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class DayTen {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int[][] map = new int[55][55];
  static int[][][] memo = new int[55][55][10];
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    DayTen z = new DayTen();
    // Actual Code Part One
    /*
    System.out.println("TEST");
    for (int i = 0; i < 55; i++) {
      String line = readLine();
      for (int j = 0; j < 55; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }
    int totalScore = 0;
    for (int i = 0; i < 55; i++) {
      for (int j = 0; j < 55; j++) {
        if (map[i][j] == 0) {
          boolean[][] visited = new boolean[55][55];
          Queue<int[]> queue = new LinkedList<>();
          Set<String> reachableNines = new HashSet<>();
          queue.add(new int[]{i, j});
          visited[i][j] = true;
          while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            for (int d = 0; d < 4; d++) {
              int nx = x + dx[d];
              int ny = y + dy[d];
              if (nx >= 0 && nx < 55&& ny >= 0 && ny < 55 && !visited[nx][ny]) {
                if (map[nx][ny] == map[x][y] + 1) {
                  visited[nx][ny] = true;
                  queue.add(new int[]{nx, ny});
                  if (map[nx][ny] == 9) {
                    reachableNines.add(nx + "," + ny);
                  }
                }
              }
            }
          }
          totalScore += reachableNines.size();
        }
      }
    }
    System.out.println(totalScore);
    */
    // Actual Code Part Two
    /*
    for (int i = 0; i < 55; i++) {
      String line = readLine();
      for (int j = 0; j < 55; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }
    for (int[][] row : memo)
      for (int[] cell : row)
        Arrays.fill(cell, -1);
    int totalScore = 0;
    for (int i = 0; i < 55; i++) {
      for (int j = 0; j < 55; j++) {
        if (map[i][j] == 0) {
            totalScore += dfs(i, j, 0);
        }
      }
    }
    System.out.println(totalScore);
    */
  }
  static int dfs(int x, int y, int height) {
    if (map[x][y] == 9) return 1;
    if (memo[x][y][height] != -1) return memo[x][y][height];
    int trails = 0;
    for (int d = 0; d < 4; d++) {
      int nx = x + dx[d];
      int ny = y + dy[d];
      if (nx >= 0 && nx < 55 && ny >= 0 && ny < 55 && map[nx][ny] == map[x][y] + 1) {
        trails += dfs(nx, ny, map[nx][ny]);
      }
    }
    memo[x][y][height] = trails;
    return trails;
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