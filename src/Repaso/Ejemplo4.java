package Repaso;

public class Ejemplo4 {
	public static void main(String[] args) throws InterruptedException {
		Thread hilo = new Thread("CUENTA ATRAS") {
			public void run() {
				for(int i=5;i>=0;i--) { //repite el hilo desde cinco
					System.out.println(i);
					try {
						Thread.sleep(1000);
					}catch (Exception e) {}
				}
				System.out.println("hilo finalizado");
			}
		};
		hilo.start();	//el hilo de cuenta atras comienza
		hilo.join(); //una vez que termine su accion se une al main 
		System.out.println("metodo main finalizado");
	}
}