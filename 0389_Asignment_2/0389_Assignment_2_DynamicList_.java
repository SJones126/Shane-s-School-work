/* 
 0389
 Assignment #2
 Course ID: 3530
 CRN: 10413
 */
import java.util.Iterator;

public class DynamicList {

	private DynamicNode list;

	public DynamicList() {
		list = null;
	}

	public boolean isEmpty() {//see if it is empty
		return list == null;
	}

	public void insertFirst(Object x) {//operator for insert first
		DynamicNode q = new DynamicNode(x, null);
		if (!isEmpty())
			q.setNext(list);
		list = q;
	}

	public void insertAfter(DynamicNode p, Object x) {//operator for insert after
		if (p == null) {
			System.out.println("void insertion");
			System.exit(1);
		}

		DynamicNode q = new DynamicNode(x, p.getNext());
		p.setNext(q);
	}

	public Object deleteFirst() {//operator for delete first
		if (isEmpty()) {
			System.out.println("void deletetion");
			System.exit(1);
		}

		Object temp = list.getInfo();
		if (list.getNext() == null)
			list = null;
		else
			list = list.getNext();
		return temp;
	}

	public Object deleteAfter(DynamicNode p) {//operator for delete after
		if (p == null || p.getNext() == null) {
			System.out.println("void deletion");
			System.exit(1);
		}

		DynamicNode q = p.getNext();
		Object temp = q.getInfo();
		p.setNext(q.getNext());
		return temp;
	}

	public void place(Sortable x) {
		DynamicNode p, q = null;
		for (p = list; p != null && x.compareTo(p.getInfo()) > 0; p = p.getNext())
			q = p;
		if (q == null)
			insertFirst(x);
		else
			insertAfter(q, x);

	}

	public void insertLast(Object x) {//operator for insert last
		DynamicNode p = new DynamicNode(x, null);
		DynamicNode q = null;

		if (isEmpty())
			list = p;
		else {

			for (q = list; q.getNext() != null; q = q.getNext())
				;

			q.setNext(p);

		}

	}

	public DynamicNode search(Object x) {//search operator
		DynamicNode p;
		for (p = list; p != null; p = p.getNext())
			if (p.getInfo().equals(x))
				return p;

		return null;
	} // end search

	public void removeX(Object x) {
		DynamicNode p = list, q = null;
		while (p != null) {
			if (p.getInfo().equals(x)) {
				p = p.getNext();
				if (q == null)
					deleteFirst();
				else
					deleteAfter(q);
			} else {
				// advance to the next node in the list
				q = p;
				p = p.getNext();
			}

		} // end while

	}// end removex

	public void print() {//this is the operator to print everything 
		DynamicNode p = list;
		while (p != null) {
			System.out.print(p.info);
			p = p.getNext();
		}
		System.out.println();
	}

	public void reverseIteratively() {//this gets all of the items in list and adjusts them so that the first is last and vice versa
		DynamicNode currNode = list;
		DynamicNode prevNode = null, nextNode = null;

		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		list = prevNode;
		return;
	}

	public void Concat(DynamicList x) {// this combines the first list and the second list 
		DynamicNode p, q;
		DynamicNode r = new DynamicNode();
		p = this.list;
		q = x.list;
		for (r = p; p != null; p = p.getNext()) {
			if (p.next == null) {
				p.setNext(q);

				break;
			}
		}
		this.list = r;

	}

	public int SumList() {//this sums the list of the first and second list. 
		DynamicNode p;

		String y = "";

		int i = 0;

		for (p = list; p != null; p = p.getNext()) {

			y = p.info.toString();

			i += Integer.parseInt(y);
		}
		return i;
	}

	public void union(DynamicList x) {// this has a new list that combines the two lists but does not have the info in the lists repeat

		DynamicNode p, q;

		Object prevp, prevq;

		DynamicList r;

		p = this.list;

		q = x.list;

		prevp = new DynamicNode();

		prevq = new DynamicNode();

		r = new DynamicList();

		while (p != null) {

			if (p.compareTo(q) == 0) {

				r.insertLast(p.info);

			}

			else if (p.compareTo(q) != 0) {

				if (p.info.equals(prevq)) {

					r.insertLast(q.info);

				}

				else if (q.info.equals(prevp)) {

					r.insertLast(p.info);

				}

				else {

					r.insertLast(p.info);

					r.insertLast(q.info);

				}

			}

			prevp = p.info;

			prevq = q.info;

			p = p.getNext();

			q = q.getNext();

		}

		this.list = r.list;

	}

	public void intersection(DynamicList x) {// only prints the variable that is represented twice between the two lists
		DynamicNode p, q;

		Object prevp, prevq;

		DynamicList r;

		p = this.list;

		q = x.list;

		prevp = new DynamicNode();

		prevq = new DynamicNode();

		r = new DynamicList();

		while (p != null && q != null) {

			if (p.compareTo(q) == 0) {

				r.insertLast(p.info);

			}

			else if (p.compareTo(q) != 0) {

				if (p.info.equals(prevq)) {

					r.insertLast(p.info);
				} else if (q.info.equals(prevp)) {

					r.insertLast(q.info);
				} else {

				}
			}

			prevp = p.info;

			prevq = q.info;

			p = p.getNext();

			q = q.getNext();

		}

		this.list = r.list;
	}

	public void deleteEverySecond() {////this deletes every second variable, so it only shows 1357

		// remove every other element in linked list

		DynamicNode p, q;

		DynamicList r = new DynamicList();

		String y = "";

		int value = 0;

		p = this.list;

		while (p != null) {

			y = p.info.toString();

			value = Integer.parseInt(y);

			if (value % 2 == 0) {

			}

			else {

				r.insertLast(p.info);

			}

			p = p.getNext();

		}

		this.list = r.list;

	}

} // end dynamic list
