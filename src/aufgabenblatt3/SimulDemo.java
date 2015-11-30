package aufgabenblatt3;

public class SimulDemo {

	public static void main(String[] args) {
		Simulation simulation = new Simulation();
		
		Thread t = new Thread(simulation);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
