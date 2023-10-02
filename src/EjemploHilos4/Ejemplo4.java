package EjemploHilos4;

public class Ejemplo4 {
	public static void main(String[] args) throws InterruptedException {
		Thread hilo = new Thread("cuenta atras") {
			@Override
			public void run(){
				for(int i=5;i>=0;i--) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					}catch (InterruptedException e) {}
				}
				System.out.println("HILO FINALIZADO");
			}
		};
		hilo.start();
		hilo.join();
		System.out.println("METODO FINALIZADO");
	}
}
