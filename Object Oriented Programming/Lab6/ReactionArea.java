class ReactionArea {
	public int waitingHydrogen=0;
	public int waitingOxygen=0;

 	public synchronized void increWHydrogen(int index) throws InterruptedException {
 		
 		while(waitingHydrogen > 5) {
 	 		wait();
 	 	}
 		
 		System.out.println("The " + index + "th Hydrogen Atom was added.");
 		waitingHydrogen++;
 		
 		notifyAll();
 	}
 	public synchronized void increWOxygen(int index) throws InterruptedException {
 		

 		while(waitingOxygen > 2) {
 			wait();
 		}
 		System.out.println("The " + index + "th Oxygen Atom was added.");
 		waitingOxygen++;
 		
 		notifyAll(); 	
 	}
 	
 	public synchronized void react(int index) throws InterruptedException {
 		
		while (waitingHydrogen < 2 || waitingOxygen < 1) {
 			wait();
 		}
 		
 		System.out.println("The " + index + "th Water Molecule was formed.");
 		waitingOxygen--;
 		waitingHydrogen-=2;
 		
 		notifyAll();
 	}
}