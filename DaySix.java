/*
 *   Sehan Munir
 *   Day Six {2024-12-06}
 *   Guard Gallivant 
 */
import java.io.*;
import java.util.*;

public class DaySix {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int total;
  static String[] ar;
  static int startX;
  static int startY;
  static int startDir = 1;
  static int totalTwo;
  public static void dfs(int y, int x, int dir){
    if (y==-1||x==130||x==-1||y==130){
        return;
    }
    ar[y] = ar[y].substring(0,x) + "X" + ar[y].substring(x+1);
    if (dir == 1){
        if (y==0){
            return;
        }
        if (ar[y-1].charAt(x)=='#'){
            dir = 2;
        }
    } else if (dir == 2){
        if (x==129){
            return;
        } else {
        if (ar[y].charAt(x+1)=='#'){
            dir = 3;
        }}
    } else if (dir == 3){
        if (y==129){
            return;
        }
        if (ar[y+1].charAt(x)=='#'){
            dir = 4;
        }
    } else if (dir == 4){
        if (x==0){
            return;
        }
        if (ar[y].charAt(x-1)=='#'){
            dir = 1;
        }
    }
    if (dir==1){dfs(y-1,x,dir);}
    else if (dir==2){dfs(y,x+1,dir);}
    else if (dir==3){dfs(y+1,x,dir);}
    else if (dir==4){dfs(y,x-1,dir);}
    return;
  }
  public static void main(String[] args) throws IOException {
    DaySix z = new DaySix();
    // Actual Code Part One
    /*
      total = 0;
      ar = new String[130];
      for (int i = 0; i < 130; i++){
        ar[i] = z.readLine();
      }
      for (int i = 0; i < 130; i++){
        for (int j = 0; j < 130; j++){
            if (ar[i].charAt(j)=='^'){
                ar[i] = ar[i].substring(0,j) + "X" + ar[i].substring(j+1);
                z.dfs(i,j,1);
            }
        }
      }
      for (int i = 0; i < 130; i++){
        for (int j = 0; j < 130; j++){
            if (ar[i].charAt(j)=='X'){
                total++;
            }
        }
      }
      System.out.println(total);
    */
    // Actual Code Part Two
    /* */
    int sizer = 130;
    int sizec = 130;
      totalTwo = 0;
      ar = new String[sizer];
      for (int i = 0; i < sizer; i++){
        ar[i] = z.readLine();
      }
      for (int i = 0; i < sizer; i++){
        for (int j = 0; j < sizec; j++){
            if (ar[i].charAt(j)=='^'){
                startX = j;
                startY = i;
            }
        }
      }
      HashMap<String, String> alreadyGone = new HashMap<>();
      int dir = 1;
      int block = 0;
      for (int i = 0; i < sizer; i++){
        for (int j = 0; j < sizec; j++){
            block++;
            if (!(((i==startY&&j==startX))||(ar[i].charAt(j)=='#'))){
                ar[i] = ar[i].substring(0, j) + "#" + ar[i].substring(j + 1);
                alreadyGone.clear();
                int y = startY;
                int x = startX;
                dir = 1;
                while (true){
                    if (alreadyGone.containsKey(y+" "+x)){
                        if (alreadyGone.get(y+" "+x).charAt(dir-1)=='X'){
                            totalTwo++;
                            break;
                        } else {
                            if (dir==1){
                                alreadyGone.put(y+" "+x,alreadyGone.get(y+" "+x).replace('a','X'));
                            } else if (dir==2){
                                alreadyGone.put(y+" "+x,alreadyGone.get(y+" "+x).replace('b','X'));
                            } else if (dir==3){
                                alreadyGone.put(y+" "+x,alreadyGone.get(y+" "+x).replace('c','X'));
                            } else if (dir==4){
                                alreadyGone.put(y+" "+x,alreadyGone.get(y+" "+x).replace('d','X'));
                            }
                        }
                    } else {
                        alreadyGone.put(y+" "+x,"abcd");
                        if (dir==1){
                            alreadyGone.put(y+" "+x,alreadyGone.get(y+" "+x).replace('a','X'));
                        } else if (dir==2){
                            alreadyGone.put(y+" "+x,alreadyGone.get(y+" "+x).replace('b','X'));
                        } else if (dir==3){
                            alreadyGone.put(y+" "+x,alreadyGone.get(y+" "+x).replace('c','X'));
                        } else if (dir==4){
                            alreadyGone.put(y+" "+x,alreadyGone.get(y+" "+x).replace('d','X'));
                        }
                    }
                    if (dir == 1){
                        for (int a = y; a >= 0; a--){
                            if (ar[a].charAt(x)=='#'){
                                y = a+1;
                                dir = 2;
                                break;
                            }if (a == 0){y=0;}
                        }
                        if (y == 0){break;}
                    }
                    if (dir == 2){
                        for (int b = x; b < sizec; b++){
                            if (ar[y].charAt(b)=='#'){
                                x = b-1;
                                dir = 3;
                                break;
                            }if (b == sizec-1){x=sizec-1;}
                        }
                        if (x == sizec-1){break;}
                    }
                    if (dir == 3){
                        for (int c = y; c < sizer; c++){
                            if (ar[c].charAt(x)=='#'){
                                y = c-1;
                                dir = 4;
                                break;
                            } if (c == sizer-1){y=sizer-1;}
                        }
                        if (y == sizer-1){break;}
                    }
                    if (dir == 4){
                        for (int d = x; d >=0; d--){
                            if (ar[y].charAt(d)=='#'){
                                x = d+1;
                                dir = 1;
                                break;
                            }if (d == 0){x=0;}
                        }
                        if (x == 0){break;}
                    }
                }
                ar[i] = ar[i].substring(0, j) + "." + ar[i].substring(j + 1);
            }
        }
      }
      System.out.println(totalTwo);
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