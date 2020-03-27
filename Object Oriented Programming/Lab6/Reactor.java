public class Reactor implements Runnable{
	ReactionArea buff;
	Reactor(ReactionArea buff){
		this.buff=buff;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i =0; i<10; i++) {
			try {
				
				buff.react(i);
				Thread.sleep(50);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}