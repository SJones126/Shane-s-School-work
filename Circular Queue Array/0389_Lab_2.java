
/*
 0389
 Lab2
 COP3530 
 CRN10413
 */
import java.util.Arrays;

public class CircularQueueArray {

	private static final int capacity = 5;// sets the capacity of the size of the queue
	private Object[] Q;
	private final int N; // capacity
	private int front;
	private int rear;

	public CircularQueueArray() {// points to the capacity
		this(capacity);
	}

	public CircularQueueArray(int capacity) {// set in to capacity
		N = capacity;
		Q = new Object[N];
	}

	public int size() {// returns the size for when it is called
		if (rear > front)
			return rear - front;
		return N - front + rear;
	}

	// says if the program is full or empty. this is a double edge even in full it
	// return true for both
	// r=f and f=r will make empty and full true no matter what I tried to
	// manipulate
	public boolean Empty() {
		if (front == rear)
			return true;
		else
			return false;
	}

	public boolean Full() {// see comment of empty
		if (rear == front)
			return true;
		else
			return false;
	}

	public void enqueue(Object x) throws Exception {// this add the letter to the queue

		Q[rear] = x;
		rear = (rear + 1) % N;

	}

	public Object dequeue() throws Exception {// deletes the letter from the queue
		Object item;
		item = Q[front];
		Q[front] = null;
		front = (front + 1) % N;
		return item;
	}

	public void print() {// prints the queue how it needs to be displayed for the assignment
		for (int i = 0; i < Q.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int j = 0; j < Q.length; j++) {
			if (Q[j] == null) {
				Q[j] = " ";
			}
			System.out.print(Q[j] + " ");
		}
		System.out.println();
		System.out.println("Front: " + rear);
		System.out.println("Rear: " + front);
		System.out.println("Size: " + size());
		System.out.println("Empty: " + Empty());
		System.out.println("Full: " + Full());
		System.out.println();
	}

	public static void main(String[] args) throws Exception {// adds and deletes and prints the entire program
		CircularQueueArray q = new CircularQueueArray();
		q.enqueue("A");
		q.print();

		q.enqueue("B");
		q.print();

		q.enqueue("C");
		q.print();

		q.enqueue("D");
		q.print();

		q.enqueue("E");
		q.print();

		q.dequeue();
		q.print();

		q.dequeue();
		q.print();

		q.enqueue("F");
		q.print();

		q.enqueue("G");
		q.print();

		q.dequeue();
		q.print();

		q.dequeue();
		q.print();

		q.dequeue();
		q.print();

		q.dequeue();
		q.print();

		q.dequeue();
		q.print();
	}
}