package Primertrimestre;

public class PruebaEjemplHilos {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(3000);
		for(int i=1;i<=3;i++) {
			new EjemploHilos(i).start();
			//los hilos no van a salir en uno orden epsecifico
		}
	}

}
