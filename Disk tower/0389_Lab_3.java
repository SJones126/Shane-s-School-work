UIN:0389
Lab3
Course ID:3530
CRN:10413
import java.util.Scanner;

public class lab3 {
  private void Tower(int d, char beginning, char end, char extra) {
    if (d == 1) {//checks to see there is only one disk in a slot so it can move it
      System.out
          .println("MOVE disk 1 FROM Peg " + beginning + " TO Peg " + end);
      return;
    }
   
    Tower(d - 1, beginning, extra , end);//moves the disks to other slots
    System.out.println(
        "Move disk " + d + " FROM Peg " + beginning + " TO Peg " + end);
    Tower(d - 1, extra, end, beginning);
  }

  public static void main(String args[]) {
    lab3 towerOfHanoi = new lab3();
    System.out.println("Enter number of discs: ");//asks user for input
    Scanner scan = new Scanner(System.in);//scans in what is asked from the user
    int circles = scan.nextInt();// places the input into the disks named circles
    towerOfHanoi.Tower(circles, 'A', 'B', 'C');
  }
}
