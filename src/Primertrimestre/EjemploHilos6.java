package Primertrimestre;


public class EjemploHilos6 extends Thread{
	public void run() {
		while (!isInterrupted()) { // para invocar interrupted --> Thread.currentThread().isInterrupted()
			System.out.println("en el hilo");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		EjemploHilos6 h =  new EjemploHilos6();
		h.start();
		Thread.sleep(2000);
		h.interrupt();
		h.join();
		System.out.println("hilo finalizado");
	}
}
