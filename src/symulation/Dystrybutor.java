package symulation;

import main.Main;

public class Dystrybutor{

	public synchronized void uzupełnij(Laborant lab) {
		try {
			Main.linia.uwolnij(lab.pozycja);
			lab.pozycja=-1;
			Thread.sleep(Main.czasDystrybutor);
			System.out.println("koniec uzupełniania");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
