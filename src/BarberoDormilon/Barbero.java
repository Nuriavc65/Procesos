package BarberoDormilon;

public class Barbero extends Thread{
	Barberia barberia;
	
	Barbero(Barberia barberia){ 
		this.barberia = barberia;
	}
	
	@Override
	public void run() {
		while(true) {
            System.out.println("Barbero se duerme");
            try {
            	Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
