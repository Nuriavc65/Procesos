package Primertrimestre;

public class EjemploHilos extends Thread{

	public EjemploHilos(int id){
		super("hilo" +id);
	}
	@Override
	public void run() { //que es lo que va a hacer este hilo
		for(int i=1	;i<=5;i++) { //numero de veces que haga lo de abajo
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {} 
				System.out.println(getName()+", mensaje" +i);
		}
			
	}
}
