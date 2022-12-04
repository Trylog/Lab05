package main;

import symulation.Organizm;

public class Linia {
	int długość;
	boolean[] linia;
	public Organizm[] hodowla;
	public Linia(int dł){
		długość=dł;
		linia = new boolean[długość];
		hodowla =new Organizm[dł];
		for (int i = 0;i<dł;i++){
			hodowla[i] =new Organizm();
			hodowla[i].start();
			hodowla[i].setName("Organizm " + i);
		}
	}
	public synchronized int spróbujZająć(int poz, boolean kierunek) {
		if (kierunek){
			if(poz+1>=0&&poz+1<=długość-1&&linia[poz+1]==false){
				linia[poz+1]=true;
				linia[poz]=false;
				return poz+1;
			}else if(poz-1>=0&&poz-1<=długość-1&&linia[poz-1]==false){
				linia[poz-1]=true;
				linia[poz]=false;
				return poz-1;
			}else return poz;
		}else {
			if(poz-1>=0&&poz-1<=długość-1&&linia[poz-1]==false){
				linia[poz-1]=true;
				linia[poz]=false;
				return poz-1;
			}else if(poz+1>=0&&poz+1<=długość-1&&linia[poz+1]==false){
				linia[poz+1]=true;
				linia[poz]=false;
				return poz+1;
			}else return poz;
		}


	}

}
