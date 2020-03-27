//0389
//Assignment1
public class CharStack{/// creates a char stack
	private final int STACKSIZE=100;
	private int beginning;
	private char[] operators; 
	
	public CharStack() {  //creating a stack object
	 	operators = new char [STACKSIZE];
	 	beginning= -1;        // indicates the stack is empty
	}// end constructor
	
	public void push(char x){
	 	if(beginning == STACKSIZE-1){
	 		System.out.println("Stack Overflow");
	 		System.exit(1);
	 	}
	  	operators[++beginning]= x;  
	} //end push

	
	public char pop(){
	 	if(empty()){  
	 		System.out.println("Stack Underflow");
	 		System.exit(1);
	 	}
	 	return operators[beginning--];
	}
	
	public boolean empty(){ 
	  	if(beginning == -1)
	 		return true;
	  	else
	 		return false;
	}
	
	public char peek() {
		if(empty()){  
	 		System.out.println("Stack Underflow");
	 		System.exit(1);
	 	}
		return operators[beginning];
	}
}
