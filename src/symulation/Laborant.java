package symulation;

import main.Linia;
import main.Main;

public class Laborant extends Thread{
	public int zbiornik;
	public int pozycja;
	private static int maxId=0;
	private int id;
	boolean kierunek;
	//int test;
	@Override
	public void run(){
		while(true){
			if(zbiornik<1)uzupełnijZbiornik();
			int temp =pozycja;
			pozycja = Main.linia.spróbujZająć(pozycja, kierunek);
			if(pozycja-temp<0) kierunek=false;
			if(pozycja-temp>0) kierunek=true;

			if(Main.linia.hodowla[pozycja].isAlive()){

				zbiornik-=Main.linia.hodowla[pozycja].nakarm(zbiornik);
			}

			//System.out.println(test);
			//test++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//if (test%13==0)uzupełnijZbiornik();
		}
	}
	public Laborant(int pozycja, boolean kierunek){
		id=maxId;
		maxId++;
		this.pozycja=pozycja;
		this.kierunek=kierunek;
		zbiornik=50;
		//test=0;
	}
	private synchronized void uzupełnijZbiornik(){
		int temp=pozycja;
		Main.dystrybutor.uzupełnij(this);
		zbiornik=50;
		try {
			pozycja = Main.linia.wróćNaLinie(temp);
		} catch (Exception e) {
			System.out.println("Błąd miejsca na linii");
		}
	}
}
