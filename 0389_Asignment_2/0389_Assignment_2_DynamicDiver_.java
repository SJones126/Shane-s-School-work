/* 
 0389
 Assignment #2
 Course ID: 3530
 CRN: 10413
 */
import java.util.LinkedList;

public class DynamicDriver {

	public static void main(String args[]) {

		DynamicList list, list2,d1,llist2 = null; 

		list = new DynamicList();
		list2 = new DynamicList();
		d1 = new DynamicList();
		 //creates a list for list one and list 2 and uses it to concat and reverse.
		list.insertLast(new IntData(1));
		list.insertLast(new IntData(2));
		list.insertLast(new IntData(3));
		System.out.println();
		list.print();
		
		list2.insertLast(new IntData(4));
		list2.insertLast(new IntData(5));
		list2.insertLast(new IntData(6));
		System.out.println();
		list2.print();
		
		list.Concat(list2);
		System.out.println();
		list.print();
		System.out.println();
		System.out.println(list.SumList());
		
		list.reverseIteratively();
		System.out.println();
		list.print();
		System.out.println();
		
		
		 DynamicList un1 = new DynamicList(); //new list1
		    DynamicList un2 = new DynamicList();//new list 2
		    DynamicList int1;
		    DynamicList int2;
		    //creates a new list for union and intersection
		    un1.insertLast(new IntData(5));
		    un1.insertLast(new IntData(6));
		    un1.insertLast(new IntData(7));
		    un1.insertLast(new IntData(8));
		    un1.print();//print elements
		   
		    un2.insertLast(new IntData(5));
		    un2.insertLast(new IntData(6));
		    un2.insertLast(new IntData(8));
		    un2.insertLast(new IntData(9));
		    un2.print();//print elements
		    
		    int1 = un1;
		    int2 = un2;
		    System.out.println();
		    System.out.println("union");
		    un1.union(un2);
		    un1.print();
		    System.out.println();
		    
		    System.out.println("intersection");
		
		int1.intersection(int2);
		int1.print();
		System.out.println();
		System.out.println("Delete Every Second");
		d1 = new DynamicList();//this creates a new list for delete every second
		d1.insertLast(new IntData(1));
		d1.insertLast(new IntData(2));
		d1.insertLast(new IntData(3));
		d1.insertLast(new IntData(4));
		d1.insertLast(new IntData(5));
		d1.insertLast(new IntData(6));
		d1.insertLast(new IntData(7));
		d1.insertLast(new IntData(8));
		
		d1.print();
		d1.deleteEverySecond();//list for delete every second
		d1.print();
	}
}
