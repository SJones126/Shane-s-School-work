	public class Hydrogen implements Runnable{
	
			ReactionArea buff;
			
			public Hydrogen(ReactionArea buff) {
				this.buff=buff;
			}
			public void run() {
				for(int i = 0; i<20; i++){
					try {
						buff.increWHydrogen(i);
						Thread.sleep(100);
					}
					catch(InterruptedException e) {
						e.printStackTrace();
						System.exit(1);
					}
				}
			}
		}