package Primertrimestre;

public class EjemploHilos5 extends Thread{

	private volatile boolean finalizar = false; 
	//es una variable flag el volatile hece que el hilo no guarde ninguna cache evita que el hilo cree una copia
	//solo se autaliza el hilo principal
	@Override
	public void run () {
		while(!finalizar) {
			System.out.println("en el hilo");
			try {
				Thread.sleep(200);
			}catch (Exception e) {}
		}
		System.out.println("hilo finalizado");
	}
	public void finalizar () {
		finalizar = true;
	}
	public static void main(String[] args) throws InterruptedException {
		EjemploHilos5 t = new EjemploHilos5();
		t.start();
		Thread.sleep(2000);
		t.finalizar();
	}

}
