package symulation;

public class Dystrybutor extends Thread{

	@Override
	public void run(){

	}

	public synchronized void uzupełnij() {

		try {
			wait(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
