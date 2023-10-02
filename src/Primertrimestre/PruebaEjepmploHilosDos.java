package Primertrimestre;

public class PruebaEjepmploHilosDos {
	public static void main(String[] args) throws InterruptedException {
		for(int i=1;i<=3;i++) {
			new Thread("hilo" +i) {	
				@Override
				public void run() { //que es lo que va a hacer este hilo
					for(int i=1	;i<=5;i++) { //numero de veces que haga lo de abajo
						try {
						Thread.sleep(100);
						} catch (InterruptedException e) {} 
						System.out.println(getName()+", mensaje" +i);
					}	
				}
			}.start();
			Thread.sleep(300);
		}
		
	}
}
