package Repaso;

public class Ejemplo5 extends Thread{
	 static boolean finalizar = false;  
	
	
	
	public void run() {
		while (!finalizar) {
			System.out.println("en el hilo");
			try {
				Thread.sleep(200);
			} catch (Exception e) {}
		}
		
		
		
		System.out.println("hilo finalizado");
	}
	public static void main(String[] args) throws InterruptedException {
		Ejemplo5 hilo = new Ejemplo5();
		hilo.start();
		Thread.sleep(2000);
		finalizar = true;
		System.out.println("main finalizado");
	}
}
