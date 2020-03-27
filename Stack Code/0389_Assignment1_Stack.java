class Stack {
	private final int STACKSIZE=100;
	private int beginning;
	private double[] finish; 
	
	public Stack() {  //creating a stack object
	 	finish = new double [STACKSIZE];
	 	beginning= -1;        // indicates the stack is empty
	}// end constructor
	
	public void push(double value){
	 	if(beginning == STACKSIZE-1){
	 		System.out.println("Stack Overflow");
	 		System.exit(1);
	 	}
	  	finish[++beginning]= value;   
	} //end push

	
	public double pop(){
	 	if(empty()){  
	 		System.out.println("Stack Underflow");
	 		System.exit(1);
	 	}
	 	return finish[beginning--];
	}
	
	public boolean empty(){ 
	  	if(beginning == -1)
	 		return true;
	  	else
	 		return false;
	}
	
}

