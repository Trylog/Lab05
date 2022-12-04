package symulation;

public class Organizm extends Thread{
	public int pożywienie;
	public int żywotność;

	public Organizm(){
		pożywienie=10;
		żywotność=5;
	}
	@Override
	public void run(){

		while (głód()){

			try {
				//System.out.println("sen");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " umiera");
	}
	public synchronized int nakarm(int ilość){
		//System.out.println("mniam mniam");
		if(pożywienie<5){
			żywotność=5;
			if(pożywienie+ilość>10){
				int temp=pożywienie;
				pożywienie=10;
				return 10-temp;
			}else {
				pożywienie+=ilość;
				return ilość;
			}
		}else return 0;
	}
	private synchronized boolean głód(){
		//System.out.println("jestem głodny");
		if(pożywienie==0){
			żywotność-=1;
		}else {
			pożywienie-=1;
		}
		if(żywotność==0){
			return false;
		}
		return true;
	}

}
