0389_Lab_1      COP3530
import java.lang.reflect.Array;
import java.util.*;

public class createData {
    Random rand = new Random();
    public static void printData(int[][][] data) {//where the array is printed
    	 int i, j,k; 
         for (i = 0; i < data.length; i++) {
             System.out.println("Frame" + i + ": ");
        	 for (j = 0; j < data[i].length; j++) {
                 for(k=0;k<data[i][j].length;k++) {
                 	System.out.print(data[i][j][k] + "     ");
                 }
             System.out.println("");    
             }
         }
    	}
    
    public static void main(String args[]) {//where everything is called for the following function.

        int data[][][];
        data = createData();
        printData(data);
    }

	private static int[][][] createData() {//where the random 3d array is produced.
		 Random rand = new Random();
		    int r = rand.nextInt(5) + 1;//creates random numbers between 1-5
		int data[][][]  = new int[r][][];
        int i, j,k; //initializes i,j and k 
        r = rand.nextInt(5)+1;
        for (i = 0; i < data.length; i++) {//sets the length for i in the array
            r = rand.nextInt(5)+1;
            data[i] = new int[r][];//puts a new random for the next column in the array
            for (j = 0; j < data[i].length; j++) {//goes through the length of the j column of the array
                r=rand.nextInt(5)+1;
                data[i][j] = new int[r];//sets r for the depth of the array
                for(k=0;k<data[i][j].length;k++) {//goes through the entire Array
                	r=rand.nextInt(5)+1;
                	data[i][j][k] = r;//sets all of the appropriate numbers into the array
                }
                
            }
        }
		return data;//returns data
	}
}