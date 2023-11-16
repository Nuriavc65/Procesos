package Repaso;

public class Ejemplo6 extends Thread{
	@Override
	public void run() {
		while(!isInterrupted()) { //mientras el hilo no es interrumpido
			System.out.println("en el hilo"); 
			try {
				Thread.sleep(200); //el hilo se duerme durente el tiempo indicado
			} catch (Exception e) {
				System.out.println("interrumpido mientras dormia"); //
				interrupt(); //se interrumpe la ejecucion del hilo 
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Ejemplo6 hilo = new Ejemplo6(); // creo el hilo 
		hilo.start(); //el hilo comienza a hacer su funcion
		Thread.sleep(2000); // el hilo main se para el tiempo indicado
		hilo.interrupt(); //se interrumpe la ejecucion del hilo 
		hilo.join(); //una vez que termina su funcion vuelve a la linea temporal del main
		System.out.println("hilo finalizado");
	}
}
