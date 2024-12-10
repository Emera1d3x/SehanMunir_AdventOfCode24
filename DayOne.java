/*
 *   Sehan Munir
 *   Day One {2024-12-01}
 *   Historia Hysteria
 */
import java.util.*;

public class DayOne {
  static Scanner scan = new Scanner(System.in);
  public static void main(String[] args){
    DayOne z = new DayOne();
    System.out.println("Type \"-1\" after input is done: ");
    // z.partOne();
    // z.partTwo();
  }
  // PART ONE
  static void partOne() {
    ArrayList<Integer> setOne = new ArrayList<>();
    ArrayList<Integer> setTwo = new ArrayList<>();
    int dist = 0;
    int size;
    int numOne;
    int numTwo;
    while (true) {
      numOne = scan.nextInt();
      if (numOne == -1) {
        break;
      }
      numTwo = scan.nextInt();
      setOne.add(numOne);
      setTwo.add(numTwo);
    }
    Collections.sort(setOne);
    Collections.sort(setTwo);
    size = setOne.size();
    for (int i = 0; i < size; i++) {
      dist += Math.abs(setOne.get(i) - setTwo.get(i));
    }
    System.out.println(dist);
  }
  // PART TWO
  static void partTwo() {
    ArrayList<Integer> setOne = new ArrayList<>();
    HashMap<Integer, Integer> setTwo = new HashMap<Integer, Integer>();
    int ans = 0;
    int numOne;
    int numTwo;
    while (true) {
      numOne = scan.nextInt();
      if (numOne == -1) {
        break;
      }
      numTwo = scan.nextInt();
      setOne.add(numOne);
      if (!setTwo.containsKey(numTwo)) {
        setTwo.put(numTwo, 1);
      } else {
        setTwo.put(numTwo, setTwo.get(numTwo) + 1);
      }
    }
    for (int num : setOne) {
      if (setTwo.containsKey(num)) {
        ans += Math.abs(num * setTwo.get(num));
      }
    }
    System.out.println(ans);
  }
}
