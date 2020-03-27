
public class show {
	public static void main(String[] args) {
		ReactionArea reactarea= new ReactionArea();
		Thread hydrogen = new Thread(new Hydrogen(reactarea));
		Thread oxygen = new Thread(new Oxygen(reactarea));
		Thread reactor = new Thread(new Reactor(reactarea));
		hydrogen.start();
		oxygen.start();
		reactor.start();
	}

}
