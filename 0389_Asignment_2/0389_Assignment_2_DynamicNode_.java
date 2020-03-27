/* 
 0389
 Assignment #2
 Course ID: 3530
 CRN: 10413
 */import java.util.Iterator;

public class DynamicNode {
	Object info;
	DynamicNode next;
	/* getInfo(), setInfo(), setNext(), getNext() */

	// constructor
		public DynamicNode() {
			
		}
	
	// constructor
	public DynamicNode(Object x, DynamicNode n) {
		info = x;
		next = n;
			}

	// get data in a node
	public Object getInfo() {
		return info;
	}

	// get reference in a node
	public DynamicNode getNext() {
		return next;
	}

	// set value of the object
	public void setInfo(Object x) {
		info = x;

	}

	// set reference to a node
	public void setNext(DynamicNode n) {

		next = n;
	}

	public int compareTo(DynamicNode b) {//did a compare to method is called and used for the union.

        String l1 = "";

        String l2 = "";

       

        l1 = this.info.toString();

        l2 = b.info.toString();

       

        int info1,info2;

        info1 = Integer.parseInt(l1);

        info2 = Integer.parseInt(l2);



        return Integer.compare(info1, info2);

}
	
}// end dynamic node class
